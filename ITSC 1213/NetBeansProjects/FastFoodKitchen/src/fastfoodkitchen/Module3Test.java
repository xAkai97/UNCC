/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;
import java.util.ArrayList;

/**
 *
 * @author Derek Wang, Andy Yeung
 */
public class Module3Test {
    public static void main(String[] args) {
        FastFoodKitchen kitchen = new FastFoodKitchen();
        
        // Part A
        int orderPosition = kitchen.findOrderSeq(2);
        System.out.println("Using sequential search >> order position is " + orderPosition);
        
        // Part B
        kitchen.selectionSort();
        ArrayList<BurgerOrder> sortedOrders = kitchen.getOrderList();
        int orderSize = 0;
        System.out.println("Using SelectionSort");
                    
        for (BurgerOrder order : sortedOrders){
            orderSize = order.getNumHamburgers() + order.getNumCheeseburgers() + order.getNumVeggieburgers();
            System.out.println(order.getOrderNum() + " has " + orderSize + " burgers.");
        }
        
        // Part C
        kitchen.insertionSort();
        System.out.println("Using InsertionSort");

        for (BurgerOrder order : sortedOrders) {
            orderSize = order.getNumHamburgers() + order.getNumCheeseburgers() + order.getNumVeggieburgers();
            System.out.println(order.getOrderNum() + " has " + orderSize + " burgers.");
        }
        
        // Part D
        orderPosition = kitchen.findOrderBin(2);
        System.out.println("Using Binary Search >> Order position is " + orderPosition);
    }

}
