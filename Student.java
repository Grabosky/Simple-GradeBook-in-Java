/* Student.java
 * GradeBook v.1.0 by Adam Grabowski
 * 25 January 2009
 * Purpose: Contains student name and his assignments (Mark class objects)
 * Requires: Mark.java
 */


import java.io.*;
import java.util.List;
import java.util.ArrayList;

class Student
{ 
  private String name, var1, courseN;
  private int var2, var3;
  private double overall;
  private List <Mark> assignments;
  
  
  public Student ( String theName )
  {
    this.name           = theName;
    assignments = new ArrayList <Mark>(); 
  }
  
  
  //CREATING ASSIGNMENTS ARRAY
  public void createAssignmentsList(String coN) throws IOException  {
    //Reads file and assign each mark
    BufferedReader studFile = new BufferedReader(new FileReader (coN + "/" + name + ".txt"));  
    while(true)
    {
      var1 = studFile.readLine();
      if(var1==null){break;}
      var2 = Integer.parseInt(studFile.readLine());
      var3 = Integer.parseInt(studFile.readLine());
      Mark m = new Mark(var1, var2, var3);
      assignments.add(m);
    }    
    courseN = coN;
    studFile.close(); //Close File
  }
  
  
  //GET STUDENT NAME
  public String getStudentName()
  {
    return this.name;
  }
  
  //SET STUDENT NAME
  public void setStudentName( String newName )
  {
    this.name = newName;
  }
  
///////////////////////////// Student Marks //////////////////////////////////
  
  
//SHOW Assignments LIST
  public void showAssignments(){
    for(int i=1; i < assignments.size();i++){
      Output.println("[" + i + "]" + assignments.get(i).getAssignment());
    }
  }
  
  
//SHOW SUMMARIZED MARKS
  public double showOverall(){
    overall=0;
    for(int i=1; i < assignments.size();i++){
      overall = overall +  assignments.get(i).getPercentage();
    }
    overall = overall/(assignments.size()-1);
    overall = Math.round(overall);//Rounding percentage to two decimal places
    return overall;
  }
  
  
  
  //CREATE NEW ASSIGNMENT
  public void createAssignment(Mark k)  throws IOException
  { 
    //Add assignment to student file 
    PrintWriter studeFile = new PrintWriter(new FileWriter (courseN + "/" + name + ".txt",true));
    studeFile.println(k.getAssignmentName());
    studeFile.println(k.getAssignmentTotal());
    studeFile.println(k.getAssignmentScore());
    studeFile.close(); 
    
    assignments.add(k);//add assignment at the end of the list
  } // END NEW ASSIGNMENT   
  
  
  
  
//DELETE ASSIGNMENT
  public void deleteAssignment(int index) throws IOException 
  {       
    assignments.remove(index); //removes student object form the list
    
    //Put new array to the file
    PrintWriter delAssignmentFile = new PrintWriter(new FileWriter (courseN + "/" + name + ".txt"));
    
    for(int j = 0; j < assignments.size(); j++)
    {
      delAssignmentFile.println(assignments.get(j).getAssignmentName());
      delAssignmentFile.println(assignments.get(j).getAssignmentTotal());
      delAssignmentFile.println(assignments.get(j).getAssignmentScore());
    }  
    delAssignmentFile.close();      
  }// END OF DELETE ASSIGNMENT
  
  
  
  
//EDIT ASSIGNMENT
  public void editAssignment(int index, Mark o) throws IOException 
  {       
    assignments.set(index, o); //removes student object form the list
    
    //Put new array to the file
    PrintWriter editAssignmentFile = new PrintWriter(new FileWriter (courseN + "/" + name + ".txt"));
    
    for(int j = 0; j < assignments.size(); j++)
    {
      editAssignmentFile.println(assignments.get(j).getAssignmentName());
      editAssignmentFile.println(assignments.get(j).getAssignmentTotal());
      editAssignmentFile.println(assignments.get(j).getAssignmentScore());
    }  
    editAssignmentFile.close();      
  }// END OF EDIT ASSIGNMENT
  
  
  
  
//GET ASSIGNMENT LIST SIZE
  public int getSize(){
    return assignments.size();
  }   
 
  
  
}//END CLASS Student
