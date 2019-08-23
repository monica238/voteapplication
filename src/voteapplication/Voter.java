package voteapplication;

/**
 *
 * @author Monica
 * @datecreated 27-Jul-2019
 */

/* Class definition to accept Voter profile details */

public class Voter 
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
        VoterDbo vdo=new VoterDbo();
        vdo.connectToDB();        
        if(vdo.getVoterObjectById(voterId)!=null)
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
   
   public void setVoterId(int voterId)
   {
       this.voterId=voterId;
   }
   
   public int getVoterId()
   {
       return voterId;
   }
   public void setVoterFname(String voterFname)
   {
       this.voterFname=voterFname;
   }
   
   public String getVoterFname()
   {
       return voterFname;
   }
   public void setVoterLname(String voterLname)
   {
       this.voterLname=voterLname;
   }
   
   public String getVoterLname()
   {
       return voterLname;
   }
   public void setVoterLocation(String voterLocation)
   {
       this.voterLocation=voterLocation;
   }
   
   public String getVoterLocation()
   {
       return voterLocation;
   }
   public void setVoterAge(int voterAge)
   {
       this.voterAge=voterAge;
   }
   
   public int getVoterAge()
   {
       return voterAge;
   }
   public void setVoterAadharNo(int voterAadharNo)
   {
       this.voterAadharNo=voterAadharNo;
   }
   
   public int getVoterAadharNo()
   {
       return voterAadharNo;
   }
   
}
