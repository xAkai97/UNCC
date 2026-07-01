/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1213debugginglab;

import java.awt.Rectangle;

/**
 *
 * @author Derek Wang
 */
public class RectangleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle box1 = new Rectangle(10, 10, 40, 30);
        Rectangle box2 = new Rectangle(100, 50);
        
        System.out.println("box1: "+ box1);
        System.out.println("box2: "+ box2);
        
        box1.setLocation(20, 20);
        box2.setSize(50, 30);

        System.out.println("box1: "+ box1);
        System.out.println("box2: "+ box2);

        Rectangle box3 = box1.intersection(box2);
        double height = box3.getHeight();
        double width = box3.getWidth();
        double area = width*height;
        
        System.out.println("Area of intersecting rectangle: " + area);
        System.out.println("box3: "+ box3);
        
    }
    
}
