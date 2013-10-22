
/*This code was initially developed by NAGESH CHAUHAN, code was taken from these sources:  
http://www.beingjavaguys.com/2013/09/read-and-parse-csv-file-in-java.html
*/

package pertchart;

import java.util.LinkedList;
import java.util.List;

public class Tasks {

	 private String taskName;
	 private int taskDuration;
	 List<String> preceedingTasks;
	 
	 public Tasks (){
		preceedingTasks = new LinkedList<String>(); 
	 }
	 
	 public String getTaskName() {
	  return taskName;
	 }

	 public void setTaskName(String taskName) {
	  this.taskName = taskName;
	 }

	 public int getTaskDuration() {
	  return taskDuration;
	 }

	 public void setTaskDuration(int taskDuration) {
	  this.taskDuration = taskDuration;
	 }

	 public List<String> getPreceedingTasks() {
	  return preceedingTasks;
	 }
}
