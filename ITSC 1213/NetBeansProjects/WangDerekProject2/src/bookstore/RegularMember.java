package bookstore;

/**
 * Feature of a regular member of the bookstore
 * @author Derek Wang
 */
public class RegularMember {
    
    private String firstName; //first name of member
    private String lastName; //last name of member
    private double moneyTotal; //money spent of member
    private int personalIDCounter;
    int personalMemberID;
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
 * @return total money spent by the member
 */
    public double getMoneyTotal() {
        return moneyTotal;
    }
/**
 * 
 * @param moneyTotal sets moneyTotal
 */
    public void setMoneyTotal(double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }
/**
 * Adds new amount of money spent to current money spent
 * @param addMoney add money for current purchase
 */
    public void addMoneyTotal(double addMoney) {
        this.moneyTotal = this.moneyTotal + addMoney;
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

    public int getPersonalIDCounter() {
        return personalIDCounter;
    }

    public void setPersonalID(int personalIDCounter) {
        this.personalIDCounter = personalIDCounter;
    }

    public int getPersonalMemberID() {
        return personalMemberID;
    }

    public void setPersonalMemberID(int personalMemberID) {
        this.personalMemberID = personalMemberID;
    }
}
