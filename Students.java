
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
        System.out.println("Enter file name");
        
        fileName = sc.nextLine();
        
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

                String[] data = line.split(",");   
                
                if (data.length >= 6) {
                    String lastName = data[0].trim();
                    String firstName = data[1].trim();
                    String studentId = data[2].trim();
                    
                    try {
                        double[] assignmentMarks = Arrays.stream(data, 3, 6)
                                                        .mapToDouble(Double::parseDouble)
                                                        .toArray();
                        StudentData student = new StudentData(lastName, firstName, studentId, assignmentMarks);
                        studentDataList.add(student);
    
                    } catch (NumberFormatException e) {
                                System.err.println("Error parsing assignment marks: " + e.getMessage());
                    }
                }
            
            }
            
            System.out.println("Unit Name: " + unitName);
            System.out.println("Student Data:");
            for (StudentData student : studentDataList) {
                System.out.println(student.toString());
            }

            reader.close();
        
        }
        
        catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
    
}
