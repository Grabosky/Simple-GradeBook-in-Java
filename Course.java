/* Course.java
 * GradeBook v.1.0 by Adam Grabowski
 * 25 January 2009
 * Purpose: Contain list of courses (IndividualCourse class objects)
 * Requires: IndividualCourse.java
 */

import java.io.*;
import java.util.List;
import java.util.ArrayList;

class Course
{  
  private List <IndividualCourse> list;
  private String name, out;
  
  public Course() 
  {
    list = new ArrayList <IndividualCourse>();
  }
  
  
  //ADD COURSE AT THE END OF THE LIST
  public void add(IndividualCourse k){
    
    list.add(k);//add course at the end of the list
  }
  
  
  
  //CREATE NEW COURSE AT THE END OF THE LIST
  public void createCourse(IndividualCourse k)  throws IOException
  { 
    PrintWriter newCourseFile = new PrintWriter(new FileWriter ("ListOfCourses.dat",true));
    
    newCourseFile.println(k.getCourseName());
    newCourseFile.close(); 
    //Creates folder with name of the course
    
    File temp = new File(k.getCourseName()); // Folder path
    if(!temp.exists()) {
      temp.mkdirs();
    } 
    //Create students file in course folder
    File f;
    f=new File(k.getCourseName() + "/students.txt");
    if(!f.exists()){
      f.createNewFile();
      
    }  //Add first entry
    PrintWriter courseFile = new PrintWriter(new FileWriter (k.getCourseName() + "/students.txt",true));
    courseFile.println("null");
    courseFile.close(); 
    
    list.add(k);//add course at the end of the list
  }
  
  
  
  
  
//DELETE COURSE
  public void deleteCourse(int index) throws IOException 
  {   
    //Delete folder
    File dir = new File(list.get(index).getCourseName()); // Folder path
    deleteFolder(dir); //Delete folder of the course
    
    list.remove(index); //removes course object form the list
    
    //Put new array to the file
    PrintWriter delCourseFile = new PrintWriter(new FileWriter ("ListOfCourses.dat"));
    
    for(int j = 0; j < list.size(); j++)
    {
      delCourseFile.println(list.get(j).getCourseName());
    }  
    delCourseFile.close();      
  }
  //START OF DELETE COURSE FOLDER
  public static boolean deleteFolder(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i=0; i<children.length; i++) {
        boolean success = deleteFolder(new File(dir, children[i]));
      }
    }
    return dir.delete();
  }
//end of DELETE COURSE
  
  
  
  
  
  //START OF EDIT COURSE
  public void editCourse(int nm, String cr) throws IOException  
  { 
    // Rename folder name
    File file = new File(list.get(nm).getCourseName());
    File file2 = new File(cr);  
    boolean success = file.renameTo(file2);
    if (!success) {
      
    }
    
    PrintWriter newCourseFile = new PrintWriter(new FileWriter ("ListOfCourses.dat"));
    
    for(int j = 0; j < list.size(); j++)
    {
      newCourseFile.println("");
    }    
    newCourseFile.close(); 
    
    list.get(nm).setCourseName(cr); //Edit element of array
    
    PrintWriter newCoursesFile = new PrintWriter(new FileWriter ("ListOfCourses.dat"));
    
    for(int j = 0; j < list.size(); j++)
    {
      newCoursesFile.println(list.get(j).getCourseName());
    }  
    newCoursesFile.close();      
    
  } //ENDOF  EDIT COURSE
  
  
  
  
  
  
//GETS SELECTED OBJECT FROM THE LIST
  public IndividualCourse getCourseObject(int no) throws IOException {
    list.get(no).createStudentList();
    return list.get(no);     
  }
  
  
  
  
  
//SHOWS COURSES LIST
  public void show(){
    for(int i=1; i<list.size();i++){
      Output.println("[" + i + "]" + list.get(i).getCourseName());
    }
  }
  
  
  
// GET COURSE LIST SIZE
  public int getSize()
  {
    return list.size();
  }
  
  
}//end class Course