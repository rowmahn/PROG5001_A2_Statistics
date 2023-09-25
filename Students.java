
/**
 * Write a description of class Students here.
 *
 * @author (Roman Dulal)
 * @studentId (24227472)
 * @version (19.09.23)
 */
import java.io.*;
import java.util.*;
public class Students
{
    

    public static void main (String[] args){
    
        readDataFromFile();
    
    }
    
    public static void readDataFromFile(){
        String fileName;
        Scanner sc = new Scanner(System.in);
        
        //Input file name
        System.out.println("Enter file name");
        fileName = sc.nextLine();
        
        //Reading the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
            String unitName = null;
            String line;
            List<StudentData> studentDataList = new ArrayList<>();
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue; // Skip comments
                }

                if (unitName == null) {
                    unitName = line.trim();
                    continue;    
                }
                
                // Parsing the contents from the file

                String[] data = line.split(",");   
                
                if (data.length >= 6) {
                    String lastName = data[0].trim();
                    String firstName = data[1].trim();
                    String studentId = data[2].trim();
                    double[] assignmentMarks = new double[3]; //Array to store A1, A2 & A3.
                    
                    try {  
                        for (int i = 0; i < 3; i++) {
                        if (!data[i + 3].trim().isEmpty()) {
                            assignmentMarks[i] = Double.parseDouble(data[i + 3].trim());
                        } else {
                            assignmentMarks[i] = 0.0; // Set to 0 if the field is blank or null
                        }
                    }
                        StudentData student = new StudentData(lastName, firstName, studentId, assignmentMarks);
                        studentDataList.add(student);
    
                    } catch (NumberFormatException e) {
                                System.err.println("Error parsing assignment marks: " + e.getMessage());
                    }
                }
            
            }
            
            System.out.println("Unit Name: " + unitName);
            
            //F2 Calculating total marks
            System.out.println("Student Data:");
             for (StudentData student : studentDataList) {
                double totalMark = 0.0;
                for (double mark : student.getAssignmentMarks()) {
                    totalMark = totalMark + mark;
                }
                System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Assessment Marks: " + Arrays.toString(student.getAssignmentMarks()));
                System.out.println("Total Mark: " + totalMark);
                System.out.println();
            }

            reader.close();
        
        }
        
        catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
    
}
