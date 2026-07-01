import java.util.ArrayList;

/**
 *
 * @author Derek Wang
 */
 
public class Main {

    public static void main(String[] args) {
        Person p = new Person("Raya", "Whitker", 800555555);
        //p.display();
        //System.out.println("\n");

        Student s1 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        s1.setTransfer(true);
        s1.setBalance(100);
        s1.addCourse("Java Programming");
        s1.addCourse("Calculus");

        //s1.display();
        //System.out.println("\n");
        /*
        if (s1.dropCourse("Spanish")) {
            System.out.println("The class has been dropped");
        }else{
            System.out.println("You are not enrolled in this Course. " + "No Courses have been dropped.");
        }
        ArrayList<String> enrolledCourses = s1.getEnrolledCourses();
        System.out.println("You are enrolled in the following courses:");
        for (String course : enrolledCourses) {
            System.out.println(course);
        }
        */

        Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kimberly", "Bryant", 902, "Electric Engineering", 3.0, 80);
        
        Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);
        /*
        prof1.addAdvisee(s2);
        prof1.addAdvisee(s3);
        prof1.addAdvisee(s4);

        System.out.println("\n");
        prof1.display();
        System.out.println("\n");

        if (prof1.removeAdvisee(902)) {
            System.out.println("The advisee has been removed");
        } else {
            System.out.println("This student is not an advisee of Professor "
                    + prof1.getFirstName() + " " + prof1.getLastName());
        }
        
        ArrayList<Student> myAdvisees = prof1.getAdvisees();
        System.out.println("Professor " + prof1.getFirstName() + " " + prof1.getLastName() + " advisees:");
        for (Student s : myAdvisees) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
        
        System.out.println(s1);//this complies to s1.toString()
        System.out.println(prof1);//this complies to prof1.toString()
        System.out.println(s1.equals(s4));
        Student s5 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        System.out.println(s1.equals(s5));
        System.out.println(s1.equals(prof1));
        
        Person[] personArray = {s1, s2, prof1};
        ArrayList<Person> personList = new ArrayList();
        personList.add(s1);
        personList.add(s2);
        personList.add(prof1);
                    
        for(Person person : personList) {
            System.out.println(person);
        }
        */
    
        System.out.println("*** Lab 8 Part A ***");
        ArrayList<Person> list = new ArrayList();

        list.add(p);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(prof1);

        Person p2 = new Person("Elle", "Kambol", 800);
        list.add(p2);

        Professor prof2 = new Professor("Frank", "Black", 801, "Math", 85000);
        list.add(prof2);

        Student s5 = new Student("Grace", "Maxeem", 903, "Psychology", 3.4, 95);
        list.add(s5);

        for (Person person : list) {
            person.display();
        }

        System.out.println("\n");
        System.out.println("*** Lab 8 Part B ***");
        for (Person person : list) {
        showProfile(person, 903);
        }

        System.out.println("\n");
        System.out.println("*** Lab 8 Part C ***");
        Person p3 = new Student("Maya", "Adams", 700, "Music", 3.5, 105);
        System.out.println(((Student)p3).getGpa());

        Person p4 = new Person("Bob", "Lowe", 701);
        if (p4 instanceof Student) {
            System.out.println(((Student)p4).getGpa());
        }

        System.out.println("Students eligible for scholarship: ");
        for (Person person : list) {
            if (person instanceof Student && ((Student) person).getGpa() > 3.5) {
                System.out.println("\t" + person.getFirstName() + " " + person.getLastName());
            }
        }
        System.out.println("Professors in CS: ");
        for (Person person : list) {
            if (person instanceof Professor && ((Professor) person).getDepartment().equals("CS")) {
                System.out.println("\t" + person.getFirstName() + " " + person.getLastName());
            }
        }
    }
    // Lab 8 Part B
    public static void showProfile(Person p, int id) { 
        if (p.getId() == id) {
            p.display();
        }
    }
}

