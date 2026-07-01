public class Upgrade implements Promotion{
   
    private int minYears;
    private double increasePercent;
    private double maxSalary;
    public Upgrade(int minYears, double increasePercent, double maxSalary)
    {
        this.minYears = minYears;
        this.increasePercent = increasePercent;
        this.maxSalary = maxSalary;
    }

    public int getMinYears() {
        return minYears;
    }
    public double getMaxSalary() {
        return maxSalary;
    }
    public double getIncreasePercent() {
        return increasePercent;
    }

    public void setMinYears(int minYears) {
        this.minYears = minYears;
    }
    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }
    public void setIncreasePercent(double increasePercent) {
        this.increasePercent = increasePercent;
    }

    
    public boolean canBePromoted(Employee e) {
        if (!(e instanceof ManagementEmployee )/*e.getClass().getName() == "RegularEmployee" */&& ((RegularEmployee) e).getExpYears() > this.minYears) {
            return true;
        }
        return false;
    }
    public Employee promote(Employee e)
    {
        if(this.canBePromoted(e))
        {
           double salary = e.getSalary();
           if(salary < maxSalary)
           {
            salary += (this.increasePercent * salary);
            int extraYears = ((RegularEmployee) e).getExpYears() - minYears;
            salary += (extraYears*50);
            salary = (salary > maxSalary ? maxSalary: salary);
           }
           e.setSalary(salary);
            ManagementEmployee e2 = new ManagementEmployee(e.getFirstName(), e.getLastName(), e.getId(),e.getDepartment(),((RegularEmployee) e).getJobTitle()+"-Lead", e.getSalary(),((RegularEmployee) e).getExpYears(),0);
            return e2;
        }
        return e;
    }           
}
