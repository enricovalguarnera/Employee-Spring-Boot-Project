package employee.springboot.project.Employee.Spring.Boot.Project.dao;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import employee.springboot.project.Employee.Spring.Boot.Project.model.Book;

public interface BookDAO extends DAO<Book> {
    List<Book> getSearch(String s) throws SQLException;
    int getCountAllBooks() throws SQLException;
    int getTotalPriceAmount() throws SQLException;
    int getTotalPageCount() throws SQLException;
    Map<String, Integer> getGerneCountList() throws SQLException;
}
