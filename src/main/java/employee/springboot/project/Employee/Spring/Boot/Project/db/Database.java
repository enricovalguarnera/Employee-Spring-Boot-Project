package employee.springboot.project.Employee.Spring.Boot.Project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private  static String url = "jdbc:sqlite:/Users/evalguarne001/Documents/my-db";
    private static String user = "root";
    private static String password = "password";

    public Database() {

    }

    public static Connection getConnetcion() throws SQLException {

        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void closeConnection (Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void closePrepareStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }
}
