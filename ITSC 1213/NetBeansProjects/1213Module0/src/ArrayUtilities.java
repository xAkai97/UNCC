/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Derek Wang
 */
public class ArrayUtilities {

    public static void main(String[] args) {
        
        String message = "Welcome to ITSC1213 ArrayUtilities Program!";
        int n =5;
        
        for (int i = 0; i < n; i++) {
            System.out.println(message);
        }
        
        // test sum
        int[] numArray = {0, 2, 4, 6, 17, 20, 4};
        System.out.println("the sum of this array is: " + sum(numArray));
        // test findMax
        System.out.println("the largest number in this array is: " + findMax(numArray));
        // test findFirstOdd
        System.out.println("the first odd number in this array is: " + findFirstOdd(numArray));
        
    }
    
    public static int sum(int[] numbers) {
        // initialize a varible to hold the total
        int total = 0;
                
        //iterate over the array adding the numbers
        for (int num : numbers) {
            total += num;
        }
        //return calculated total value
        return total;
    }
    
    public static int findMax(int[] numbers) {
        // initialize a varible to keep track of max number
        int max = 0;
        
        //iterate over the array checking each number if it larger than value of max
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                //new max value found, update varible value
                max = numbers[i];
            }
        }
        //return largest value found
        return max;
    }
    
    public static int findFirstOdd(int[] numbers) {
        //iterate over the array checking each number if it is add/even
        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] % 2 == 1) {
                //return first add number found
                return numbers[i];
            }
            i++;
        }
        //if no odd numbers found return 0
        return 0;
    }
    
}