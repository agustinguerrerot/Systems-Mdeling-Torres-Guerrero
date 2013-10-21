/*This code was initially developed by NAGESH CHAUHAN, code was taken from these sources:  
http://www.beingjavaguys.com/2013/09/read-and-parse-csv-file-in-java.html
*/

package pertchart;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadCSV {
		 public void loadCSV() {
		  String csvFileToRead = "/Users/agustinguerrero/Desktop/PERTchart.pert";
		  BufferedReader br = null;
		  String line = "";
		  String splitBy = ",";

		  try {

		   br = new BufferedReader(new FileReader(csvFileToRead));
		   while ((line = br.readLine()) != null) {

			   String[] tasks = line.split(splitBy);
			   for(int i=2; i<tasks.length; i++){
				   System.out.println("Task name: " + tasks[0] + ", Task duration: "
						   + tasks[1] + ", Preceeding Task: " + tasks[i]);
				   }
			   
		   	   }
		  } 
		  
		  catch (FileNotFoundException e) {
			  e.printStackTrace();
		  } 
		  catch (IOException e) {
			  e.printStackTrace();
		  } 
		  finally {
			  if (br != null) {
				  try {
					  br.close();
				  }
				  catch (IOException e) {
					  e.printStackTrace();
				  }
			  }
		  }

		  System.out.println("Tasks loading complete");
	}
}
