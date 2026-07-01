
public class UndergradStudent extends Student {
    private boolean transfer;
    private boolean secondDegree;

    public UndergradStudent(String fName, String lName, int id, String major,
            double gpa, int credits, boolean transfer, boolean secondDegree) {
        super(fName, lName, id, major, gpa, credits);
        this.transfer = transfer;
        this.secondDegree = secondDegree;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public boolean isSecondDegree() {
        return secondDegree;
    }

    public void setSecondDegree(boolean secondDegree) {
        this.secondDegree = secondDegree;
    }

    @Override
    public void display() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("ID: " + this.getId() + "\tMajor: " + this.getMajor());
        System.out.println("Transfer: " + this.transfer + "\tSecond Degree: " + this.secondDegree);
        System.out.println("GPA: " + this.getGPA() + "\tCredits Applied: " + this.getCredits()); 
    }
}