package bookstore;
import java.util.*;

/**
 * Bookstore
 * @author Derek Wang
 */
public class Bookstore implements BookStoreSpecification{
    
    ArrayList<Product> inventory = new ArrayList(); 
    ArrayList<RegularMember> regularMemberList = new ArrayList<>();
    ArrayList<PremiumMember> premiumMemberList = new ArrayList<>();
    ArrayList<Product> bookList = new ArrayList<>();
    ArrayList<Product> cdList = new ArrayList<>();
    ArrayList<Product> dvdList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public Bookstore() {
        generateInventory();
    }
    public void makePayment() {
    System.out.println("Please enter your Premium Personal ID number: ");
    /*
    int premiumPersonalMemberID = scnr.nextInt();
            
    Scanner sc = new Scanner(System.in);
        while (paid != paid) {
            System.out.println("Please enter an amount");
            double pay = sc.nextDouble();
            double change = pay - 3;
            if (pay > 3) {                    
                System.out.println("Thank you, your change is $" + change);
                System.out.println("Premium Member Registration Complete!");
                paid = paid;
            }
            if (pay < 3) {
                double remaining = 3 - pay;
                System.out.println("Remaining amount left is " + remaining);
                System.out.println("Please pay remaining balance");
                double rCash = sc.nextDouble();
                    if (rCash > remaining) {
                        System.out.println("Thank you, your change is $" + change + ".");
                        System.out.println("Premium Member Registration Complete!");
                        paid = "Paid";
                    } if (rCash < remaining) {
                        System.out.println("Error, not enough to pay off balance. Please try again");
                    } if (rCash == remaining) {
                        System.out.println("Premium Member Registration Complete!");
                        paid = "Paid";
                    }
            }
        }
    */
    }
    public void regularMemberJoin() {
        System.out.println("Enter your first name?");
        String fName = sc.nextLine();
        System.out.println("Enter your last name?");
        String lName = sc.nextLine();
        RegularMember temp = new RegularMember(fName, lName, 0);
        regularMemberList.add(temp);
        System.out.println("Your new personal member ID number is: " + temp.personalMemberID);
    }
    
    public void premiumMemberJoin() {
        System.out.println("Please enter your personal member ID number: ");
        int regularPersonalMemberID = sc.nextInt();
        String tempfName;
        String tempflame;

        System.out.println("What Monthly Membership Paid?");
        for (RegularMember i : regularMemberList) {
            if (i.getPersonalMemberID() == regularPersonalMemberID) {
                tempfName = i.getFirstName();
                tempflame = i.getLastName();
                PremiumMember premiumTemp = new PremiumMember(tempfName, tempflame, 0, false);
                premiumMemberList.add(premiumTemp);
                System.out.println("Your new Premium Personal ID number is: " + premiumTemp.getPersonalPremiumMemberID());
                regularMemberList.remove(i);
                System.out.println("Remember to pay your monthly membership fee from the menu!");
            }
        }
    }
    
    private void generateInventory() {
        Book book1 = new Book("To Kill A Mockingbird", "Harper Lee", 9.99, 2, "Book");
        Book book2 = new Book ("Charlotte's Web", "E.B. White", 7.99, 7, "Book");
        CD cdl = new CD ("Cuz I Love You", "Lizzo", 7.99, 5, "CD");
        DVD dvdl = new DVD ("How To Train Your Dragon", "Movie", 15.99, 3, "DVD"); 
        //add to the unified inventory 
        inventory.add (book1); 
        inventory.add (book2); 
        inventory.add(cdl); 
        inventory.add (dvdl);
        bookList.add (book1); 
        bookList.add (book2); 
        cdList.add(cdl); 
        dvdList.add (dvdl);
        
    }

    public void getInventory() {
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getID()+ " " + inventory.get(i).getName() + " - $" + inventory.get(i).getPrice() + " - Number of copies: " + inventory.get(i).getStock() + "(" + inventory.get(i).getType() + ")");
        }  
    }
    
    public void memberShipStatus() {
        System.out.println("Regular or Premium member?");
        System.out.println("\t1. Regular Member");
        System.out.println("\t2. Premium Member");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your first name?");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name?");
        String lastName = sc.nextLine();

        if (num == 1) { // itterates through array and checks if regular member exists
            for (int i = 0; i < regularMemberList.size(); i++) {
                try {
                if (firstName.equals(regularMemberList.get(i).getFirstName()) && lastName.equals(regularMemberList.get(i).getLastName())) {
                    //System.out.println(firstName + " " + lastName + "is a regular member!");
                }
                } catch (Exception e){
                    System.out.println("Error, not a member.");
                }
            }
        }
        if (num == 2) { // itterates through array and checks if premium member exists
            for (int i = 0; i < premiumMemberList.size(); i++) {
                try {
                if (firstName.equals(premiumMemberList.get(i).getFirstName()) && lastName.equals(premiumMemberList.get(i).getLastName())) {
                    System.out.println(firstName + " " + lastName + "is a premium member!");
                    System.out.println("Monthly Fee is paid:" + premiumMemberList.get(i).isPaid());
                }
                } catch (Exception e){
                    System.out.println("Error, not a member.");
                }
            }
        }
    }
   
    private static void purchase(Bookstore bookstore, Scanner scnr, ArrayList<Integer> purchasedIDs) {
        System.out.println("Which of the following would you like to purchase?: ");
        //ArrayList<Book> bookInventory = new ArrayList();
        //ArrayList<DVD> dvdInventory = new ArrayList(); 
        //ArrayList<CD> cdInventory = new ArrayList(); 
/*
        // display inventory menu
        for (Product item : bookstore.getInventory()) {
            System.out.println("\t" + item.getID() + " " + item.getName());
            if(item instanceof Book) {
                System.out.print(" by " ((Book) item).getAuthor() + " - $" + item.getPrice() + " (Book)");
            } else if(item instanceof CD) {
                System.out.print(" by " ((CD) item).getArtist() + " - $" + item.getPrice() + " (CD)");
            } else {
                System.out.print(" - $" + item.getPrice() + " (DVD)");
            System.out.println("");
            }
        }
*/
        System.out.println("");
    }
    
    boolean isExist(int choice) {
        for (Product p : inventory)
        {
            if (p.getID() == choice)
            {         
                return true;
            }
        }
    return false;
    }

    public Product getProductByID(int id)
    {
        for (Product p : inventory)
        {
            if (p.getID() == id)
            {
            return p;
            }
        }
    return null;
    }

    @Override
    public void restockProduct(int id, int quantity) {
        Product p = getProductByID(id);
        if (p == null)
        {
            System.out.println("Wrong product ID is provided");
            return;
        }
        p.setStock(p.getStock() + quantity);
    }
    
    @Override
    public double inventoryValue()
    {
        double grossValue = 0.0;
        for (Product p: inventory)
            grossValue += (p.getPrice() * p.getStock());
        return grossValue;
    }

}
