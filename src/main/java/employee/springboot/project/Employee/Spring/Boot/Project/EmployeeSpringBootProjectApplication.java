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

	@GetMapping("/all")
	public List<Book> getAllBooks() throws SQLException {
		BookDAO bookDAO = new BookDAOImpl();
		List<Book> bookList = new ArrayList<>();
		bookList = bookDAO.getAll();
		return bookList;
	}

}
