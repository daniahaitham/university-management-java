package finalAdvancedProgramming;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class managemantSystem {

    public static void main(String[] args) {

      
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("\n\n\n Welcome in Uni-System , press the suitable num :");
            System.out.println("1. Department info options :");
            System.out.println("2. Employees information options : ");
            System.out.println("3. Students counceling information options :");
            System.out.println("4. Students performance information options :");
            System.out.println("5. Exit");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                   	departmentOptions(scanner, new Department());
            	
                        
                        break;
                    case 2:
                        employeesOptions(scanner, new Employee());

                        break;
                    case 3:
                        studentsCounselingOptions(scanner, new StudentCounseling());
 	

                        break;
                    case 4:
                        studentsPerformanceOptions(scanner, new StudentPerformance());

                        break;
                  
                    case 5:
                        System.out.println("SYSTEM EXIT!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // moving the scanner to the next line to accept
            }
        } while (choice != 5); 

        scanner.close(); // Close the Scanner object
    }
    
    
    
    

    
    private static void employeesOptions(Scanner scanner, Employee employee) {
//        employee.printarr();
        System.out.println("Choose one of the options:");
        System.out.println("1. Show employee info by given Employee ID");
        System.out.println("2. Show employee numbers in a given department (by department ID)");
        System.out.println("3. Show employee info in a given department (by department ID)");

        
        try {
        int empChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (empChoice) {
            case 1:
                System.out.println("Enter Employee ID: ");
                String empId = scanner.nextLine();
                employee.retrieveMyInfo(empId);
                break;
            case 2:
            	 System.out.println("Enter Department ID (e.g. IDEPT5109): ");
                 String DeptName = scanner.nextLine();
             System.out.println(employee.OperationOnGivenDept(DeptName));   
                 break;
            case 3:
            	 System.out.println("Enter Department ID (e.g. IDEPT5109): ");
                 String DeptName2 =scanner.nextLine();
                 employee.retrieveInfoByDept(DeptName2);
                 break;            
            default:
                System.out.println("Invalid choice. Please try again.");
        }} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // moving the scanner to the next line to accept
        
        }
    }
    
    

    private static void studentsCounselingOptions(Scanner scanner, StudentCounseling studentCounseling) {

        System.out.println("Choose one of the options:");
        System.out.println("1. Show Students info by given Department ID");
        System.out.println("2. Show Students info by given range of admission dates");
        System.out.println("3. Show Students info by given range of birth dates");
        System.out.println("4. Show Student info by given student ID");

        
        try {

        int studentChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (studentChoice) {
            case 1:
                System.out.println("Enter Department ID (e.g. IDEPT7783): ");
                String deptName = scanner.nextLine();
                StudentCounseling.retrieveStdInfoByDeptid(deptName);
                break;
            case 2:
                System.out.println("Enter Start Admission Date (YYYY-MM-DD): DONT CHANGE THE FORMAT OF DATE ( ENTER IT AS REQUIRED)");
                String startDOA = scanner.nextLine();
                System.out.println("Enter End Admission Date (YYYY-MM-DD): DONT CHANGE THE FORMAT OF DATE ( ENTER IT AS REQUIRED)");
                String endDOA = scanner.nextLine();
                StudentCounseling.retrieveStdInfoByDOA(startDOA, endDOA);
                break;
            case 3:
                System.out.println("Enter Start Date of Birth (YYYY-MM-DD):DONT CHANGE THE FORMAT OF DATE ( ENTER IT AS REQUIRED) ");
                String startDOB = scanner.nextLine();
                System.out.println("Enter End Date of Birth (YYYY-MM-DD): DONT CHANGE THE FORMAT OF DATE ( ENTER IT AS REQUIRED)");
                String endDOB = scanner.nextLine();
                StudentCounseling.retrieveStdInfoByDOB(startDOB, endDOB);
                break;
            case 4:
                System.out.println("Enter Student ID: ");
                String studentId = scanner.nextLine();
                studentCounseling.retrieveMyInfo(studentId);
              
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // moving the scanner to the next line to accept
        
        }
    }
    
    
    private static void studentsPerformanceOptions(Scanner scanner, StudentPerformance studentPerformance) {
    	
    	
    	
    	

        System.out.println("Choose one of the options:");
        System.out.println("1. Show number of semesters for a student");
        System.out.println("2. Show number of papers for a student");
        System.out.println("3. Show a Student info by given student ID");
        

        System.out.println("4. Show max marks for a student");
        System.out.println("5. Show min marks for a student");
        System.out.println("6. Show average marks for a student");
        System.out.println("7. Show total marks for a student");

        
        try {
        int performanceChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (performanceChoice) {
            case 1:
            	 System.out.println("Enter Student id: ");
                 String stdId = scanner.nextLine();
                 System.out.println(  studentPerformance.NumOfSemestersForStd(stdId));
               
            	break;
            case 2:
            	System.out.println("Enter Student id: ");
                String stdId1 = scanner.nextLine();
                System.out.println( studentPerformance.NumOfPapersForStd(stdId1));
           
           	break;
            case 3:
                System.out.println("Enter Student ID: ");
                String studentId =  scanner.nextLine();
                // this is logically not t
                studentPerformance.retrieveMyInfo (studentId);
         
                break;


            case 4:
            	System.out.println("Enter Student ID: ");
                String StdID = scanner.nextLine();
              System.out.println( studentPerformance.getMaxMarks (StdID)); 
           	break;
            case 5:
            	System.out.println("Enter Student ID: ");
                String StdID2 = scanner.nextLine();
              System.out.println(  studentPerformance.getMinMarks (StdID2));  
           	break;
            case 6:
            	System.out.println("Enter Student ID: ");
                String StdID3 = scanner.nextLine();
                System.out.println(studentPerformance.getAverageMarks (StdID3));
               	break;
            case 7:
            	System.out.println("Enter Student ID: ");
                String StdID4 = scanner.nextLine();
                System.out.println(studentPerformance.getTotalMarks(StdID4)); 
               	break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // moving the scanner to the next line to accept
        
        }
    }
    
    
    
    private static void departmentOptions(Scanner scanner, Department department) {

        System.out.println("Choose one of the options:");
        System.out.println("1. Show all department inforamtion y giving department ID ");
        System.out.println("2. Show Students info AND employee info related to a department by giving ID ");
        
        
        try {
        int studentChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (studentChoice) {
            case 1:
            	 System.out.println("Enter Department ID: ");
                 String deptId = scanner.nextLine();
                 department.retrieveMyInfo(deptId);
            	
            	

                break;
            case 2:
           	 System.out.println("Enter Department ID: ");

                  String departmentId = scanner.nextLine();

                  department.retrieveStdEmpInfo(departmentId);
                break;
           
            default:
                System.out.println("Invalid choice. Please try again.");
        }} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // moving the scanner to the next line to accept
        
        }
    }
}

