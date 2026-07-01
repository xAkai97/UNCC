
public class REUScholarship implements ScholarshipSpecification {
    String name;
    double minGPA;
    int minCredits;

    public REUScholarship(String name, double minGPA, int minCredits){
        this.name = name;
        this.minGPA = minGPA;
        this.minCredits = minCredits;
    }
    public double getMinGPA() {
        return minGPA;
    }
    public double getMinCredits() {
        return minCredits;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMinGPA(double minGPA) {
        this.minGPA = minGPA;
    }
    public void setMinCredits(int minCredits) {
        this.minCredits = minCredits;
    }

    public String getName() {
        return name;
    }
    public boolean isQualified(Student s) {
        if (s instanceof Student) {
            if (s.getGPA() > this.minGPA) {
                if (s.getCredits() > this.minCredits) {
                    return true;
                }
            }
        }
        return false;
    }
}