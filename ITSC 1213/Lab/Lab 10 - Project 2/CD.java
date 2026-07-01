package bookstore;

/**
*
* @author Derek Wang
*/
public class CD extends Product {

    private String artist;
    
    public CD(String name, String artist, double price, int stock, String type) {
        super(name, price, stock, type);
        this.artist = artist;
    }
    /**
     *
     * @return artist
     */
    public String getArtist() {
        return artist;
    }
}