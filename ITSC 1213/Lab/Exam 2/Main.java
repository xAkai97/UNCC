
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Student student1 = new UndergradStudent(
            "Xavier",
            "Cato",
            900111222,
            "CS",
            3.5,
            75,
            false,
            false
        );
        Student student2 = new UndergradStudent(
            "Kathrine",
            "Johnson",
            900,
            "CS",
            4.0,
            100,
            false,
            true
        );
        Student student3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student student4 = new GradStudent(
            "Kimberly",
            "Bryant",
            902,
            "CS",
            3.0,
            80,
            "EE"
        );
        Student student5 = new UndergradStudent("David", "Davidson", 905, "Art History", 3.6, 12,true,true);

        ArrayList<Student> applicants = new ArrayList();

        applicants.add(student1);
        applicants.add(student2);
        applicants.add(student3);
        applicants.add(student4);
        applicants.add(student5);

        REUScholarship reu = new REUScholarship(
            "Research Experience for Undergraduates",
            3.0,
            30
        );

        int count = 0;
        for (Person s : applicants) {

            if (s instanceof Student && reu.isQualified((Student)s)) {
                ((Student)s).display();
                count++;
                System.out.println("********");
            }
        }
        System.out.println(
            count + " Students qualify for the REU scholarship."
        );
    }
}