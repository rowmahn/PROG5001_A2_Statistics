
/**
 * Write a description of class StudentData here.
 *
 * @author (Roman Dulal)
 * @studentId (24227472)
 * @version (22.09.23)
 */
import java.util.*;
public class StudentData
{
    private String lastName;
    private String firstName;
    private String studentId;
    private double[] assignmentMarks;

    public StudentData(String lastName, String firstName, String studentId, double[] assignmentMarks) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentId = studentId;
        this.assignmentMarks = assignmentMarks;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", studentId=" + studentId +
                ", assignmentMarks=" + Arrays.toString(assignmentMarks) +
                '}';
    }
}
