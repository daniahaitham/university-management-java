package finalAdvancedProgramming;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentCounseling implements infoRetrieval {

    private int StdID;
    private String deptChoice;
    private String deptName;
    private String DOA;
    private String DOB;

    // Dependency: StudentCounseling depends on readingFiles to read data
  public static List<String[]> allStudents = new ArrayList<>();

    static {
        readingFiles.readDataFromFile("Student_Counceling_Information.txt", allStudents);
    }

    public int getStdID() {
        return StdID;
    }

    public void setStdID(int stdID) {
        StdID = stdID;
    }

    public String getDeptChoice() {
        return deptChoice;
    }

    public void setDeptChoice(String deptChoice) {
        this.deptChoice = deptChoice;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDOA() {
        return DOA;
    }

    public void setDOA(String dOA) {
        DOA = dOA;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    // Example of Association: StudentCounseling is associated with many students (allStudents list)
    public static StudentCounseling retrieveStdInfoByDeptid(String dept) {
        StudentCounseling studentCounselingInfo = new StudentCounseling(); // Create an instance to store the information
        boolean found = false;

        for (String[] oneStudent : allStudents) {
            String currentStuDept = oneStudent[4]; // Assuming department ID is at index 4

            if (currentStuDept.equals(dept)) {
                found = true;

                for (String field : oneStudent) {
                    System.out.print(field + " | ");
                }
                System.out.println(); // Move to the next line for the next student
            }
        }

        if (!found) {
            System.out.println("No students found for the department: " + dept);
        }
        
        return studentCounselingInfo; // Return the created instance
    }

    // THE OffsetDateTime deals with the Zulu dates rather than the LocalTime.
    public static void retrieveStdInfoByDOA(String startDate, String endDate) {
        OffsetDateTime start = OffsetDateTime.parse(startDate + "T00:00:00Z");
        OffsetDateTime end = OffsetDateTime.parse(endDate + "T23:59:59Z");

        for (String[] student : allStudents) {
            OffsetDateTime eachStudentDOA = OffsetDateTime.parse(student[1]);

            if (!eachStudentDOA.isBefore(start) && !eachStudentDOA.isAfter(end)) {
                for (String oneRow : student) {
                    System.out.print(oneRow + " | ");
                }
                System.out.println();
            }
        }
    }

    // OUR data set has dates in this format: 1996-07-23T00:00:00Z
    // so we will let the user enter dates, then add the zone time to them for parsing and comparison.
    public static void retrieveStdInfoByDOB(String startDate, String endDate) {
        OffsetDateTime start = OffsetDateTime.parse(startDate + "T00:00:00Z");
        OffsetDateTime end = OffsetDateTime.parse(endDate + "T23:59:59Z");

        for (String[] student : allStudents) {
            OffsetDateTime eachStudentDOB = OffsetDateTime.parse(student[2]);

            if (!eachStudentDOB.isBefore(start) && !eachStudentDOB.isAfter(end)) {
                for (String oneRow : student) {
                    System.out.print(oneRow + " | ");
                }
                System.out.println();
            }
        }
    }

    @Override
    public void retrieveMyInfo(String id) {
        for (String[] oneStCounseling : allStudents) {
            String currentStdID = oneStCounseling[0];
            if (currentStdID.equals(id)) {
                for (String field : oneStCounseling) {
                    System.out.print(field + "\n");
                }
                System.out.println();
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    
}
