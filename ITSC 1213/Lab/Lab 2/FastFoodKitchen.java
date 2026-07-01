/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;
import java.util.ArrayList;

/**
 *
 * @author Derek
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
}
