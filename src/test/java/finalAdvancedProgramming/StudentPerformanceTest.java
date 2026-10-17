package finalAdvancedProgramming;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentPerformanceTest {

	@Test
	void testNumOfSemestersForStd() {
		
		StudentPerformance StudentPerfermance = new StudentPerformance();
	        String testDept = "SID20131143";
	        
	        
	        // DO the operation on the given department
	        int R = StudentPerfermance.NumOfSemestersForStd(testDept);
	        
	        assertEquals(8, R);

	}

	@Test
	void testNumOfPapersForStd() {
		StudentPerformance StudentPerfermance = new StudentPerformance();
        String testDept = "SID20131143";
        
        
        // DO the operation on the given department
        int R = StudentPerfermance.NumOfPapersForStd(testDept);
        
        assertEquals(55, R);	}


}
