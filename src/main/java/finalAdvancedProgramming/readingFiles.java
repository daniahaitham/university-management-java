package finalAdvancedProgramming;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readingFiles {

	
   static private String fileName;

    static public void readDataFromFile(String fileName, List<String[]> anyDataList) {
    	
        File myFile = new File(System.getProperty("data.dir", "data"), fileName); // data files live in the data/ folder
        try {
			Scanner myReader = new Scanner(myFile);
			
			myReader.nextLine();
			
			  while (myReader.hasNextLine()) {// until no more lines to read 
	                String line = myReader.nextLine(); // THIS MAY BE SHANGED 
	                String[] fields = line.split("\\|");
	                anyDataList.add(fields);
	            }
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Data file not found: " + myFile.getPath() + " (see README: Data)");
		}

    }
   
    
}
