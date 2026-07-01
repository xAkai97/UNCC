package bookstore;

/**
 *
 * @author Derek Wang
 */
public class DVD extends Product {

    private String genre;
    
    public DVD(String name, String genre, double price, int stock, String type) {
        super(name, price, stock, type);
        this.genre = genre;
    }
    
    /**
     *
     * @return type
     */
    public String getGenre() {
        return genre;
    }
}