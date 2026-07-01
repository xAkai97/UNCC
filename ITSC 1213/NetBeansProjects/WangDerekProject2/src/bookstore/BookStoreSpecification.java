package bookstore;

/**
 *
 * @author Window 11
 */
interface BookStoreSpecification {

    public void restockProduct (int id, int quantity);
            
    public double inventoryValue();
}