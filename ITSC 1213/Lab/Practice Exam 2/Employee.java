public abstract class Employee {

    private String firstName;
    private String lastName;
    private int id;
    String department;
    double salary;
    
    public Employee(String firstName, String lastName, int id, String department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.department = department;
        this.salary = salary;

    }

    public abstract void display();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }
    public String getDepartment() {
        return department;
    }
   public double getSalary() {
        return salary;
    }
     public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
      public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDepartment(String department) {
        this.department =  department;
    }
    public void setId(int id) {
        this.id= id;
    }
        
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override 
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.getId() == ((Employee)other).getId();
    }

}
