import java.util.*;

/**
 * Features of a premium member of the bookstore
 * @author Derek Wang
 */

public class PremiumMember extends RegularMember {

    private boolean paid;
    private int personalPremiumIDCounter;
    int personalPremiumMemberID;
/**
 * @param firstName first name for a premium member
 * @param lastName last name for a premium member
 * @param moneyTotal total amount of money spent by the member at the store
 * @param paid monthly fee is due or has been paid
 */
    public PremiumMember(String firstName, String lastName, double moneyTotal, boolean paid) {
        super(firstName, lastName, moneyTotal);
        this.paid = paid;
        personalPremiumMemberID = this.personalPremiumIDCounter;
        personalPremiumIDCounter++;
    }
    
    public int getPersonalPremiumIDCounter() {
        return personalPremiumIDCounter;
    }

    public void setPersonalPremiumIDCounter(int personalPremiumIDCounter) {
        this.personalPremiumIDCounter = personalPremiumIDCounter;
    }

    public int getPersonalPremiumMemberID() {
        return personalPremiumMemberID;
    }

    public void setPersonalPremiumMemberID(int personalPremiumMemberID) {
        this.personalPremiumMemberID = personalPremiumMemberID;
    }
/**
 * 
 * @return monthlyFee
 */
    public boolean isPaid() {
        return paid;
    }
/**
 * 
 * @param paid sets whether monthlyFee has been paid
 */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}