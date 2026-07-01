package lab9;

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
        return personnel;
        }

    @Override
    public void setUp(ArrayList<Person> personnel) {
        personnel = new ArrayList<>();
    }

    @Override
    public ArrayList<Student> getStudents() {
        for (Student personnel : students)
	{ 		      
	    System.out.println(personnel); 	
	}
        return null;
    }

    @Override
    public ArrayList<Professor> getProfessors() {
        for (Professor personnel : professors)
	{ 		      
	    System.out.println(personnel); 	
        }
        return Professor personnel;
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
