/* 
    Remember, you can check your work once you
    are done by pressing "Check Answer" in the
    bottom left of your screen without penalty
    
    Be sure to submit ASAP for max points!
*/
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        Scanner fileScanner;
        ArrayList<Student> students = new ArrayList();
        try {
            fileScanner = new Scanner(new File("inputData.txt"));
            
            String line = new String();
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                String[] str = line.split(",");
                String person = str[0];
                if (person.contains("student")) 
                {
                    String fName = str[1];
                    String lName = str[2];
                    int myId = Integer.parseInt(str[3]);
                    String major = str[4];
                    double gpa = Double.parseDouble(str[5]);
                    int credits = Integer.parseInt(str[6]);
                    students.add(new Student(fName, lName, myId, major, gpa, credits));                      
                }
            }
            fileScanner.close();
    } catch (FileNotFoundException ex) {
        System.out.println("Caught FileNotFoundException for inputData.txt. Try again making sure the file name and path are correct.");
    }

    Collections.sort(students);
    for (Student s : students) {
        s.display();
    }
    FileOutputStream fs;
    try {
        fs = new FileOutputStream("ScholarshipCandidates.txt");
        PrintWriter outFS = new PrintWriter(fs);

        outFS.print("Our top candidates for the scholarship are");
        //C

        outFS.print("Our middle candidates for the scholarship are");
        //C

        outFS.print("Ineligible for the scholarship are");
        //C

        outFS.close();
        fs.close();
    } catch (FileNotFoundException ex) {
        System.out.println("Caught FileNotFoundException for outputData.txt. Try again making sure the file name and path are correct.");
    } catch (IOException ex) {
        System.out.println("Caught IOException when closing output stream. Try again");
    }
    }
}