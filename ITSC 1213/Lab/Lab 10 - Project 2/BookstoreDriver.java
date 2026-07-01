
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Derek Wang
 */
public class BookstoreDriver {

    private static String firstName;
    private static String lastName;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        
        while (num != 5) {
            // Prints the action options at the bookstore
            System.out.println("Welcome to the Bookstore!");
            System.out.println("Please select one of the following:");
            System.out.println("\t1. Make a purchase");
            System.out.println("\t2. Register as a member");
            System.out.println("\t3. Check Membership Status");
            System.out.println("\t4. Restock Product");
            System.out.println("\t5. Get Inventory Total Value");
            System.out.println("\t6. Exit");
            
            num = sc.nextInt();
            switch (num) {
                case 1 -> {
                    //purchase(bookstore, sc);           
                }
                case 2 -> {
                    // creates a new regular member
                    sc.nextLine();
                    bookstore.regularMemberJoin();
                    System.out.println("Regular Member Registration Complete!");
                    System.out.println("Join as a Premium Member?");
                    System.out.println("Y/N?");
                    char letter = sc.next().charAt(0);
                    if (letter == 'Y' || letter == 'y') {
                        System.out.println("Premium Membership fee is $5/month");
                        bookstore.premiumMemberJoin();
                    }
                    if (letter == 'N' || letter == 'n') {
                        System.out.println("Returning to main menu!");
                    }
                }
                case 3 -> {
                    bookstore.memberShipStatus();
                }
                case 4 -> {// restock Product 
                    System.out.println("Which of the following would you like to restock?:");
                    bookstore.getInventory();
                    System.out.println("Enter Product ID?:");
                    int id = sc.nextInt(); 
                    System.out.println("Enter Product Quantity?:");
                    int quantity = sc.nextInt(); 
                    bookstore.restockProduct(id, quantity); 
                    bookstore.getInventory();

                }
                case 5 -> {
                    // gets inventory total value
                    System.out.println("The total value of the inventory is " + bookstore.inventoryValue());
                }
                case 6 -> {
                    // End Program
                    System.out.println("The Bookstore is now closed!");
                    System.exit(0);
                }
                default -> System.out.println("Error, please select one of the options.");
            }
        }
    }
         

        private static void checkout(Bookstore bookstore, Scanner sc, ArrayList<Integer> purchaseIDs) {

            //caculate total
            double total = getTotalPurchase(bookstore, purchaseIDs);
        }

        private static double getTotalPurchase(Bookstore bookstore, ArrayList<Integer> purchasedIDs) {

            double total = 0 ;
            for (int id : purchasedIDs) {

                Product product = bookstore.getProductByID(id);
                if ( product != null )
                    total = total + product.getPrice ();
            }
            return total;
        }
}
