package employee.springboot.project.Employee.Spring.Boot.Project.model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String editor;
    private int totalpage;
    private String genre;
    private String publicationdate;
    private String description;
    private String language;
    private int volume;
    private int price;

    


    public Book(int id, String title, String author, String editor, int totalpage, String genre, String publicationdate,
            String description, String language, int volume, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.totalpage = totalpage;
        this.genre = genre;
        this.publicationdate = publicationdate;
        this.description = description;
        this.language = language;
        this.volume = volume;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }
    public int getTotalpage() {
        return totalpage;
    }
    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPublicationdate() {
        return publicationdate;
    }
    public void setPublicationdate(String publicationdate) {
        this.publicationdate = publicationdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", editor=" + editor + ", totalpage="
                + totalpage + ", genre=" + genre + ", publicationdate=" + publicationdate + ", language=" + language
                + ", volume=" + volume + ", price=" + price + "]";
    }

}
