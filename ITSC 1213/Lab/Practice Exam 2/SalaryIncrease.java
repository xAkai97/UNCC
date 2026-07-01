public class SalaryIncrease implements Promotion{
    String department;
    double increasePercent;
    double maxSalary;
   

    public SalaryIncrease(String department, double increasePercent, double maxSalary)  {
        this.department = department;
        this.increasePercent = increasePercent;
        this.maxSalary = maxSalary;
    }

    public String getDepartment() {
        return department;
    }
    public double getIncreasePercent() {
        return increasePercent;
    }
    public double getMaxSalary() {
        return maxSalary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void setIncreasePercent(double increasePercent) {
        this.increasePercent = increasePercent;
    }
    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    
     public boolean canBePromoted(Employee e) {
        if (e.getDepartment() == department && e.getSalary() < this.maxSalary) {
            return true;
        }
        return false;
    }
    public Employee promote(Employee e)
    {
        if(this.canBePromoted(e))
        {
           double salary = e.getSalary();
           salary += (this.increasePercent * ((RegularEmployee) e).getExpYears() * salary);
            e.setSalary(salary);
        }
        return e;
    }

}