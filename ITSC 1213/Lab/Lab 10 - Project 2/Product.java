
/**
 *
 * @author Derek Wang
 */
public abstract class Product implements Comparable {

    private static int counter = 1;
    
    private int ID;
    private String name;
    private double price;
    private int stock;
    private String type;
    
/**
 * Product constructor
 * 
 * @param name the product's title
 * @param price price of the product
 * @param stock number of copies in stock
 * @param type product type
 */
    public Product(String name, double price, int stock, String type) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
        this.ID = Product.counter++;
    }
/**
 * @return gets the ID of item
 */
    public int getID() {
        return ID;
    }
/**
 * @param ID set ID
 */
    public void setID(int ID) {
        this.ID = ID;
    }
/**
 * @return gets the name of item
 */
    public String getName() {
        return name;
    }
/**
 * @param name set name
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * @return gets the price of item
 */
    public double getPrice() {
        return price;
    }
/**
 * @param price set price
 */
    public void setPrice(double price) {
        this.price = price;
    }
/**
 * @return product type
 */
    public String getType() {
        return type;
    }
/**
 * @return gets the inventory
 */
    public int getStock() {
        return stock;
    }
/**
 * @param stock set stock
 */
    public void setStock(int stock) {
        this.stock = stock;
    }
/**
 * Subtracts the amount sold from the current stock
 * @param sold amount of product sold
 */
    public void subtractStock(int sold) {
        this.stock = this.stock - sold;
    }
/**
 * Adds more products to inventory
 * @param add amount of product added
 */
    public void addStock(int add) {
        this.stock = this.stock + add;
    }
      
        

    @Override
    public int compareTo(Object o)
    {
        if (o.getClass().getSimpleName() =="Book" || o.getClass().getSimpleName() =="CD" || o.getClass().getSimpleName() =="DVD")
        {
            Product p = (Product) o;            
            if (this.getPrice() == p.getPrice())
                return 0;
            else
                return (int )(this.getPrice() - p.getPrice());
        }
        else
            // invalid object to compare
            return -1;
    }
}
