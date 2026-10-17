package finalAdvancedProgramming;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	
	
	@Test
	void testOperationOnGivenDept() {
        Employee employee = new Employee();
        String testDept = "IDEPT5109";
        
        
        // DO the operation on the given department
        int R = employee.OperationOnGivenDept(testDept);
        
        assertEquals(42, R);

	}

}
