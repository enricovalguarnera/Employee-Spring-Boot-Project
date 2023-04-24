package employee.springboot.project.Employee.Spring.Boot.Project.dao;

import java.util.List;
import java.sql.SQLException;
import employee.springboot.project.Employee.Spring.Boot.Project.model.Book;

public interface BookDAO extends DAO<Book> {
    List<Book> getSearch(String s) throws SQLException;
}
