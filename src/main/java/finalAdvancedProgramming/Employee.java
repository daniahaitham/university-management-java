package finalAdvancedProgramming;
import java.util.ArrayList;
import java.util.List;
public class Employee extends EmpDept implements infoRetrieval , StatisticalOperation , InfoProviderByDeptName{ 

	
	private int EmpID; 
	//private String deptID; 
	private String DOB;
	private int DOJ;
	
	
	 public Employee() {
	     
	    }


	public int getEmpID() {
		return EmpID;
	}


	public void setEmpID(int empID) {
		EmpID = empID;
	}




	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public int getDOJ() {
		return DOJ;
	}


	public void setDOJ(int dOJ) {
		DOJ = dOJ;
	}
	 
    // Aggregation: Employee uses Department but doesn't own it

     static List<String[]> employeesList = new ArrayList<>();{
		readingFiles.readDataFromFile("Employee_Information.txt",employeesList);

		  }

	

	@Override
	public void retrieveMyInfo(String id) {
	// retrive employee info based on given id.

		  for (String[] oneEmployee : employeesList) {
  	        String currentEmpID = oneEmployee[0]; 
  	        if (currentEmpID.equals(id)) {
  	            for (String field : oneEmployee) {
  	                System.out.print(field + "\n");
  	            }
  	            System.out.println(); // Move to the next line for the next line
  	            return ;
  	        }
  	    }

  	    System.out.println("Employee not found!");
  	    return ;
	}


	@Override
	public int OperationOnGivenDept(String dept) {
		// this is num Of Emp In Dept

		 int count = 0;
         for (String[] department : employeesList) {
             if (department[3].equals(dept)) { // Assuming department name is at index 1
                 count++;
             }
         }
         return count;
		
	}


	@Override
	public String[] retrieveInfoByDept(String deptName) {
		for (String[] empInfo : employeesList) {
 			if (empInfo[3].equals(deptName)) {
 				System.out.println("Employee ID:"+empInfo[0]+  ", DOB: " +empInfo[1] + ", DOJ: " + empInfo[2]  + " , dept :" + empInfo[3]);
 			}
 		}

 		return null ;
	}
     
	@Override
	   public String toString() {
	        return "Employee ID: " + EmpID + ", DOB: " + DOB + ", DOJ: " + DOJ ;
	    }
     
     
	public void printarr() {
		
		 for (String[] field : employeesList) {
            System.out.print(field+ "\n");
        }
        System.out.println(); 
	}


     
     
     
     
     
     
     
}
