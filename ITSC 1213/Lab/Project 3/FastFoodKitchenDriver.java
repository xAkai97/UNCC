import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * ITSC 1213 
 * University of North Carolina at Charlotte
 * 
 * @author Derek Wang
 */
public class FastFoodKitchenDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try{
            FastFoodKitchen kitchen = new FastFoodKitchen();

            Scanner sc = new Scanner(System.in);

            boolean file = false;
            int i = 0;
            String line;
            int totalHam = 0;
            int totalCheese = 0;
            int totalVeggie = 0;
            int totalSoda = 0;

			//Day
            while (file == false) {
                if (!(new File("burgerOrders" + (i + 1) + ".csv").exists())) {
                    file = true;
                } else {
                    i++;
                }
            }

            Scanner fileScanner = new Scanner(new File("burgerOrders" + Integer.toString(i) + ".csv"));
            fileScanner.nextLine();

            new File("burgerOrders" + Integer.toString(i + 1) + ".csv").createNewFile();
            new File("burgerOrders" + Integer.toString(i + 1) + ".txt").createNewFile();
            FileOutputStream toCSV = new FileOutputStream("burgerOrders" + Integer.toString(i + 1) + ".csv", true);
            FileOutputStream toTXT = new FileOutputStream("burgerOrders" + Integer.toString(i + 1) + ".txt", true);

            toCSV.write("numHamburgers,numCheeseburgers,numVeggieburgers,numSoda,toGo,orderNum\n".getBytes());
            toTXT.write("Burger Orders\n".getBytes());
            toTXT.write("-------------------\n\n".getBytes());
            //fills the uncompleted orders from the previous day
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();

                String[] arr = line.split(",", 6);
                int ham = Integer.parseInt(arr[0]);
                int cheese = Integer.parseInt(arr[1]);
                int veggie = Integer.parseInt(arr[2]);
                int soda = Integer.parseInt(arr[3]);
                boolean toGo = Boolean.parseBoolean(arr[4]);
                int orderNumber = Integer.parseInt(arr[5]);

                kitchen.getOrderList().add(new BurgerOrder(ham, cheese, veggie, soda, toGo, orderNumber));
            }

            boolean loop = true;

            while (loop) {
				// Menu options
				System.out.println("Please select from the following menu of options, by typing a number:");
				System.out.println("\t 1. Order food");
				System.out.println("\t 2. Cancel last order");
				System.out.println("\t 3. Show number of orders currently pending");
				System.out.println("\t 4. Complete order");
				System.out.println("\t 5. Check on order");
				System.out.println("\t 6. Cancel order");
				System.out.println("\t 7. Exit");

				int num = sc.nextInt();
				switch (num) {
					case 1:
						System.out.println("How many hamburgers do you want?");
						int ham = sc.nextInt();
                        totalHam += ham;
						System.out.println("How many cheeseburgers do you want?");
						int cheese = sc.nextInt();
                        totalCheese += cheese;
						System.out.println("How many veggieburgers do you want?");
						int veggie = sc.nextInt();
                        totalVeggie += veggie;
						System.out.println("How many sodas do you want?");
						int sodas = sc.nextInt();
                        totalSoda += sodas;
						System.out.println("Is your order to go? (Y/N)");
						char letter = sc.next().charAt(0);
						boolean TOGO = false;
						if (letter == 'Y' || letter == 'y') {
							TOGO = true;
						}
						int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
						System.out.println("Thank you. Your order number is " + orderNum);
						System.out.println();
						//update end of day report
						toTXT.write(kitchen.getOrderList().get(kitchen.getNumOrdersPending() - 1).toString().getBytes());

						break;
					case 2:
						orderNum = 0;
                        if (!kitchen.getOrderList().isEmpty()) {
                            orderNum = kitchen.getOrderList().get(kitchen.getOrderList().size() - 1).getOrderNum();
                        }
						boolean ready = kitchen.cancelLastOrder();
						if (ready) {
							System.out.println("Thank you. The last order has been canceled");
							//update on canceled order
							toTXT.write(("Order #" + orderNum + " has been canceled.\n\n").getBytes());

						} else {
							System.out.println("Sorry. There are no orders to cancel.");
						}
						System.out.println();
						break;
					case 3:
						System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
						break;
					case 4:
						System.out.println("Enter order number to complete?");
						int order = sc.nextInt();
						kitchen.completeSpecificOrder(order);
						System.out.println("Your order is ready. Thank you!");
                        //update completed orders
						toTXT.write(("Order #" + order + " has been completed.\n\n").getBytes());

						break;
					case 5:
						System.out.println("What is your order number?");
						order = sc.nextInt();
						ready = kitchen.isOrderDone(order);
						if (ready) {
							System.out.println("Sorry, no order with this number was found.");
						} else {
							System.out.println("No, it's not ready, but it should be up soon. Sorry for the wait.");
						}
						System.out.println();
						break;
					case 6:
						System.out.println("What is your order number?");
						order = sc.nextInt();
						boolean cancel = kitchen.cancelOrder(order);
						if (cancel) {
							System.out.println("Your order has been successfully cancelled ");
							//update canceled order num.
							toTXT.write(("Order #" + order + " has been cancelled.\n\n").getBytes());

						} else {
							System.out.println("Sorry, we can’t find your order number in the system");
						}
						System.out.println();
						break;
					case 7:
						loop = false;
						break;
					default:
						System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, 6, or a 7");
				} //end switch
			} //end while loop 

            //new csv on uncomplete orders
			toCSV.write(kitchen.toCSV().getBytes());

            //Add total of items ordered today
            toTXT.write(("Total of Hamburgers ordered today: " + totalHam + "\n").getBytes());
            toTXT.write(("Total of Cheeseburgers ordered today: " + totalCheese + "\n").getBytes());
            toTXT.write(("Total of Veggieburgers ordered today: " + totalVeggie + "\n").getBytes());
            toTXT.write(("Total of Sodas ordered today: " + totalSoda + "\n").getBytes());
            /*
            //Add total of items canceled today
            toTXT.write(("Total of Hamburgers canceled today: " + totalHam + "\n").getBytes());
            toTXT.write(("Total of Cheeseburgers canceled today: " + totalCheese + "\n").getBytes());
            toTXT.write(("Total of Veggieburgers canceled today: " + totalVeggie + "\n").getBytes());
            toTXT.write(("Total of Sodas canceled today: " + totalSoda + "\n").getBytes());
            */

            toCSV.close();
            toTXT.close();
            sc.close();
        }//end try
        catch(InputMismatchException ex){
            System.out.println("Caught InputMismatchException. Input the proper data type and try again please.");
        }
        catch(FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException. Please check for burgerOrders1.csv and file path. Please try again.");
        }
        catch(IOException ex){
            System.out.println("Caught IOException. Try again.");
        }
        catch(Exception ex){
            System.out.println("Caught Exception. Try again.");
        }
		
	} // end main
}// end class

