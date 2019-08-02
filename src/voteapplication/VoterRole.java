/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voteapplication;

/**
 *
 * @author Monica
 * @datecreated 27-Jul-2019
 */

/* Class definition to accept Voter profile details */

public class VoterRole 
{
  private int voterId; 
  private int voterAadharNo; 
  private String voterFname;
  private String voterLname;
  private String voterLocation;
  private int voterAge;
  private boolean voted;
    
  /* Method to register voter into database */
  public void voterRegistration(int id, String fname, String lname, String location, int age,int aadharNo)
    {
      voterId=id;
      voterFname=fname;
      voterLname=lname;
      voterLocation=location;
      voterAge=age;
      voterAadharNo=aadharNo;
    }
  /* Method to check whether voter exists in database or not */
  public boolean checkVotersInDatabase(int voterId)
    {
      if(this.voterId==voterId)
         return true;
         return false;
    }     
 /* Method to retrieve voter profile details
   format of retrival: ID | AADHARNO | FNAME | LNAME | LOCATION | AGE */
   public String showVoterDetails()
    {
      return voterId +"|"+ voterAadharNo+"|"+ voterFname +"|"+ voterLname +"|"+ voterLocation +"|"+ voterAge;
    }
   
   public boolean checkIfVoteIsDone()
   {
       return voted;
   }
}
