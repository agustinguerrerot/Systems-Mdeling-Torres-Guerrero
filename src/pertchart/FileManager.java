/*This code was initially developed by NAGESH CHAUHAN, code was taken from these sources:  
http://www.beingjavaguys.com/2013/09/read-and-parse-csv-file-in-java.html
*/
package pertchart;

import java.util.List;

public class FileManager {
	 public static void main(String[] args) {

		  // reading data from a csv file
		  System.out.println("Reading data from csv :");
		  LoadCSV instanceTask = new LoadCSV();
		  instanceTask.loadCSV();

		  // reading data from a csv file and convert to java object
		  System.out.println("Reading data from csv and convert to java object:");
		  CSVtoClass csvtoClass = new CSVtoClass();
		  List<Tasks> allTasks = csvtoClass.convertCsvToClass(args[0]);

	        //Task[] result = criticalPath(allTasks);
	        //print(result);
		  
	 }
}