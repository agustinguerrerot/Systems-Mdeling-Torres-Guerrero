/*This code was initially developed by Mkyong and NAGESH CHAUHAN, code was taken from these sources:  
http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
http://www.beingjavaguys.com/2013/09/read-and-parse-csv-file-in-java.html
*/

package pertchart;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVtoClass {

	public List<Tasks> convertCsvToClass(String path) {
		  File infile = new File(path);
		  File outfile = new File(infile.getParent(), "TorresAndGuerrero.dot");
		  String csvToRead = infile.getAbsolutePath();
		  BufferedReader br = null;
		  String line = "";
		  String splitBy = ",";
		  List<Tasks> taskList = new ArrayList<Tasks>();

		  try {

			  br = new BufferedReader(new FileReader(csvToRead));
			  while ((line = br.readLine()) != null) {

				  // split on comma(',')
				  String[] tasks = line.split(splitBy);
				 
				  // create car object to store values
				  Tasks taskObject = new Tasks();
				  taskObject.setTaskName(tasks[0]);
				  taskObject.setTaskDuration(Integer.parseInt(tasks[1]));
				  
				  for(int i=2; i<tasks.length; i++){ 
					  taskObject.getPreceedingTasks().add(tasks[i]);
				  }

				  // adding car objects to a list
				  taskList.add(taskObject);
			  	  }
				  
			  // print values stored in carList
			  printTaskList(taskList);
			  createDotFile(taskList, outfile);
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
		 return taskList;
	}

	public void printTaskList(List<Tasks> taskListToPrint) {
		for (int i = 0; i < taskListToPrint.size(); i++) {
		   System.out.println(taskListToPrint.get(i).getPreceedingTasks() +"->" + taskListToPrint.get(i).getTaskName()+";");
		   }
	}
	
	public static void createDotFile(List<Tasks> taskListToPrint,File inputFile) {
		System.out.println(inputFile.getAbsolutePath());
		int noPreceedingTaskCounter = 0; 
		try {

			File file = new File(inputFile.getAbsolutePath());
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("digraph G {\n");
			for (int i = 0; i < taskListToPrint.size(); i++) {
				if (taskListToPrint.get(i).getPreceedingTasks().isEmpty()){
					noPreceedingTaskCounter ++;
					if (noPreceedingTaskCounter>1){
							throw new IllegalArgumentException("Wrong .pert file format!");
						}
					}
					for (int j = 0; j < taskListToPrint.get(i).getPreceedingTasks().size(); j++){
							bw.write(
								taskListToPrint.get(i).getPreceedingTasks().get(j)+"[shape=box];\n"+
								taskListToPrint.get(i).getPreceedingTasks().get(j)+
								"->" + taskListToPrint.get(i).getTaskName()+";\n"+
								taskListToPrint.get(i).getTaskName() + "[label=\"" + taskListToPrint.get(i).getTaskName() + " (" + taskListToPrint.get(i).getTaskDuration() +" days)\"];\n"
						);
				    }
			}
			//bw.write(taskListToPrint.get(taskListToPrint.size()-1).getTaskName()+"[shape=box];\n");
			//bw.write(taskListToPrint.get(taskListToPrint.size()-1).getTaskName()+"[label=\""+taskListToPrint.get(taskListToPrint.size()-1).getTaskName()+"\"];\n");
			bw.write("}");
			bw.close();
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}	

//
