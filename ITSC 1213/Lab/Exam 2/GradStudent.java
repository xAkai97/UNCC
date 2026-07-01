
public class GradStudent extends Student {
    private String undergradDegree;

    public GradStudent(String firstName, String lastName, int id, String major, double gpa, int credits, String undergradDegree) {
        super(firstName, lastName, id, major, gpa, credits);
        this.undergradDegree = undergradDegree;
    }

    public String getUndergradDegree()
    {
        return undergradDegree;
    }
    public void setUndergradDegree(String undergradDegree)
    {
        this.undergradDegree = undergradDegree;
    }
}