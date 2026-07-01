package bookstore;

/**
 * Feature of a regular member of the book store
 * @author Derek Wang
 */
public class RegularMember {
    
    private String firstName; //first name of member
    private String lastName; //last name of member
    private double moneyTotal; //money spent of member
/**
 * 
 * @param firstName accepts a first name for a regular member
 * @param lastName accepts a last name for a premium member
 * @param moneyTotal accepts an amount for the total money spent by the member at the store
 */
    public RegularMember(String firstName, String lastName, double moneyTotal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyTotal = moneyTotal;
    }

    public RegularMember() {

    }
/**
 * 
 * @return first name
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * 
 * @return last name
 */
    public String getLastName() {
        return lastName;
    }
/**
 * 
 * @return total money spent by the member
 */
    public double getMoneyTotal() {
        return moneyTotal;
    }
/**
 * 
 * @param firstName sets firstName
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * 
 * @param lastName sets lastName
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * 
 * @param moneyTotal sets moneyTotal
 */
    public void setMoneyTotal(double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }
/**
 * Total amount spent on purchase
 * @param numBooks number of Books
 * @param numCds number of CD's
 * @param numDvds number of DVD's
 */
    public void totalSpending(int numBooks, int numCds, int numDvds) {
        System.out.println("Total spending since becoming a member: $" + moneyTotal);
    }
/**
 * Adds new amount of money spent to current money spent
 * @param moneyTotal money spent for current purchase
 */
    public void addMoneyTotal(double moneyTotal) {
        this.moneyTotal += moneyTotal;
    }
/**
 * Prints out the amount of each item that was bought and each total
 * @param numBooks number of Books bought
 * @param numCds number of CD's bought
 * @param numDvds number of DVD's bought
 */
    public void receipt(int numBooks, int numCds, int numDvds) {

        System.out.println("Number of Books: $10 x " + numBooks + " = $" + (10 * numBooks));
        System.out.println("Number of CD's: $6 x " + numCds + " = $" + (6 * numCds));
        System.out.println("Number of DVD's: $16 x " + numDvds + " = $" + (16 * numDvds));
    }
}
