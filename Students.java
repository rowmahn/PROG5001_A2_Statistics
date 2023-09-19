
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
        String fileName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name");
        
        fileName = sc.nextLine();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
            String unitName = null;
            unitName = reader.readLine().trim();
            System.out.println("The name of the unit is "+unitName);
        } 
        
        catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    
    }
    
}
