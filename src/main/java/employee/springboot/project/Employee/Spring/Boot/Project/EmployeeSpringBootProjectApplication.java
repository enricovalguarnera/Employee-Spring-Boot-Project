package employee.springboot.project.Employee.Spring.Boot.Project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import employee.springboot.project.Employee.Spring.Boot.Project.dao.BookDAO;
import employee.springboot.project.Employee.Spring.Boot.Project.dao.EmployeeDAO;
import employee.springboot.project.Employee.Spring.Boot.Project.impl.BookDAOImpl;
import employee.springboot.project.Employee.Spring.Boot.Project.impl.EmployeeDAOImpl;
import employee.springboot.project.Employee.Spring.Boot.Project.model.Book;
import employee.springboot.project.Employee.Spring.Boot.Project.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping(path = "api/v1")
public class EmployeeSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringBootProjectApplication.class, args);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/book/{requestedId}")
	public Book getBook(@PathVariable int requestedId) throws SQLException {
		BookDAO bookDAO = new BookDAOImpl();
		Book book = bookDAO.get(requestedId);
		if (book != null) {
			System.out.println(book);
			return book;
		} else {
			return null;
		}

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-book")
	public String addBook(@RequestBody Book newBook) throws SQLException, JsonProcessingException {
		BookDAO bookDAO = new BookDAOImpl();
		int result = bookDAO.insert(newBook);
		Map<String, Object> object = new HashMap<>();

		ObjectMapper mapper = new ObjectMapper();
		if (result == 1) {
			object.put("response", "OK");
		} else {
			object.put("errorCode", "500");
			object.put("errorMessage", "Error in response");
		}
		return mapper.writeValueAsString(object) ;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/modify")
	public String updateBook(@RequestBody Book book) throws SQLException, JsonProcessingException {

		BookDAO bookDAO = new BookDAOImpl();
		int result = bookDAO.update(book);
		Map<String, Object> object = new HashMap<>();

		ObjectMapper mapper = new ObjectMapper();
		if (result == 1) {
			object.put("response", "OK"); 
		} else {
			System.out.println(result);
			object.put("errorCode", "500");
			object.put("errorMessage", "Error in response");
		}
		return mapper.writeValueAsString(object) ;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<Book> getAllBooks() throws SQLException {
		BookDAO bookDAO = new BookDAOImpl();
		List<Book> bookList = new ArrayList<>();
		bookList = bookDAO.getAll();
		return bookList;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/search/{searchParam}")
	public List<Book> getSearch(@PathVariable String searchParam) throws SQLException {
		BookDAO bookDAO = new BookDAOImpl();
		List<Book> bookList = new ArrayList<>();
		bookList = bookDAO.getSearch(searchParam);
		return bookList;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete/{requestedId}")
	public String deleteBook(@PathVariable int requestedId) throws SQLException, JsonProcessingException {
		BookDAO bookDAO = new BookDAOImpl();
		Book book = bookDAO.get(requestedId);
		Map<String, Object> object = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		if (book != null) {
			int result = bookDAO.delete(book);
			if (result == 1) {
				object.put("response", "OK");
			} else {
				System.out.println(result);
				object.put("errorCode", "500");
				object.put("errorMessage", "Error in response");
			}
		} else {
			object.put("response", "OK");
			object.put("code", "DBNULL");
			object.put("message", "Object doesn't exists in DB");
		}
		
		return objectMapper.writeValueAsString(object);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/insights")
	public String getInsights() throws SQLException, JsonProcessingException {
		BookDAO bookDAO = new BookDAOImpl();
		Map<String, Object> map = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();

		int count = bookDAO.getCountAllBooks();
		int totalPriceAmount = bookDAO.getTotalPriceAmount();
		int totalPageCount = bookDAO.getTotalPageCount();
		List<Map<String, Object>> genreCount = bookDAO.getGerneCountList();

		map.put("count", count);
		map.put("totalPriceAmount", totalPriceAmount);
		map.put("genreCount", genreCount);
		map.put("totalPageCount", totalPageCount);

		return objectMapper.writeValueAsString(map);
	}


}
