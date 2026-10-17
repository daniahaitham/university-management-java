package finalAdvancedProgramming;
import java.util.ArrayList;
import java.util.List;

public class Department  extends EmpDept implements infoRetrieval{

	
	private static final boolean String = false;
	//private int deptID;
	private String deptName;
	private String DOE;
  
	
    // Composition: Department cannot exist without some attributes like deptID, deptName, and DOE

    static List<String[]> departmentsList = new ArrayList<>();

    {
		readingFiles.readDataFromFile("Department_Information.txt",departmentsList);
//		  for (String[] data : departmentsList) {// PRINTING IS JUDT FRO TESTING
//	         for (String field : data) {
//	             System.out.print(field + " | ");
//	         }
//	         System.out.println(); // Move to the next line for the next record
//	     }
	    }
   
    
	public Department() {
    }


	
	



	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDOE() {
		return DOE;
	}


	public void setDOE(String dOE) {
		DOE = dOE;
	}
	
	public void printarr() {
		
		 for (String[] field : departmentsList) {
             System.out.print(field+ "\n");
         }
         System.out.println(); 
	}
	
	

	@Override
	public void retrieveMyInfo(String id) {

		 for (String[] Onedepartment : departmentsList) {
		        String currentDeptID = Onedepartment[0]; 
		        if (currentDeptID.equals(id)) {
	             
	                // Print department data
	                for (String field : Onedepartment) {
	                    System.out.print(field+ "\n");
	                }
	                System.out.println(); // Move to the next line for the next line

	                return ;
	            }
	        }
		 
		 
	        System.out.println("Department not found!");
	        return;
		
	}
	
	
	
	
	public void retrieveStdEmpInfo(String id) {
//I AM SENDING DEPT ID 
		System.out.println("Students related : ");
		StudentCounseling obj = new StudentCounseling();
		obj.retrieveStdInfoByDeptid(id);
		 
		
		System.out.println("\n\n employee related : ");
		Employee obj1 = new Employee();
		System.out.println(obj1.retrieveInfoByDept(id));
	}
	
	
	
}
