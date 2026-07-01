/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Derek Wang, Andy Yueng
 */
public class FastFoodKitchen {
    private ArrayList<BurgerOrder> orderList = new ArrayList<>();
    private static int nextOrderNum;
    
    /**
     * @return next order number
     */
    public int getnextOrderNum() {
        return nextOrderNum;
    }
    
    /**
     * Add 1 to nextOrderNum
     */
    private static void incrementNextOrderNum() {
        nextOrderNum++;
    }
    
    /**
     * Constructor with 3 initial orders from FastFoodKitchen, added to ArrayList
     */
    public FastFoodKitchen () {
        BurgerOrder order1 = new BurgerOrder(3,5,4, 12, true, 1);
        BurgerOrder order2 = new BurgerOrder(0,0,3,3,false,2);
        BurgerOrder order3 = new BurgerOrder(1,1,0,2,true,3);
        orderList.add(order1);
        FastFoodKitchen.incrementNextOrderNum();
        orderList.add(order2);
        FastFoodKitchen.incrementNextOrderNum();
        orderList.add(order3);
        FastFoodKitchen.incrementNextOrderNum();
    }
    
     /**
     * @param ham Hamburgers
     * @param cheese
     * @param veggie
     * @param soda
     * @param toGo ToGo orders
     * @return Order Number
     */
    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo){
        BurgerOrder newOrder = new BurgerOrder(ham, cheese, veggie, soda, toGo, 4);
        orderList.add(newOrder);
        FastFoodKitchen.incrementNextOrderNum();
        return nextOrderNum;
    }
    
    /**
     * @return True if last order is successfully cancelled, false if failed (initial order number less than 1)
     */
    public boolean cancelLastOrder(){
        if (orderList.size() > 1){
            orderList.remove(orderList.size() - 1);
            nextOrderNum--;
            return true;
        }
        else if (orderList.isEmpty()){
            return false;
        } else {
        }
        return false;
    }
    
    /**
    * @return Pending order
    */
    public int getNumOrdersPending(){
        return orderList.size();
    }
    
    /**
     * @param orderID passed to check the numbers of orderList
     * @return Returns true if order number matches the orderID, false if else
     */
    public boolean isOrderDone(int orderID){
        for (int i = 0; i < orderList.size(); i++)
        {
            if(orderID == orderList.get(i).getOrderNum()){
                return false;
            }
        }
        return true;
        }
    
    /**
     * @param orderID passed to check the numbers of orderList to cancel
     * @return true if orderID matches an orderNumber and order canceled, false if else
     */
    public boolean cancelOrder(int orderID){
        for (int i = 0; i < orderList.size(); i++)
        {
            if(orderID == orderList.get(i).getOrderNum()){
                orderList.remove(i);
                return true;
            }
        }
        return false;
    }
    /**
     * Part A
     * @param orderID for sequential search to find in the orderList
     * @return The position of the orderID in the orderList or -1 if it is not found
     */
    public int findOrderSeq(int orderID){
        for (int i = 0; i <= orderList.size() -1; i++){
            if (orderID == orderList.get(i).getOrderNum()) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Part B
     * Use SelectionSort to sort the orderList
     */
    public void selectionSort(){
        for (int i = 0; i < orderList.size() -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < orderList.size(); j++){
                if (orderList.get(j).getNumHamburgers() + orderList.get(j).getNumCheeseburgers() + orderList.get(j).getNumVeggieburgers() < orderList.get(minIndex).getNumHamburgers() + orderList.get(minIndex).getNumCheeseburgers() + orderList.get(minIndex).getNumVeggieburgers()){
                    minIndex = j;
                }
            }
            // Swapping i with minIndex in if statement in OrderList
            Collections.swap(orderList, i, minIndex);
        }
    }
    
    /**
     * Part C
     * Use InsertionSort to sort the orderList
     */
    public void insertionSort(){
        if (!orderList.isEmpty()){
            for (int i = 1; i < orderList.size(); i++){
                int pointer = i;
                int totalBurg = orderList.get(i).getNumHamburgers() + orderList.get(i).getNumCheeseburgers() + orderList.get(i).getNumVeggieburgers() ;
                //tempOrder = orderList.get(i);
                while (pointer > 0 && (totalBurg < orderList.get(pointer - 1).getNumHamburgers() + orderList.get(pointer - 1).getNumCheeseburgers() + orderList.get(pointer - 1).getNumVeggieburgers())){
                    BurgerOrder temp = orderList.remove(pointer -1);
                    orderList.add(pointer, temp);
                    pointer--;
                }
            }
        }
    }
    
    /**
     * @param orderID to search OrderList for position
     * @return the current position in orderList or return -1 if not found
     */
    public int findOrderBin(int orderID){
        int left = 0;
        int right = orderList.size() -1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (orderID == orderList.get(middle).getOrderNum()){
                return middle;
            }
            else if (orderID > orderList.get(middle).getOrderNum()){
                left = middle + 1;
            }
            else if (orderID < orderList.get(middle).getOrderNum()){
                right = middle - 1;
            }
            else {
                return -1;
            }
        }
        return -1;

    }
    
    /**
     * Part B
     * @return orderList
     */
    public ArrayList<BurgerOrder> getOrderList(){
        return orderList;
    }
}
