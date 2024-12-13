// basic while loops in Java
package m1.syntax.loops;

public class whiles {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            System.out.println("Looping: x is " + x);
            x *= 2;
        }
        System.out.println("x is now " + x);
    }

}
