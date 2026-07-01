import java.util.ArrayList;

/**
 *
 * @author Derek Wang
 */
public class Student extends Person implements Comparable<Student>{
    
    private String major;
    private double gpa;
    private int credits;
    private double balance;
    private boolean transfer;
	
    private ArrayList<String> enrolledCourses;
    
    public Student(String fName, String lName, int myId, String major, double gpa, int credits) {
        super(fName, lName, myId);
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        balance =0;
        enrolledCourses = new ArrayList();
    }
public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
    
    public void addCourse(String course) {
        enrolledCourses.add(course);
    }
    
    public boolean dropCourse(String course) {
        for (String i : enrolledCourses) {
            if (i.equals(course)) {
                enrolledCourses.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("ID: " + this.getId() + "\tMajor: " + major);
        System.out.println("GPA: " + gpa + "\tCredits Applied: " + credits);
        System.out.println("Enrolled Courses: ");
        
        for (int i = 0; i < enrolledCourses.size(); i++) {
            System.out.println("\t" + enrolledCourses.get(i));
        }
    }

    @Override
    public String toString() {
        return "Student - " + this.getFirstName() + " " + this.getLastName();
    }

    // Lab 9 Part C
    @Override
    public int compareTo(Student o) {
    double sGPA = this.getGpa(); 
    double oGPA = o.getGpa();  
   
        if (sGPA > oGPA) {  
            return 1;
        }
        else if (sGPA < oGPA) {  
            return -1; 
        }
        else if (sGPA == oGPA) {
            return 0;
        }
        else return 99;
    }
}
