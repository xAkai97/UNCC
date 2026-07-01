package pkg1213debugginglab;
/*
 * ITSC 1213 
 * The Circle class represents a circle with a radius and color.
 */
/**
 * This class describes a circle with a default radius and color.
 * @author Derek Wang
 */

public class Circle {  // Save as "Circle.java"
   // private instance variable, not accessible from outside this class
   private double radius;
   private String color;

   // The default constructor with no argument.
   // It sets the radius and color to their default value.
   /**
     * Constructs a Circle with default radius and default color 
     */
   public Circle() {
      radius = 1.0;
      color = "red";
   }

   // 2nd constructor with given radius and color
   /**
    * @param r - double data type for radius of the Circle
    * @param clr - string data type for color of the Circle
    */
   public Circle(double r, String clr) {
      radius = r;
      color = clr;
   }

   // A public method for retrieving the radius
   /**
    * @return as a double value of the radius of the Circle 
    */
   public double getRadius() {
     return radius;
   }

   // A public method for retrieving the area of circle
   /**
    * @return as a double value of the area of circle
    */
   public double getArea() {
     double area = calculateArea();
      return area;
   }

   // A private method for computing the area of circle
   /**
    * Computes the area of the circle
    * @return the computed area of the circle
    */
   private double calculateArea(){
     return radius*radius*Math.PI;
   }
}