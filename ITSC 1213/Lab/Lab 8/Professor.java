import java.util.ArrayList;

/**
 *
 * @author Derek Wang
 */
public class Professor extends Person {
    private String department;
    private double salary;
    private ArrayList<Student> advisees = new ArrayList<Student>();
    
    public Professor(String firstName, String lastName, int id, String department, double salary) {
        super(firstName, lastName, id);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Student> getAdvisees() {
        return advisees;
    }

    public void setAdvisees(ArrayList<Student> advisees) {
        this.advisees = advisees;
    }
    
    public void addAdvisee(Student advisee) {
        advisees.add(advisee);
    }
    
    public boolean removeAdvisee(int id) {
        for (Student i : advisees) {
            if (i.getId() == id) {
                advisees.remove(i);
                return true;
            }
        }
        return remove;
    }

    // Lab 7 Part B
    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + department + "\tSalary: " + salary);
        System.out.println("Advisees: ");
        for (Student s : advisees) {
            System.out.println("\t" + s.getFirstName() + " " + s.getLastName());
        }
    }

    // Lab 7 Part C
    @Override
    public String toString() {
        return "Professor - " + this.getFirstName() + " " + this.getLastName();
    }
}
