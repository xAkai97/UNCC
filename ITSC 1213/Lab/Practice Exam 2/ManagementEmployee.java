import java.util.ArrayList;
public class ManagementEmployee extends RegularEmployee {
    private int managerialExperience;
    private ArrayList<Employee> supervisees = new ArrayList<Employee>();
  
    public ManagementEmployee(String fName, String lName, int id, String department, String jobTitle, double salary,int expYears, int managerialExperience) {
        super(fName, lName, id, department, jobTitle, salary, expYears);
        this.managerialExperience = managerialExperience;
    }
    public boolean removeSupervisee(Employee e)
    {
        return this.supervisees.remove(e);
    }
    public void addSupervisee(Employee e)
    {
        this.supervisees.add(e);
    }
    public int getManagerialExperience()
    {
        return managerialExperience;
    }
    public ArrayList<Employee> getSupervisees()
    {
        return this.supervisees;
    }
    public void setManagerialExperience(int managerialExperience)
    {
        this.managerialExperience = managerialExperience;
    }
   
    @Override
    public void display() {
        super.display();
        System.out.println("Managerial ERxperience: "+managerialExperience) ;
    }
}