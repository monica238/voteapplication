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
             
             /* Voter Registration */
             voterInstance1=createVoter();
             voterList.add(voterInstance1);
             voterInstance2=createVoter();
             voterList.add(voterInstance2);
             voterInstance3=createVoter();
             voterList.add(voterInstance3);
             
             
             /* Candidate Registration */
             candidateInstance1=createCandidate();
             candidateList.add(candidateInstance1);
             candidateInstance2=createCandidate();
             candidateList.add(candidateInstance2);

             /* Create ballot */
             ballotForVoting=createBallot(candidateList);
             
             
             /* To evaluate whether the voter id is valid or not */
             int voterId;
             int candidateId;
             System.out.println(voterList.size());
             System.out.println("Please enter voter id to validate:");
             voterId=Integer.parseInt(in.readLine());
             
             
             if (validateVoterid(voterList,voterId))
             {
                 System.out.println("Voter exists");
                 
                /* Show Ballot for Voting */
                ArrayList<Candidate> candidateListInBallot=ballotForVoting.getCandidates();
                for(int i=0;i<candidateListInBallot.size();i++)
                     System.out.println(candidateListInBallot.get(i).showCandidateDetails());
                
                /* Accept the Candidate ID */
                System.out.println("Enter the candidate id");
                candidateId=Integer.parseInt(in.readLine());
                
                /* Validate the Candiate ID */
                if (validateCandidateId(candidateList,candidateId))
                  {
                    System.out.println("Candidate id exists");
                    
                /* If Candidate exists, get CandidateOBject from ballotForVoting */
                    candidateInstance1=ballotForVoting.getCandidate(candidateId);
                    
                    /* Get Voter  Instance from the registration database */
                    voterInstance1=getVoterInstanceById(voterList,voterId);
                    
                   
                    /* If voting is done add the cast vote to the cast vote list */
                    castVoteInstance=new CastVote();
                    
                    castVoteInstance.setCandidateInstance(candidateInstance1);
                    castVoteInstance.setVoterInstance(voterInstance1);
                                        
                    castVoteList.add(castVoteInstance);
                    System.out.println("Voting process is completed..Thank You");
                  }
                
                /* If the candidate id selected by voter is not correct */
                else
                 {
                    System.out.println("candidate id does not exists");
                 }    
             
             } 
             
            /* If the given voter id does not exists in the database */
            else
             {
               System.out.println("Voter Does not exists");
             }
            
                   
         
             
            /*
            1. Voter Registration
            2. Candidate Registration
            3. Ballot creation
            4. Voting
            5. Results
            6. Exit
            */
        
           }
          
          /* If the given user name and password is incorrect */
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
      VoterRole voterInstance=new VoterRole();     /* Object created for voter role class */
      String voterFname;
      String voterLname;
      int voterId; 
      int voterAadharNo;
      int voterAge;
      String voterLocation;
       
        /* Data input from the user */
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
   
   /* Method to create candidate */
   public static Candidate createCandidate()
    {
       Candidate candidateInstance=new Candidate();      /* Object created for candidate class */
       int candidateId;
       int age;
       int count;                                        /* variable for holding the total count of candidates */
       String city;
       String candidateFirstName;
       String candidateParty;
       
       /* Data input from the admin */
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
      return candidateInstance;                           /* Object to be returned,which holds the candidate details */       
    }

   /* Method to create Ballot */
  public static Ballot createBallot(ArrayList<Candidate> candidateList)
    {
        Ballot ballot=new Ballot();                /* New object created for Ballot class */
        ballot.createBallot(candidateList);        /* Method class which holds the list of candidates */
        return ballot;                             /* Object to be returned */
    }
  /* Method to check ballot creation in database */
  public static void checkBallotcreationInDatabase(int voterId)
    {
      
    }
       
   /* Method to validate whether voter id exists in the voter list or not */     
   public static boolean validateVoterid(ArrayList<VoterRole> voterList,int voterId)
    {
        for(int i=0;i<voterList.size();i++)
            if(voterList.get(i).checkVotersInDatabase(voterId))      /* check for the voter id in the database */
                return true;                                         /* if voter id exists in database */
        return false;                                                /* if voter id does not exists in database */
    }
   
   /* Method to validate whether candidate id exists in the candidate list or not */
      public static boolean validateCandidateId(ArrayList<Candidate> candidateList,int candidateId)
    {
        for(int i=0;i<candidateList.size();i++)
            if(candidateList.get(i).checkCandidateInDatabase(candidateId))
                return true;
        return false;   
    }
   /* Method to get the voter instance by voter id */
      public static VoterRole getVoterInstanceById(ArrayList<VoterRole> voterList,int voterId)
      {
        VoterRole noOne=new VoterRole();
        noOne.voterRegistration(0,"NONE", "NONE", "NONE", 0, 0);
          for(int i=0;i<voterList.size();i++)
          {
              if(voterList.get(i).checkVotersInDatabase(voterId))
                  voterList.get(i);
          }
          return noOne;
      }
      
   /* Method to calculate results */

       
       
           
       
   }
                  



     
               
               
  
          
           
   


 
     
    

