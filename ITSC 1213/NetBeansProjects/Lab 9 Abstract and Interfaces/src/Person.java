/**
 *
 * @author Derek Wang
 */
public abstract class Person { // Lab 9 Part B
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

    // Lab 9 Part B
    public abstract void display();
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        
        return this.getId() == ((Person) other).getId();
    }
}
