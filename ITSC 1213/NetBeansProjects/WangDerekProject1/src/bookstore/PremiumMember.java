package bookstore;
import java.util.*;

/**
 * Features of a premium member of the book store
 * @author Derek Wang
 */

public class PremiumMember extends RegularMember {

    private String payMethod; // pay method of member
/**
 * 
 * @param firstName first name for a premium member
 * @param lastName last name for a premium member
 * @param moneyTotal total amount of money spent by the member at the store
 * @param payMethod accepts the type of method the premium member payed for their membership
 */
    public PremiumMember(String firstName, String lastName, double moneyTotal, String payMethod) {
        super(firstName, lastName, moneyTotal);
        this.payMethod = payMethod;
    }

    public PremiumMember() {

    }
/**
 * 
 * @return payment method
 */
    public String getPayMethod() {
        return payMethod;
    }
/**
 * 
 * @param payMethod sets payMethod
 */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
/**
 * Payment of cash or card
 * @param method int that indicates the payment method
 */
    public void makePayment(int method) {
        Scanner sc = new Scanner(System.in);
        boolean status = false;
        while (status == false) {
            if (method == 1) {
                System.out.println("Please enter an amount and insert/swipe card");
                double card = sc.nextDouble();
                double change = card - 3;
                if (card > 3) {                    
                    System.out.println("Thank you, your change is $" + change + ". You are now a member");
                    status = true;
                }
                if (card < 3) {
                    double remaining = 3 - card;
                    System.out.println("Remaining amount left is " + remaining);
                    System.out.println("Please pay reamaining balance");
                    double rCash = sc.nextDouble();
                        if (rCash > remaining) {
                            System.out.println("Thank you, your change is $" + change + ".");
                            System.out.println("Premium Member Registration Complete!");
                            status = true;
                        }
                        if (rCash < remaining) {
                            System.out.println("Error, not enough to pay off balance. Please try again");
                        }
                        if (rCash == remaining) {
                            System.out.println("Premium Member Registration Complete!");
                            status = true;
                        }
                }
            }
            if (method == 2) {
                System.out.println("Please enter an amount");
                double cash = sc.nextDouble();
                double change = cash - 3;
                if (cash > 3) {                    
                    System.out.println("Thank you, your change is $" + change + ". You are now a member");
                    status = true;
                }
                if (cash < 3) {
                    double remaining = 3 - cash;
                    System.out.println("Remaining amount left is " + remaining);
                    System.out.println("Please pay reamaining balance");
                    double rCash = sc.nextDouble();
                        if (rCash > remaining) {
                            System.out.println("Thank you, your change is $" + change + ".");
                            System.out.println("Premium Member Registration Complete!");
                            status = true;
                        }
                        if (rCash < remaining) {
                            System.out.println("Error, not enough to pay off balance. Please try again");
                        }
                        if (rCash == remaining) {
                            System.out.println("Premium Member Registration Complete!");
                            status = true;
                        }
                }
                if (cash == 3) {
                    System.out.println("Premium Member Registration Complete!");
                    status = true;
                }
            }
        }
    }

}