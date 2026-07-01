
import java.util.ArrayList;

public class Student extends Person {

    private String major;
    private double gpa;
    private int credits;
    private ArrayList<String> enrolledCourses;

    public Student(
        String fName,
        String lName,
        int id,
        String major,
        double gpa,
        int credits
    ) {
        super(fName, lName, id);
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        enrolledCourses = new ArrayList();
    }

    public void addCourse(String course) {
        enrolledCourses.add(course);
    }

    public boolean dropCourse(String course) {
        boolean drop = false;
        for (String c : enrolledCourses) {
            if (c.equalsIgnoreCase(course)) {
                enrolledCourses.remove(c);
                return true;
            }
        }
        return drop;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override 
    public void display() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("ID: " + this.getId() + "\tMajor: " + this.major);
        System.out.println("GPA: " + this.gpa + "\tCredits Applied: " + this.credits);
    }

    @Override 
    public String toString() {
        return "Student - " + super.getId();
    }
}