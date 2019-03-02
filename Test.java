/* Test.java
 * GradeBook v.1.0 by Adam Grabowski
 * 25 January 2009
 * Purpose: Main program. I/O commands.
 * Requires: Course.java, IndividualCourse.java, Mark.java, Student.java
 */

import java.io.*;
import java.util.ArrayList;

class Test
{
  
    static int choose, delCourse, editCourse, selectCourse, selectStudentOption, delStudent, editStudent, selectStudent, selectAssignmentOption, newAssignmentTotal, newAssignmentScore, delAssignment, editAssignment, editAssignmentTotal, editAssignmentScore;
    static String courseName, newCourse, editCourseName, newStudent, editStudentName, newAssignment, editAssignmentName;
    static  Course course = new Course();


public static void main(String[] args) throws IOException {
  

System.out.println("     List of Your Courses:\n");

 //Reads file and assign each course to each object in array.
 BufferedReader coursesFile = new BufferedReader(new FileReader ("ListOfCourses.dat"));  
   while(true)
   {
     courseName = coursesFile.readLine();
     if(courseName==null){break;}
    IndividualCourse k = new IndividualCourse(courseName);
    course.add(k);
    }    
    coursesFile.close(); //Close File


    course.show(); //Prints out all courses
  
     
     System.out.println("");
     
    System.out.println("SELECT OPTION:");   
    
    System.out.println("(1) select course");
    System.out.println("(2) add new course");
    System.out.println("(3) delete course");
    System.out.println("(4) edit course name");
    System.out.println("(5) Quit\n");
    
    //Check input if appriopriate 
      do
    {
    choose = Input.readInt();
     if(choose>5||choose<1)
    {
      Output.println("Your choose is not appropriate. Enter again.");
    }
    }while(choose>5||choose<1);
      
    
//COURSE MENU
/*Select course*/ if(choose==1) {
  
                                 Output.println("Enter number of course that you want to select:");
                                 //Check if appriopriate
                                    do
                                    {
                                  selectCourse = Input.readInt();
                                   if(selectCourse>course.getSize()-1||selectCourse<1)
                                   {
                                     Output.println("Your choose is not appropriate. Enter again.");
                                   }
                                    }while(selectCourse>course.getSize()-1||selectCourse<1);
                                    
                                 IndividualCourse work;
                                 work = course.getCourseObject(selectCourse);
                                 Output.println("");
                                 Output.println("COURSE MENU (" + work.getCourseName() + "):");
                                 Output.println("List of students:");
                                 Output.println("");
                                 work.showStudents();
                                 
                                      System.out.println("");
                                      System.out.println("");
     
                                 System.out.println("Select option:");   
    
                                 System.out.println("(1) select student");
                                 System.out.println("(2) add student");
                                 System.out.println("(3) delete student");
                                 System.out.println("(4) edit student name");
                                 System.out.println("(5) Quit\n");
                                 //Check if appriopriate
                                 do{
                                 selectStudentOption = Input.readInt();
                                  if(selectStudentOption>5||selectStudentOption<1)
                                   {
                                     Output.println("Your choose is not appropriate. Enter again.");
                                   }
                                   }while(selectStudentOption>5||selectStudentOption<1);
                                 
                                   //STUDENT MENU
                                              
                                        /*Select Student*/   if(selectStudentOption==1){
                                                                       
                                                             System.out.println("Enter student number you want to select:");  
                                                             //Check if appriopriate
                                                             do
                                                             {
                                                             selectStudent = Input.readInt();
                                                                if(selectStudent>work.getSize()-1||selectStudent<1)
                                                                {
                                                                  Output.println("Your choose is not appropriate. Enter again.");
                                                                }
                                                             }while(selectStudent>work.getSize()-1||selectStudent<1);
                                   
                                                             Student stud;
                                                             stud = work.getStudentObject(selectStudent);
                                                               
                                                             Output.println("");
                                                             Output.println("STUDENT MENU [" + stud.getStudentName() + "]:");
                                                             Output.println("List of assignments:");
                                                             Output.println("");
                                                             
                                                             Output.println("Assignment name:" + "\t" + "Points/Total" + "\t" + "Percentage");
                                                             stud.showAssignments();
                                   
                                                               System.out.println("");
                                                             Output.println("Overall average: " + stud.showOverall() + "%");
                                                                
                                                               System.out.println("");
                                                               System.out.println("");
     
                                                               System.out.println("Select option:");   
    
                                                               System.out.println("(1) add new mark");
                                                               System.out.println("(2) delete mark");
                                                               System.out.println("(3) edit assignment");
                                                               System.out.println("(4) Quit\n");
                                                          
                                     //ASSIGNMENT MENU                                                                   
                                                               //Check if appriopriate
                                                               do
                                                               {
                                                               selectAssignmentOption = Input.readInt();
                                                                if(selectAssignmentOption>4||selectAssignmentOption<1)
                                                                {
                                                                  Output.println("Your choose is not appropriate. Enter again.");
                                                                }
                                                               }while(selectAssignmentOption>4||selectAssignmentOption<1);
                                                               
                                              /*Add new mark*/ if(selectAssignmentOption==1)
                                                               {
                                                                Output.println("Enter new assignment name:");
                                                                newAssignment = Input.readString();
                                                                newAssignment = newAssignment.trim(); 
                                                                Output.println("Enter new assignment total score:");
                                                                 //Check if appriopriate
                                                                do
                                                                {
                                                                newAssignmentTotal = Input.readInt();      
                                                                 if(newAssignmentTotal<1)
                                                                {
                                                                  Output.println("Your total mark is too small. Must be higher than zero. Enter again.");
                                                                }
                                                               }while(newAssignmentTotal<1);
                                                               
                                                                Output.println("Enter new assignment student score:");
                                                                 //Check if appriopriate
                                                                do
                                                                {
                                                                newAssignmentScore = Input.readInt();
                                                                 if(newAssignmentScore<0 || newAssignmentScore>newAssignmentTotal)
                                                                {
                                                                  Output.println("Student mark is not appriopriate. Enter again.");
                                                                }
                                                               }while(newAssignmentScore<0 || newAssignmentScore>newAssignmentTotal);
                                                               
                                                                Mark k = new Mark(newAssignment, newAssignmentTotal, newAssignmentScore);
                                                                stud.createAssignment(k);
                                                                stud.showAssignments();
                                                                 Output.println(" ");
                                                                Output.println("Overall average: " + stud.showOverall() + "%");
                                                                
                                                               }
                                               /*Delete mark*/ else if (selectAssignmentOption==2)
                                                               {
                                                  
                                                                Output.println("Enter assignment number you want to delete:");
                                                                //Check if appriopriate
                                                                do
                                                                {
                                                                delAssignment = Input.readInt();
                                                                  if(delAssignment>stud.getSize()-1||delAssignment<1)
                                                                {
                                                                  Output.println("Your choose is not appropriate. Enter again.");
                                                                }
                                                             }while(delAssignment>stud.getSize()-1||delAssignment<1);
                                   
                                                                stud.deleteAssignment(delAssignment);
                                                                stud.showAssignments();
                                                                 Output.println(" ");
                                                                Output.println("Overall average: " + stud.showOverall() + "%");
                                                               
                                                               }
                                           /*Edit Assignment*/ else if (selectAssignmentOption==3)
                                                               {
                                                                 Output.println("Enter assignment number you want to edit:");
                                                                 //Check if appriopriate
                                                                 do
                                                                 {
                                                                 editAssignment = Input.readInt();
                                                                 if(editAssignment>stud.getSize()-1||editAssignment<1)
                                                                {
                                                                  Output.println("Your choose is not appropriate. Enter again.");
                                                                }
                                                                }while(editAssignment>stud.getSize()-1||editAssignment<1);
                                                             
                                                                 Output.println("Enter assignment name:");
                                                                 editAssignmentName = Input.readString();
                                                                 editAssignmentName = editAssignmentName.trim(); 
                                                                 Output.println("Enter assignment total scores:");
                                                                 //Chceck if appriopriate
                                                                 do
                                                                 {
                                                                 editAssignmentTotal = Input.readInt();
                                                                 if(editAssignmentTotal<1)
                                                                {
                                                                  Output.println("Your total mark is too small. Must be higher than zero. Enter again.");
                                                                }
                                                                }while(editAssignmentTotal<1);
                                                                
                                                                 Output.println("Enter assignment student scores:");
                                                                 //Check if appriopriate
                                                                 do
                                                                 {
                                                                 editAssignmentScore = Input.readInt();
                                                                 if(editAssignmentScore<0 || editAssignmentScore>editAssignmentTotal)
                                                                {
                                                                  Output.println("Student mark is not appriopriate. Enter again.");
                                                                }
                                                               }while(editAssignmentScore<0 || editAssignmentScore>editAssignmentTotal);
                                                                 
                                                                 Mark t = new Mark(editAssignmentName, editAssignmentTotal, editAssignmentScore);
                                                                 stud.editAssignment(editAssignment, t);
                                                                 stud.showAssignments();
                                                               Output.println(" ");
                                                                Output.println("Overall average: " + stud.showOverall() + "%");
                                             
                                             
                                                               }
                                                     /*Quit*/  else if (selectAssignmentOption==4)
                                                               {
                                                                 Output.println("Thank you for using GradeBook v1.0 by Adam Grabowski.");
                                                                 Output.println("Have a nice day!");
                                                                 System.exit(0);
                                                               }
                                                     //END ASSIGNMENT MENU
                                                             
                                   
                                   
               /*Add Student*/    } else if (selectStudentOption==2) {
                                   
                                   Output.println("Enter new student name:");
                                   newStudent = Input.readString();
                                   newStudent = newStudent.trim(); 
                                                                      
                                    Student k = new Student(newStudent);
                                    work.createStudent(k);
                                    work.showStudents();
                                    
           /*Delete Student*/      } else if (selectStudentOption==3) {
                                    
                                   Output.println("Enter student number you want to delete:");
                                 //Check if appriopriate
                                   do
                                   {
                                   delStudent = Input.readInt();
                                     if(delStudent>work.getSize()-1||delStudent<1)
                                   {
                                   Output.println("Your choose is not appropriate. Enter again.");
                                   }
                                   }while(delStudent>work.getSize()-1||delStudent<1);
                                   
                                   work.deleteStudent(delStudent);
                                   work.showStudents();
                                    
       /*Edit Student Name*/     } else if (selectStudentOption==4) {
                                   
                                    Output.println("Enter number of student that you want to change his name:");
                                    //Check if appriopriate
                                    do
                                    {
                                    editStudent = Input.readInt(); 
                                   if(editStudent>work.getSize()-1||editStudent<1)
                                    {
                                       Output.println("Your choose is not appropriate. Enter again.");
                                    }
                                   }while(editStudent>work.getSize()-1||editStudent<1);
                                    
                                    Output.println("Enter new name of the student:");
                                    editStudentName = Input.readString();
                                    editStudentName = editStudentName.trim();                                     
                                    work.editStudentName(editStudent, editStudentName);
         
                                    
        /*Quit*/                 } else if (selectStudentOption==5) {
                                   
                                 Output.println("Thank you for using GradeBook v1.0 by Adam Grabowski.");
                                 Output.println("Have a nice day!");
                                 System.exit(0);
                                 }
              //END STUDENT MENU
                                  
    
/*Add new course*/ } else if(choose==2) {
  
  Output.println("Enter new course name");
  newCourse = Input.readString();
  newCourse = newCourse.trim();
  newCourse = newCourse.toUpperCase();
  IndividualCourse k = new IndividualCourse(newCourse);
  course.createCourse(k);
   
/*Delete course*/ } else if(choose==3) {
  
   Output.println("Enter number of course that you want to delete:");
   //Check if appriopriate
   do
   {
  delCourse = Input.readInt();
  if(delCourse>course.getSize()-1||delCourse<1)
  {
      Output.println("Your choose is not appropriate. Enter again.");
  }
  }while(delCourse>course.getSize()-1||delCourse<1);
  
  
  course.deleteCourse(delCourse);
  
   
/*Edit course*/ } else if(choose==4) {

    Output.println("Enter number of course that you want to edit:");
    //Check if appriopriate
    do
    {
  editCourse = Input.readInt(); 
   if(editCourse>course.getSize()-1||editCourse<1)
  {
      Output.println("Your choose is not appropriate. Enter again.");
  }
  }while(editCourse>course.getSize()-1||editCourse<1);
  
  
  Output.println("Enter new name of the course:");
  editCourseName = Input.readString();
  editCourseName = editCourseName.trim();
  editCourseName = editCourseName.toUpperCase();
  
  course.editCourse(editCourse, editCourseName);
  
/*Exit*/ } else if(choose==5){
  
 Output.println("Thank you for using GradeBook v1.0 by Adam Grabowski.");
 Output.println("Have a nice day!");
 System.exit(0);
}
//END COURSE MENU

 
} //end main
} //end class Test