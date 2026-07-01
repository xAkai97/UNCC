import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Derek Wang
 */
 
public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kimberly", "Bryant", 902, "Electric Engineering", 3.0, 80);
        Student s5 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);

        Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);

        System.out.println("*** Lab 9 Part B ***");        
        prof1.display();
        System.out.println("\n");

        System.out.println("*** Lab 9 Part C ***");
        int compareStudents = s4.compareTo(s1);
        double sGPA = s4.getGpa(); 
        double oGPA = s1.getGpa();  
        System.out.println("Students GPA: " + sGPA + " and " + oGPA);
        System.out.println(compareStudents);

        ArrayList<Student> students = new ArrayList();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s.getGpa());
        }
    }
}