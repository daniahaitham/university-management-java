package finalAdvancedProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.io.File;

public class StudentPerformance implements infoRetrieval , StatisticalOperation , InfoProviderByDeptName,OperationsOnMarks{

	private int StdID;
	private String semesterName;
	private int paperID;
	private String paperName;
	private int Marks;

	public StudentPerformance() {
	}

	static List<String[]> StudentPerformanceArr = new ArrayList<>();
	{
		readingFiles.readDataFromFile("Student_Performance_Data.txt", StudentPerformanceArr);


	}

	public int getStdID() {
		return StdID;
	}

	public void setStdID(int stdID) {
		StdID = stdID;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public int getPaperID() {
		return paperID;
	}

	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public int getMarks() {
		return Marks;
	}

	public void setMarks(int marks) {
		Marks = marks;
	}




	public static int NumOfPapersForStd(String studentId) {
		int numOfSemesters = 0;

	    for (String[] eachStd : StudentPerformanceArr) {
	        if (eachStd[0].equals(studentId)) {
	            String semesterName = eachStd[1];

	            // Iterate over previous records to check if there's a match
	            if (eachStd[0].equals(studentId) && eachStd[1].equals(semesterName)) {
	                numOfSemesters++;
	                }
	         
	        }
	    }

	    return numOfSemesters;
	
	}

	public static int NumOfSemestersForStd(String studentId) {
		int numOfSemesters = 0;
	    Set<String> UniqueSem = new HashSet<>();

	    for (String[] eachStd : StudentPerformanceArr) {
	        if (eachStd[0].equals(studentId)) {
	            String semesterName = eachStd[1];

	            // Check if the semester has already been counted
	            if (!UniqueSem.contains(semesterName)) {
	                UniqueSem.add(semesterName);
	                numOfSemesters++;
	            }
	        }
	    }

	    return numOfSemesters;
	}



	
	
	@Override
	public void retrieveMyInfo(String id) {
		// Retrieve student performance information based on student ID


																				// once

		for (String[] OneStperformance : StudentPerformanceArr) {
			String currentstdID = OneStperformance[0];
			// Print department data
			if (currentstdID.equals(id)) {

				for (String field : OneStperformance) {
					System.out.print(field + "\n");
				}
				System.out.println(); // Move to the next line for the next line

				return ;
			}

		}

		System.out.println("Student not found!");
		return ;
		
	}

	@Override
	public int OperationOnGivenDept(String dept) {

		//this is num Of std In Dept

		
		int count = 0;
		for (String[] department : StudentPerformanceArr) {
			if (department[4].equals(dept)) {
				count++;
			}
		}
		return count;
		
	}


    @Override
	//this return type is bacouse it will give all the row .

	public String[] retrieveInfoByDept(String deptName) {
		for (String[] studentInfo : StudentPerformanceArr) {
			if (studentInfo[4].equals(deptName)) {
				return studentInfo;
			}
		}
		return null;
	}

	
	
	// range in marks is 0 and 100 so :

	@Override
	public int getMaxMarks(String stdId) {
		int maxMarks = 0;

		for (String[] eachStdRow : StudentPerformanceArr) {
			if (eachStdRow[0].equals(stdId)) {
				int marks = Integer.parseInt(eachStdRow[4]); // Parse marks from string to int
				if (marks > maxMarks) {
					maxMarks = marks; // Update maxMarks if current marks are greater
				}
			}
		}

		return maxMarks;
	}

	@Override
	public int getMinMarks(String stdId) {
		int minMarks = 100; // Initialize minMarks to 100 (assuming max marks are less than 100)

		for (String[] eachStdRow : StudentPerformanceArr) {
			if (eachStdRow[0].equals(stdId)) {
				int marks = Integer.parseInt(eachStdRow[4]); // Parse marks from string to int
				if (marks < minMarks) {
					minMarks = marks; // Update minMarks if current marks are smaller
				}
			}
		}

		return minMarks;
	}

	@Override
	public double getAverageMarks(String stdId) {
		int totalMarks = 0;
	    int count = 0;

		for (String[] eachStdRow : StudentPerformanceArr) {
			if (eachStdRow[0].equals(stdId)) {
				totalMarks += Integer.parseInt(eachStdRow[4]);
				count++;
			}
		}
	    if (count == 0) return 0; // Avoid division by zero

		return (double) totalMarks / count;
	}

	@Override
	public int getTotalMarks(String stdId) {
		int sum = 0;

		for (String[] eachStdRow : StudentPerformanceArr) {
			if (eachStdRow[0].equals(stdId)) {
				int marks = Integer.parseInt(eachStdRow[4]); // Parse marks from string to int
				sum += marks;
			}

		}
		return sum;
	}
}
