/**
 *
 * @author Derek Wang
 */
public class Person {
    private String firstName;
    private String lastName;
    private int id;

    public Person(String fName, String lName, int myId)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.id = myId;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getId()
    {
        return id;
    }
    public void display()
    {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("ID: " + id);
    }

}
