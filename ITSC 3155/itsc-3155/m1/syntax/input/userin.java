// getting user input in Java
package m1.syntax.input;

import java.util.Scanner;

public class userin {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scnr.nextLine();
        System.out.println("Hello, " + name);
        scnr.close();
    }
}