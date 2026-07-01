public class RegularEmployee extends Employee {
    private String jobTitle;
    private int expYears;
  
    public RegularEmployee(String fName, String lName, int id, String department, String jobTitle, double salary,int expYears) {
        super(fName, lName, id, department, salary);
        this.expYears = expYears;
        this.jobTitle = jobTitle;
    }

    public int getExpYears()
    {
        return expYears;
    }
    public void setExpYears(int expYears)
    {
        this.expYears = expYears;
    }
    public String getJobTitle()
    {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }
    @Override
    public void display() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("ID: " + this.getId() + "\tDepartment: " + this.getDepartment());
        System.out.println("JobTitle: " + this.jobTitle + "\tYears of Experience: " + this.expYears);
        System.out.println("Salary: " + this.getSalary()); 
    }
}