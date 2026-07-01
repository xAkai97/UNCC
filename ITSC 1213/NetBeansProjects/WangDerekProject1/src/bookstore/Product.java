package bookstore;

/**
 *
 * @author Derek Wang
 */
public class Product {

    private String title; //title of product
    private double price; //price of product
    private int inventory; //amount of product in inventory
    private int total; // total price of purchase
/**
 * 
 * @param title string for title
 * @param price value for price of product
 * @param inventory value for amount in inventory
 */
    public Product(double price, int inventory) {
        this.price = price;
        this.inventory = inventory;
    }

    public Product() {

    }
/**
 * 
 * @return gets the price of item
 */
    public double getPrice() {
        return price;
    }
/**
 * 
 * @return gets the inventory
 */
    public int getInventory() {
        return inventory;
    }
/**
 * Calculates the total price of all products bought
 * @param numBooks number of Books
 * @param numCds number of CD's
 * @param numDvds number of DVD's
 * @return 
 */
    public int getTotal(int numBooks, int numCds, int numDvds) {
        this.total = (10 * numBooks) + (6 * numCds) + (12 * numDvds);
        return total;
    }
/**
 * 
 * @param price set price
 */
    public void setPrice(double price) {
        this.price = price;
    }
/**
 * 
 * @param inventory set inventory
 */
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
/**
 * Subtracts the amount sold from the current inventory
 * @param sold amount of product sold
 */
    public void subtractInventory(int sold) {
        this.inventory = this.inventory - sold;
    }
/**
 * Adds more products to inventory
 * @param add amount of product added
 */
    public void addInventory(int add) {
        this.inventory = this.inventory + add;
    }
/**
 * Sets the total
 * @param numBooks number of Books bought
 * @param numCds number of CD's bought
 * @param numDvds number of DVD's bought
 */
    public void setTotal(int numBooks, int numCds, int numDvds) {
        this.total = (10 * numBooks) + (6 * numCds) + (12 * numDvds);
    }

}
