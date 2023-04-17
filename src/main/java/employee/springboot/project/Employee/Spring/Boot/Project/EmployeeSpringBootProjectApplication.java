package employee.springboot.project.Employee.Spring.Boot.Project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import employee.springboot.project.Employee.Spring.Boot.Project.dao.EmployeeDAO;
import employee.springboot.project.Employee.Spring.Boot.Project.impl.EmployeeDAOImpl;
import employee.springboot.project.Employee.Spring.Boot.Project.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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

	@GetMapping("/employee/{requestedId}")
	public Employee helloWorld(@PathVariable int requestedId) throws SQLException {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee employee = employeeDAO.get(requestedId);
		if (employee != null) {
			System.out.println(employee);
			return employee;
		} else {
			return null;
		}

	}

	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody Employee newEmployee) throws SQLException, JsonProcessingException {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		int result = employeeDAO.insert(newEmployee);
		Map<String, Object> object = new HashMap<>();

		ObjectMapper mapper = new ObjectMapper();
		if (result == 1) {
			object.put("response", "OK");
		} else {
			object.put("errorCode", "errorCode");
			object.put("errorMessage", "errorMessage");
		}
		return mapper.writeValueAsString(object) ;
	}


}
