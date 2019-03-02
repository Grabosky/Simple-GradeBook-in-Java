/* Mark.java
 * GradeBook v.1.0 by Adam Grabowski
 * 25 January 2009
 * Purpose: Contain name, total score and student score of assignment.
 * Requires: none
 */

class Mark
{ 
  private String name;
  private int    totalPoints;
  private int    points;
  private double percentage =0;
  
  
  public Mark ( String theName )
  {
    this.name           = theName;
  }
  
  
  public Mark ( String theName, int topo, int po )
  {
    this.name           = theName;
    this.totalPoints = topo;
    this.points    = po;
    this.percentage =  Math.round((((double)points/(double)totalPoints)*100)*Math.pow(10, 2))/Math.pow(10, 2); //Rounding percentage to two decimal places
    
  }
  
  
  //Get Assignment    
  public String getAssignmentName()
  {
    return this.name;
  }
  
  
  //Get Percentage
  public double getPercentage()
  {
    return this.percentage;
  }
  
  //Get Assignment Total Score
  public int getAssignmentTotal()
  {      
    return  totalPoints;
  }
  
  //Get Assignment Student Score
  public int getAssignmentScore()
  {      
    return  points;
  }
  
  // Get Assignment Output in String
  public String getAssignment()
  {
    String show = " " + name + "\t" + this.points + "/" + this.totalPoints + "\t\t" + this.percentage + "%";
    return show;
  }
}//end class Mark