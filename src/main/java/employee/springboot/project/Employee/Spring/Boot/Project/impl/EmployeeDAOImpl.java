package employee.springboot.project.Employee.Spring.Boot.Project.impl;

import employee.springboot.project.Employee.Spring.Boot.Project.dao.EmployeeDAO;
import employee.springboot.project.Employee.Spring.Boot.Project.db.Database;
import employee.springboot.project.Employee.Spring.Boot.Project.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    // CRUD

    @Override
    public Employee get(int id) throws SQLException {
        Connection con = Database.getConnetcion();
        Employee employee = null;

        String sql = "SELECT id, employee_id, name, surname, dept_id FROM employees WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int oid = rs.getInt("id");
            int employeeId = rs.getInt("employee_id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int deptId = rs.getInt("dept_id");

            employee = new Employee(oid, employeeId, name, surname, deptId);

        }

        Database.closePrepareStatement(ps);
        Database.closeConnection(con);

        return employee;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "INSERT INTO employees (employee_id, name, surname, dept_id) VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employee.getEmployee_id());
        ps.setString(2, employee.getName());
        ps.setString(3, employee.getSurname());
        ps.setInt(4, employee.getDept_id());

        int result = ps.executeUpdate();

        ps.close();
        con.close();
        return result;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "UPDATE employees set employee_id = ?, name = ?, surname = ?, dept_id = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employee.getEmployee_id());
        ps.setString(2, employee.getName());
        ps.setString(3, employee.getSurname());
        ps.setInt(4, employee.getDept_id());
        ps.setInt(5, employee.getId());

        int result = ps.executeUpdate();
        ps.close();
        con.close();
        return result;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "DELETE from employees WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employee.getId());

        int result = ps.executeUpdate();

        Database.closePrepareStatement(ps);
        Database.closeConnection(con);

        return result;
    }
}
