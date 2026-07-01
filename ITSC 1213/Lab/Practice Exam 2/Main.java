import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new RegularEmployee(
            "Kate",
            "Davis",
            801,
            "Sales",
            "Sales Representative",
            6000,
            6           
        );
        Employee employee2 = new RegularEmployee(
            "Basem",
            "Yousef",
            802,
            "Engineering",
            "Software Engineer",
            10000,
            8
            );
        Employee employee3 = new RegularEmployee("Ryan", "Kyle", 803, "Quality Control", "Performance Tester", 4500, 4);
        Employee employee4 = new ManagementEmployee(
            "Mary Lou",
            "Maher",
            902,
            "Engineering",
            "Production Coordinator-Lead",
            20000,
            15,
            5

        );
        Employee employee5 = new RegularEmployee("Rana", "Khalil", 904, "Sales", "Cutomer Care", 3000, 2);

        ArrayList<Employee> employees = new ArrayList();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        System.out.println("Employees of Digital Passion Solutions are:");
        for (Employee e : employees) {
            e.display();
        }
        SalaryIncrease salaryIncrease = new SalaryIncrease("Sales",0.05,5000);
        Upgrade upgrade = new Upgrade( 5,0.20, 10000);
        
        int count = 0;
        System.out.println("Upgraded Employees:");
        for (int i = 0; i<employees.size();i++) {
            Employee e = employees.get(i);
            if (upgrade.canBePromoted(e)) {
                Employee e2 = upgrade.promote(e);
                employees.remove(i);
                i--;
                employees.add(e2);
                e2.display();
                count++;
                System.out.println("$$$$$$$$$$$$$$$");
            }
        }
        System.out.println(
            count + " employees got upgrade."
        );
        int count2 = 0;
        System.out.println("Salary Increase Employees:");
        for (Employee e : employees) {

            if (e instanceof RegularEmployee && salaryIncrease.canBePromoted(e)) {
                salaryIncrease.promote(e);
                e.display();
                count2++;
                System.out.println("$$$$$$$$$$$$$$$");
            }
        }
        System.out.println(
            count2 + " employees got SalaryIncrease."
        );
    }
}