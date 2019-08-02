package voteapplication;
import java.io.DataInputStream;
import java.lang.Exception;
import java.util.ArrayList;

public class Voteapplication 
 {   
   public static void main(String[] args) 
   {
     AdminRole admin=new AdminRole();
     
     VoterRole voterInstance1;
     VoterRole voterInstance2;
     VoterRole voterInstance3;
     
     Candidate candidateInstance1;
     Candidate candidateInstance2;     
     CastVote castVoteInstance=new CastVote();
     
     Ballot ballotForVoting;
     
     ArrayList voterList=new ArrayList();
     ArrayList candidateList=new ArrayList();
     ArrayList castVoteList=new ArrayList();
     
     boolean isBallotCreated=false;
   
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
             
             //Voter Registration
             voterInstance1=createVoter();
             voterList.add(voterInstance1);
             voterInstance2=createVoter();
             voterList.add(voterInstance2);
             voterInstance3=createVoter();
             voterList.add(voterInstance3);
             
             
             //Candidate Registration
             candidateInstance1=createCandidate();
             candidateList.add(candidateInstance1);
             candidateInstance2=createCandidate();
             candidateList.add(candidateInstance2);

             //Create ballot
             ballotForVoting=createBallot(candidateList);
             
             
            
             System.out.println(voterList.size());
             System.out.println("Please enter voter id to validate:");
             int voterId;
             int candidateId;
             voterId=Integer.parseInt(in.readLine());
             if (validateVoterid(voterList,voterId))
             {
                 System.out.println("Voter exists");
                 
                //Show Ballot for Voting
                ArrayList<Candidate> candidateListInBallot=ballotForVoting.getCandidates();
                for(int i=0;i<candidateListInBallot.size();i++)
                     System.out.println(candidateListInBallot.get(i).showCandidateDetails());
                
                //Accept the Candidate ID
                System.out.println("Enter the candidate id");
                candidateId=Integer.parseInt(in.readLine());
                // Validate the Candiate ID
                if (validateCandidateid(candidateList,candidateId))
                  {
                    System.out.println("Candidate id exists");
                  
                // If Candidate exists, get CandidateOBject from ballotForVoting
                   ballotForVoting=candidateInstance1.get
                  
                  }
                else
                {
                    System.out.println("candidate id does not exists");
                }    
             
             }  
             else
             {
                    System.out.println("Voter Does not exists");
             }
            
                    
         
             
//             candidateInstance=createCandidate();
//             candidateList.add(candidateInstance);
//             System.out.println(candidateInstance.showCandidateDetails());
//             System.out.println(candidateList.size());
            
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
           
              System.out.println("Enter candidate name:");
              candidateFirstName=in.readLine();
           
              System.out.println("Enter candidate id:");
              candidateId=Integer.parseInt(in.readLine());
           
              System.out.println("Enter party name:");
              candidateParty=in.readLine();
           
              System.out.println("Enter the age:");
              age=Integer.parseInt(in.readLine());
           
              System.out.println("Enter the city:");
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
  public static Ballot createBallot(ArrayList<Candidate> candidateList)
    {
      //Ballot BallotInstance=new Ballot();    
        Ballot ballot=new Ballot();
        ballot.createBallot(candidateList);
        return ballot;
    }
  public static void checkBallotcreationInDatabase(int voterId)
    {
      
    }
       
        
   public static boolean validateVoterid(ArrayList<VoterRole> voterList,int voterId)
    {
        for(int i=0;i<voterList.size();i++)
            if(voterList.get(i).checkVotersInDatabase(voterId))
                return true;
        return false;   
    }
                  
}


     
               
               
  
          
           
   


 
     
    

