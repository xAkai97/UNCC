import java.util.ArrayList;

/**
 *
 * @author Derek Wang
 */
public class University implements UniversitySpecification {
    private ArrayList<Person> personnel;
    private String name;
    
    public University(String name) {
        this.name = name;
    }

    public ArrayList<Person> getPersonnel() {
        for (Person person : personnel)
	{ 		      
	}
        return person;
        }

    @Override
    public void setUp(ArrayList<Person> personnel) {
        personnel = new ArrayList<>();
    }

    @Override
    public ArrayList<Student> getStudents() {
        for (Person s : personnel)
	{ 		      
	    System.out.println(personnel); 	
	}
        return null;
    }

    @Override
    public ArrayList<Professor> getProfessors() {
        for(Person professor : personnel)
	{ 		      
	    System.out.println(personnel); 	
        }
        return null;
    }

    @Override
    public void newStudent(Student s) {
        personnel.add(s);
    }

    @Override
    public void newProfessor(Professor p) {
        personnel.add(p);
    }
}
