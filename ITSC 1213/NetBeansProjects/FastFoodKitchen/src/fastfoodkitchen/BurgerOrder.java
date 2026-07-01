/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;

/**
 *
 * @author Derek Wang, Andy Yeung
 */
public class BurgerOrder {

    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 3;

    public BurgerOrder(int numHam, int numCB, int numVB, int numSoda, boolean oTG, int orderNo) {
    numHamburgers = numHam;
    numCheeseburgers = numCB;
    numVeggieburgers = numVB;
    numSodas = numSoda;
    orderToGo = oTG;
    orderNum = orderNo;
    }
    
    public int getNumHamburgers() {
        return numHamburgers;
    }

    public int setNumHamburgers(int numHam) {
        if (numHamburgers < 0) {
            System.out.println("Amount cannot be less than 0!");
            return numHamburgers;
        } else {
            this.numHamburgers = numHam;
        }
        return numHamburgers;
    }

    public int getNumCheeseburgers() {
        return numCheeseburgers;
    }

    public int setNumCheeseburgers(int numCB) {
        if (numCheeseburgers < 0) {
            System.out.println("Amount cannot be less than 0!");
            return numCheeseburgers;
        } else {
            this.numCheeseburgers = numCB;
        }
        return numCheeseburgers;
    }

    public int getNumVeggieburgers() {
        return numVeggieburgers;
    }

    public int setNumVeggieburgers(int numVB) {
        if (numVeggieburgers < 0) {
            System.out.println("Amount cannot be less than 0!");
            return numVeggieburgers;
        } else {
            this.numVeggieburgers = numVB;
        }
        return numVeggieburgers;
    }

    public int getNumSodas() {
        return numSodas;
    }

    public int setNumSodas(int numSoda) {
        if (numSodas < 0) {
            System.out.println("Amount cannot be less than 0!");
            return numSodas;
        } else {
            this.numSodas = numSoda;
        }
        return numSodas;
    }

    public boolean isOrderToGo() {
        return orderToGo;
    }
    
    public boolean setOrderToGo(boolean oTG) {
        this.orderToGo = oTG;
        return orderToGo;
    }
    
    public int getOrderNum() {
        return orderNum;
    }

    public int setOrderNum(int orderNo) {
        this.orderNum = orderNo;
        return orderNum;
        }
    
}