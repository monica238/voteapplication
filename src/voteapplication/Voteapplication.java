package voteapplication;
import java.io.DataInputStream;
import java.lang.Exception;
import java.util.ArrayList;

public class Voteapplication 
 {   
   public static void main(String[] args) 
   {
     AdminRole admin=new AdminRole();
     VoterRole voterInstance=new VoterRole();
     Candidate candidateInstance=new Candidate();
     CastVote castVoteInstance=new CastVote();
     ArrayList voterList=new ArrayList();
     ArrayList candidateList=new ArrayList();
   
     String adminUserName;
     String adminPassword;
     System.out.println("Enter Username and Password for Admin:");
      try
       {
         DataInputStream in=new DataInputStream(System.in);
         adminUserName=in.readLine();
         adminPassword=in.readLine();
        
         System.out.println(adminUserName+"-"+adminPassword);
        
        if(admin.validateAdminLogin(adminUserName, adminPassword)==true)
          {
            System.out.println("Login Success");
            voterInstance=createVoter();
            voterList.add(voterInstance);
            System.out.println(voterInstance.showVoterDetails());
            System.out.println(voterList.size());
            
            /*
            1. Voter Registration
            2. Candidate Registration
            3. Ballot creation
            4. Voting
            5. Results
            6. Exit
            */
        
          }
        else
            System.out.println("Login Failure");
    }
    catch (Exception e)
      {
        System.out.println(e);
      }                              
   }
   /* Method to create voter*/
   public static VoterRole createVoter()
    {                               
      VoterRole voterInstance=new VoterRole();
      String voterFname;
      String voterLname;
      int voterId; 
      int voterAadharNo;
      int voterAge;
      String voterLocation;
      
        DataInputStream in=new DataInputStream(System.in);
          try
            {
              System.out.println("Please provide your details");

              System.out.println("Enter your first name:");
              voterFname=in.readLine();
               
              System.out.println("Enter your last name:");
              voterLname=in.readLine();

              System.out.println("Enter your voter id:");
              voterId=Integer.parseInt(in.readLine());

              System.out.println("Enter your aadhar number:");
              voterAadharNo=Integer.parseInt(in.readLine());

              System.out.println("Enter your age:");
              voterAge=Integer.parseInt(in.readLine());

              System.out.println("Enter your location:");
              voterLocation=in.readLine();

              voterInstance.voterRegistration(voterId,voterFname , voterLname ,voterLocation, voterAge , voterAadharNo);           
            }
          catch (Exception e)
            {
              System.out.println(e);
            }
        return voterInstance;
    }
   /* Method to create candidate*/
   public static Candidate createCandidate()
    {
       Candidate candidateInstance=new Candidate();
       int candidateId;
       int age;
       int count;
       String city;
       String candidateFirstName;
       String candidateParty;
         DataInputStream in=new DataInputStream(System.in);
          try
            {
              System.out.println("Please provide your details");
           
              System.out.println("Enter your name:");
              candidateFirstName=in.readLine();
           
              System.out.println("Enter your candidate id:");
              candidateId=Integer.parseInt(in.readLine());
           
              System.out.println("Enter your party name:");
              candidateParty=in.readLine();
           
              System.out.println("Enter your age:");
              age=Integer.parseInt(in.readLine());
           
              System.out.println("Enter your city:");
              city=in.readLine();
           
             candidateInstance.candidateDetails(candidateFirstName,candidateParty,city,candidateId,age);           
           }
         catch (Exception e)
           {
             System.out.println(e);
           }
      return candidateInstance;
    }
   /* Method to create Ballot*/
  public static Ballot createBallot()
    {
          
    }
  public static Ballot checkBallotcreationInDatabase(int voterId)
    {
       if(Ballot.createBallot()==true)
         {
           return true;  
           System.out.println("Ballot creation is completed");
           DataInputStream in=new DataInputStream(System.in);
           try
             {
               System.out.println("Enter voterId");
               voterId=Integer.parseInt(in.readLine());
             }
           catch(Exception e)
             {
               System.out.println(e);
             }
          
       if(voterList.contains(voterId))
          {
           System.out.println("voter id is valid and exists in voter list");
           castVoteInstance=createCastVote();
           candiateList.add(candidateInstance);
          // System.out.println(candidateInstance.showCandidateDetails());
           //System.out.println(candidateList.size());
           Candidate candidateInstance=new Candidate();
           VoterRole voterInstance=new CastVote();
            
          }  
        }
       
        
   public boolean validatevoterid(int voterId,int id)
    {
       if(voterId==id)
           return true;
            return false;   
    }
   public Ballot displayCandidateList(int candidateId,int index)
    {
       for(index=0;index<candidateList.size();index++)
          {
            System.out.println(candidateList.get(index));
          }
           System.out.println("Select the candidate");
           DataInputStream in=new DataInputStream(System.in);
           try
             {
                System.out.println("Enter candidateId");
                candidateId=Integer.parseInt(in.readLine());
             }
           catch(Exception e)
              {
                System.out.println(e);
              }
            
    }
               
}
}

     
               
               
  
          
           
   


 
     
    

