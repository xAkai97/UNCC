package bookstore;

/**
 *
 * @author Derek Wang
 */
public class Book extends Product {

    private String author;
    
    public Book(String name, String author, double price, int stock, String type) {
        super(name, price, stock, type);
        this.author = author;
    }
    /**
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

}
