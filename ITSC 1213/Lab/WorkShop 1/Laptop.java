/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workshop;

/**
 *
 * @author Derek Wang
 */
public class Laptop {
	private double size;
	private boolean display;
	private double weight;
	private int battery;
	
	public Laptop() {
		this.size = 0.0;
		this.display = true;
		this.weight = 0.0;
		this.battery = 0;
        }
        
        public double getSize() {
        return size;
        }
        
        public boolean getPower() {
        return display;
        }
        
        public double getWeight() {
        return weight;
        }
                
        public int getBattery() {
        return battery;
        }
        
        public void print() {
        System.out.println("Size: " + this.size + "inches");
        System.out.println("Display On?: " + this.display);
        System.out.println("Weight: " + this.weight + "oz");
        System.out.println("Battery Percentage?: " + this.battery + "%");
        }
}
