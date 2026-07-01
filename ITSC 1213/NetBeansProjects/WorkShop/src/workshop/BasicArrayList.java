/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workshop;
import java.util.ArrayList;

/**
 *
 * @author Derek Wang
 */
public class BasicArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> basic = new ArrayList<Integer>(4);
        for (int i=0; i < 4; i++) {
            basic.add(i, i+1);
        }

        for (int i=0; i < basic.size(); i++) {
            int e = basic.get(i)*5;
            basic.set(i, e);
        }

        basic.add(0, 0);
        System.out.println(basic);
        basic.remove(Integer.valueOf(5));
        System.out.println(basic);
        basic.set(0,1);
        System.out.println(basic);

        for (int i=0; i < basic.size(); i++) {
            System.out.println(basic.get(i));
        }
        
        if (basic.indexOf(5) == 1){
            System.out.println("Index is " + basic.indexOf(5));
        } else {
            System.out.println("Index is not found");  
        }
        
        if (basic.indexOf(15) == 2){
            System.out.println("Index is " + basic.indexOf(15));
        } else {
            System.out.println("Index is not found");
        }
        
        if (basic.isEmpty() == true){
            System.out.println("ArrayList is empty");
        } else {
            System.out.println("ArrayList is not empty");
        }
    }
}
