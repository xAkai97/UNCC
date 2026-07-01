package bookstore;
import java.util.*;

/**
 * Bookstore management system
 * @author Derek Wang
 */
public class BookStore {
    
    /** runs bookstore
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Product purchase = new Product();
        ArrayList<RegularMember> regular = new ArrayList(); // arraylist of all regular members of bookstore
        ArrayList<PremiumMember> premium = new ArrayList(); // arraylist of all premium members of bookstore
        RegularMember current = null;
        PremiumMember pCurrent = null;

        PremiumMember payment = new PremiumMember();
        RegularMember receipt = new RegularMember();

        regular.add(new RegularMember("test", "one", 0));
        premium.add(new PremiumMember("test", "two", 3, "cash"));
        premium.add(new PremiumMember("test", "three", 33, "card"));

        Product books = new Books(10, 500);
        Product cds = new CDs(6, 250);
        Product dvds = new DVDs(12, 400);

        boolean open = true;
        while (open == true) {

            // Prints the action options at the bookstore
            System.out.println("Welcome to the Bookstore!");
            System.out.println("\n");
            System.out.println("Please select one of the following:");
            System.out.println("\t1. Make a purchase");
            System.out.println("\t2. Register as a member");
            System.out.println("\t3. Manage Inventory");
            System.out.println("\t4. Check Member List");
            System.out.println("\t5. Exit");


            int num = sc.nextInt();

            boolean validMember = false;
            boolean pMember = false;
            String firstName = null;
            String lastName = null;
            
            switch (num) {
                case 1: // makes a purchase

                    while (validMember == false) {

                        System.out.println("Current member? (Y/N)");
                        char letter = sc.next().charAt(0);
                        if (letter == 'N' || letter == 'n') { // if customer isn't a member
                            System.out.println("Join Membership? (Y/N)");
                            letter = sc.next().charAt(0);
                            if (letter == 'Y' || letter == 'y') { // if customer is a member
                                System.out.println("Regular or Premium Member?");
                                System.out.println("Premium members have a monthly membership fee of $3!");
                                System.out.println("\t1. Regular Member");
                                System.out.println("\t2. Premium Member");
                                num = sc.nextInt();
                                switch (num) {
                                    case 1: // creates a new regular member
                                        System.out.println("Enter your first name?");
                                        sc.nextLine();
                                        firstName = sc.nextLine();
                                        System.out.println("Enter your last name?");
                                        lastName = sc.nextLine();
                                        RegularMember newMem = new RegularMember(firstName, lastName, 0); // adds regular member
                                        regular.add(newMem);
                                        current = newMem;
                                        System.out.println("Registration Complete! You are now a member");
                                        break;
                                    case 2: // creates a premium member
                                        sc.nextLine();
                                        System.out.println("Enter your first name?");
                                        firstName = sc.nextLine();
                                        System.out.println("Enter your last name?");
                                        lastName = sc.nextLine();
                                        PremiumMember newPMem = new PremiumMember(firstName, lastName, 0, null); // adds premium member
                                        premium.add(newPMem);
                                        pCurrent = newPMem;
                                        pMember = true;
                                        System.out.println("Premium Members pay a fee of $3/month. Card or Cash?");
                                        System.out.println("\t1. Credit/Debit Card");
                                        System.out.println("\t2. Cash");
                                        int method = sc.nextInt();
                                        payment.makePayment(method);
                                        if (method == 1) {
                                            String pay = "card";
                                            pCurrent.setPayMethod(pay);
                                        }
                                        if (method == 2) {
                                            String pay = "cash";
                                            pCurrent.setPayMethod(pay);
                                        }
                                        break;
                                }
                                System.out.println("Proceeding with purchase!");
                                validMember = true;
                            }
                            // if customer doesnt want to become a member
                            if (letter == 'N' || letter == 'n') {
                                System.out.println("Proceeding to check out!");
                                break;

                            }
                        } else if (letter == 'Y' || letter == 'y') { // if customer is a member
                            System.out.println("Regular or Premium member?");
                            System.out.println("\t1. Regular Member");
                            System.out.println("\t2. Premium Member");
                            num = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter your first name?");
                            firstName = sc.nextLine();
                            System.out.println("Enter your last name?");
                            lastName = sc.nextLine();

                            if (num == 1) { // itterates through array and checks if regular member exists
                                for (int i = 0; i < regular.size(); i++) {
                                    if (firstName.equals(regular.get(i).getFirstName()) && lastName.equals(regular.get(i).getLastName())) {
                                        current = regular.get(i);
                                        validMember = true;
                                        break;
                                    } else if (i == regular.size() - 1) {
                                        System.out.println("Error, not a member.");
                                    }
                                }
                            }
                            if (num == 2) { // itterates through array and checks if premium member exists
                                for (int i = 0; i < premium.size(); i++) {
                                    if (firstName.equals(premium.get(i).getFirstName()) && lastName.equals(premium.get(i).getLastName())) {
                                        current = premium.get(i);
                                        validMember = true;
                                        pMember = true;
                                        break;
                                    } else if (i == premium.size() - 1) {
                                        System.out.println("Error, not a member.");
                                    }
                                }
                            }
                        }
                    }
                    // Prints questions to get amount of items bought
                    System.out.println("How many Books?");
                    int numBooks = sc.nextInt();
                    System.out.println("How many CD's?");
                    int numCds = sc.nextInt();
                    System.out.println("How many DVD's?");
                    int numDvds = sc.nextInt();
                    sc.nextLine();
                    double spent = purchase.getTotal(numBooks, numCds, numDvds);
                    System.out.println("\n");
                    System.out.println("Bookstore"); // prints the summary of purchase
                    if (validMember == true) { // if member, add a discount to purchase
                        System.out.println("\n");
                        System.out.println("Regular members recieve 10% discount and Premium members recieve a 20% discount!");
                        spent = spent*0.9;
                        if (pMember == true){
                            spent = spent*0.8;
                        }
                        current.addMoneyTotal(spent);
                        
                    }
                    receipt.receipt(numBooks, numCds, numDvds);
                    if (validMember == true) {
                        System.out.println("Total before discount: $" + purchase.getTotal(numBooks, numCds, numDvds));
                        System.out.println("After discount:");
                    }
                    System.out.println("Total is: $" + spent);
                    if (validMember == true) {
                        current.totalSpending(numBooks, numCds, numDvds);
                    }
                    books.subtractInventory(numBooks);
                    cds.subtractInventory(numCds);
                    dvds.subtractInventory(numDvds);

                    break;

                case 2: // creates a new regular member
                    System.out.println("Regular or Premium Member?");
                    System.out.println("\t1. Regular Member?");
                    System.out.println("\t2. Premium Member?");
                    int n = sc.nextInt(); 
                    sc.nextLine();
                    System.out.println("Enter your first name?");
                    firstName = sc.nextLine();
                    System.out.println("Enter your last name?");
                    lastName = sc.nextLine();
                    if (n == 1) {
                        RegularMember newMem = new RegularMember(firstName, lastName, 0); 
                        regular.add(newMem); //adds new member to array list
                        current = newMem;
                        System.out.println("Regular Member Registration Complete!");

                    }
                    if (n == 2) {
                        PremiumMember newPMem = new PremiumMember(firstName, lastName, 0, null);
                        premium.add(newPMem); // adds new member to array list
                        pCurrent = newPMem;
                        System.out.println("Premium Membership fee is $3/month."); //simulate payment
                        System.out.println("\t1. Credit/Debit Card");
                        System.out.println("\t2. Cash");
                        int method = sc.nextInt();
                        payment.makePayment(method);
                        if (method == 1) {
                            String pay = "card";
                            pCurrent.setPayMethod(pay);
                        }
                        if (method == 2) {
                            String pay = "cash";
                            pCurrent.setPayMethod(pay);
                        }
                    }
                    break;
                case 3: // shows inventory and also adds inventory
                    System.out.println("Inventory");
                    System.out.println("\n");
                    System.out.println(books.getInventory() + " Books in stock");
                    System.out.println(cds.getInventory() + " CD's in stock");
                    System.out.println(dvds.getInventory() + " DVD's in stock");
                    System.out.println("Add more products? Y or N.");
                    char letter = sc.next().charAt(0);
                    if (letter == 'Y' || letter == 'y') {
                        System.out.println("How many Books to add to stock?");
                        numBooks = sc.nextInt();
                        System.out.println("How many CD's to add to stock?");
                        numCds = sc.nextInt();
                        System.out.println("How many DVD's to add to stock?");
                        numDvds = sc.nextInt();
                        books.addInventory(numBooks);
                        cds.addInventory(numCds);
                        dvds.addInventory(numDvds);
                        System.out.println("\n");
                        System.out.println("You have added " + numBooks + " Books.");
                        System.out.println("You have added " + numCds + " CDs.");
                        System.out.println("You have added " + numDvds + " DVDs.");
                        System.out.println("New Updated Inventory");
                        System.out.println("\n");
                        System.out.println(books.getInventory() + " books in stock");
                        System.out.println(cds.getInventory() + " cds in stock");
                        System.out.println(dvds.getInventory() + " dvds in stock");
                    }
                    break;
                case 4: // prints all members in each array list
                    System.out.println("Bookstore Member List");
                    System.out.println("-Regular Members-");
                    System.out.println("\n");
                    for (int i = 0; i < regular.size(); i++) {
                        System.out.println(i + 1 + ". " + regular.get(i).getFirstName() + " " + regular.get(i).getLastName());
                        System.out.println("\t Total money spent: $" + regular.get(i).getMoneyTotal());
                    }
                    System.out.println("-Premium Members-");
                    System.out.println("\n");
                    for (int i = 0; i < premium.size(); i++) {
                        System.out.println(i + 1 + ". " + premium.get(i).getFirstName() + " " + premium.get(i).getLastName());
                        System.out.println("\t Total money spent: $" + premium.get(i).getMoneyTotal());
                        System.out.println("\t Membership payment method: " + premium.get(i).getPayMethod());
                    }
                    break;
                case 5: // End Program
                    if (num == 5) {
                        open = false;
                        System.out.println("The bookstore is now closed!");
                    }
                    break;
                default:
                    System.out.println("Error, please select one of the options.");
                    break;
            }
            System.out.println("\t1. Return to main menu"); // returns to main menu
            System.out.println("\t2. End"); // ends program
            int status = sc.nextInt();
            if (status == 1) {
                open = true;
            }
            if (status == 2) {
                open = false;
                System.out.println("The bookstore is now closed!");
            }
        }

    }
}
