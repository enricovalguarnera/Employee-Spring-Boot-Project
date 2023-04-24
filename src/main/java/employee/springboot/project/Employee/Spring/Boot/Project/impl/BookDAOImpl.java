package employee.springboot.project.Employee.Spring.Boot.Project.impl;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.DataBinder;

import employee.springboot.project.Employee.Spring.Boot.Project.dao.BookDAO;
import employee.springboot.project.Employee.Spring.Boot.Project.db.Database;
import employee.springboot.project.Employee.Spring.Boot.Project.model.Book;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.ResultSet;

public class BookDAOImpl implements BookDAO {

    @Override
    public Book get(int id) throws SQLException {
       Connection con = Database.getConnetcion();
        Book book = null;

        String sql = "SELECT id, title, author, editor, totalpage, genre, publicationdate, description, language, volume, price FROM books WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int oid = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String editor = rs.getString("editor");
            int totalpage = rs.getInt("totalpage");
            String genre = rs.getString("genre");
            String publicationdate = rs.getString("publicationdate");
            String description = rs.getString("description");
            String language = rs.getString("language");
            int volume = rs.getInt("volume");
            int price = rs.getInt("price");

            book = new Book(oid, title, author, editor, totalpage, genre, publicationdate, description, language, volume, price);

        }

        Database.closePrepareStatement(ps);
        Database.closeConnection(con);

        return book;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "SELECT * FROM books";
        PreparedStatement ps = con.prepareStatement(sql);

        List<Book> allBookList = new ArrayList<>();

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int oid = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String editor = rs.getString("editor");
            int totalpage = rs.getInt("totalpage");
            String genre = rs.getString("genre");
            String publicationdate = rs.getString("publicationdate");
            String description = rs.getString("description");
            String language = rs.getString("language");
            int volume = rs.getInt("volume");
            int price = rs.getInt("price");

            Book currentBook = new Book(oid, title, author, editor, totalpage, genre, publicationdate, description, language, volume, price);
            allBookList.add(currentBook);
        }

        Database.closePrepareStatement(ps);
        Database.closeConnection(con);
        return allBookList;
        
    }


    @Override
    public List<Book> getSearch(String searchStr) throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "SELECT * FROM books WHERE (title like ?) OR (author like ?) " + 
            " OR (editor like ?) OR (totalpage like ?) OR (genre like ?) OR (publicationdate like ?) " + 
            " OR (description like ?) OR (language like ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        searchStr = '%' + searchStr + '%'; // full text search
        ps.setString(1, searchStr);
        ps.setString(2, searchStr);
        ps.setString(3, searchStr);
        ps.setString(4, searchStr);
        ps.setString(5, searchStr);
        ps.setString(6, searchStr);
        ps.setString(7, searchStr);
        ps.setString(8, searchStr);
        
        List<Book> allBookList = new ArrayList<>();

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int oid = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String editor = rs.getString("editor");
            int totalpage = rs.getInt("totalpage");
            String genre = rs.getString("genre");
            String publicationdate = rs.getString("publicationdate");
            String description = rs.getString("description");
            String language = rs.getString("language");
            int volume = rs.getInt("volume");
            int price = rs.getInt("price");

            Book currentBook = new Book(oid, title, author, editor, totalpage, genre, publicationdate, description, language, volume, price);
            allBookList.add(currentBook);
        }

        Database.closePrepareStatement(ps);
        Database.closeConnection(con);
        return allBookList;
    }

    @Override
    public int save(Book t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int insert(Book book) throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "INSERT INTO books (title, author, editor, totalpage, genre, publicationdate, description, language, volume, price) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getEditor());
        ps.setInt(4, book.getTotalpage());
        ps.setString(5, book.getGenre());
        ps.setString(6, book.getPublicationdate());
        ps.setString(7, book.getDescription());
        ps.setString(8, book.getLanguage());
        ps.setInt(9, book.getVolume());
        ps.setInt(9, book.getPrice());

        int result = ps.executeUpdate();

        ps.close();
        con.close();
        return result;
    }

    @Override
    public int update(Book book) throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "UPDATE books set title = ?, author = ?, editor = ?, totalpage = ?, genre = ?, publicationdate = ?, description = ?, language = ?, volume = ?, price = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getEditor());
        ps.setInt(4, book.getTotalpage());
        ps.setString(5, book.getGenre());
        ps.setString(6, book.getPublicationdate());
        ps.setString(7, book.getDescription());
        ps.setString(8, book.getLanguage());
        ps.setInt(9, book.getVolume());
        ps.setInt(10, book.getPrice());
        ps.setInt(11, book.getId());

        int result = ps.executeUpdate();
        ps.close();
        con.close();
        return result;
    }

    @Override
    public int delete(Book book) throws SQLException {
        Connection con = Database.getConnetcion();
        String sql = "DELETE from books WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, book.getId());

        int result = ps.executeUpdate();

        Database.closePrepareStatement(ps);
        Database.closeConnection(con);

        return result;
    }

    
}
