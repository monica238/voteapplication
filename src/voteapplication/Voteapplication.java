package voteapplication;
import java.io.DataInputStream;
import java.io.*;
import java.lang.Exception;
import java.util.ArrayList;

public class Voteapplication 
 {   
   public static void main(String[] args) 
   {
     Admin admin=new Admin();                                       
     
     Ballot ballotForVoting=new Ballot();
     
     boolean isBallotCreated=false;
   
     String adminUserName;
     String adminPassword;

     /*
     Sample code Voter
     */
    /*
     Voter v=new Voter();
     VoterDbo vdb=new VoterDbo();
     
     vdb.connectToDB();
     v=vdb.getVoterObjectById(102);
     if(v!=null)
        System.out.println(v.getVoterFname());
     else
         System.out.println("Invalid VoterID");
     System.exit(0);
     */
     /*
     Sample code Voter
     */

     /*
     Sample code Voter
     */
     /*
     Candidate v=new Candidate();
     CandidateDbo vdb=new CandidateDbo();
     
     vdb.connectToDB();
     v=vdb.getCandidateObjectById(11);
     if(v!=null)
        System.out.println(v.getCandidateFirstName());
     else
         System.out.println("Invalid CandidateId");
     System.exit(0);
     */
     /*
     Sample code Voter
     */
     
     int optionForRole=0;
     do
     {    
      System.out.println("Please sleect your role:\n1. Administrator\n2. Voter\n3. Exit");
      try
       {         
         DataInputStream in=new DataInputStream(System.in);
         optionForRole=Integer.parseInt(in.readLine());         
       }
      catch(Exception e)
      {
          System.out.println(e);
      }
     if(optionForRole==1)
     {
        int optionForOperation;
        System.out.println("ADMINISTRATOR LOGIN MODULE");
        System.out.println("Enter Username and Password for Admin:");
        try
        {
            DataInputStream in=new DataInputStream(System.in);
            adminUserName=in.readLine();
            adminPassword=in.readLine();
              
            if(admin.validateAdminLogin(adminUserName, adminPassword))
            {
                System.out.println("Login Success");
             
                /* Iterative process for Voter Registration, Candidate Rwegistration, Ballot creation and Results */
                do
                {
             
                    System.out.println("Please select the choice of operation:\n1. Voter Registraion\n2. Candidate Nomination\n3. Ballot creation\n4. Results\n5. Exit\n");
                    optionForOperation=Integer.parseInt(in.readLine());
             
                    if(optionForOperation==1)
                    {
                        /* Voter Registration */
                        Voter voterInstance=new Voter();
                        voterInstance=createVoter();
                         
                        VoterDbo voterDBObject=new VoterDbo();
                        voterDBObject.connectToDB();
                        if(voterDBObject.createVoter(voterInstance))
                        {
                            System.out.println("Voter details stored successfully");
                        }
                        else
                        {
                            System.out.println("Error in insert query");
                        }
                    }
                    else if(optionForOperation==2)
                    {
                        /* Candidate Registration */
                        Candidate candidateInstance;
                        candidateInstance=createCandidate();
                          
                        CandidateDbo candidateDBObject=new CandidateDbo();
                        candidateDBObject.connectToDB();
                        if(candidateDBObject.createCandidate(candidateInstance))
                        {
                            System.out.println("Candidate details stored successfully");
                        }
                        else
                        {
                            System.out.println("Error in insert query");
                        }
                    }
                    else if(optionForOperation==3)
                    {
                        /* Create ballot */                        
                        if(!isBallotCreated)                        
                        {
                            ballotForVoting=createBallot(adminUserName);
                            isBallotCreated=true;
                        }                        
                    }
                    else if(optionForOperation==4)
                    {
                        /* RESULTS */
                        System.out.println();                                            
                    }
                    else if(optionForOperation==5)
                    {
                        /* Exit */
                        return;
                     }
                 else
                 {
                     System.out.println("Invalid choice");
                 }
             }
             while(true);
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
     else if(optionForRole==2)
     {
            /* Voter Role */
           /* To evaluate whether the voter id is valid or not */
                    int voterId;
                    int candidateId;
                    System.out.println();
                    System.out.println("Please enter voter id to validate:");
                    DataInputStream in=new DataInputStream(System.in);
                    try
                    {
                    voterId=Integer.parseInt(in.readLine());


                    if (validateVoterid(voterId))
                    {
                        System.out.println("Voter exists");

                       /* Show Ballot for Voting */                       
                       InBallot=ballotForVoting.getCandidates();
                       for(int i=0;i<;i++)
                            System.out.println(InBallot.get(i).showCandidateDetails());

                       /* Accept the Candidate ID */
                       System.out.println("Enter the candidate id");
                       candidateId=Integer.parseInt(in.readLine());

                       /* Validate the Candiate ID */
                       if (validateCandidateId(candidateId))
                         {
                           System.out.println("Candidate id exists");

                       /* If Candidate exists, get CandidateOBject from ballotForVoting */
                           Candidate candidateInstance;
                           candidateInstance=ballotForVoting.getCandidate(candidateId);

                           /* Get Voter  Instance from the registration database */
                           Voter voterInstance;
                           voterInstance=getVoterInstanceById(voterId);


                           /* If voting is done add the cast vote to the cast vote list */
                           CastVote castVoteInstance;
                           castVoteInstance=new CastVote();

                           castVoteInstance.setCandidateInstance(candidateInstance);
                           castVoteInstance.setVoterInstance(voterInstance);

                           .add(castVoteInstance);
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
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
            } 
           else if(optionForRole==3)
              {
                return;
              }
           else
            {
              System.out.println("Invalid Choice");
            }
     }
   while(true);
 }
      

   /* Method to create voter*/
   public static Voter createVoter()
    {                               
      Voter voterInstance=new Voter();     /* Object created for voter role class */
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
              System.out.println("VOTER REGISTRATION MODULE");
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
              System.out.println("NOMINATION OF CANDIDATES");
              System.out.println("Please provide candidate details");
           
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
  public static Ballot createBallot(String username)
    {
        Ballot ballot=new Ballot();                /* New object created for Ballot class */
        ballot.createBallot(username);        /* Method class which holds the list of candidates */
        return ballot;                             /* Object to be returned */
    }
  /* Method to check ballot creation in database */
  public static void checkBallotcreationInDatabase(int voterId)
    {
      
    }
       
   /* Method to validate whether voter id exists in the voter list or not */     
   public static boolean validateVoterid(int voterId)
    {
//        for(int i=0;i<voterList.size();i++)
//            if(voterList.get(i).checkVotersInDatabase(voterId))      /* check for the voter id in the database */
//                return true;                                         /* if voter id exists in database */
//        return false; /* if voter id does not exists in database */
        
        VoterDbo vdbo=new VoterDbo();
        vdbo.connectToDB();
        if(vdbo.getVoterObjectById(voterId)!=null)
            return true;
        return false;
    }
   
   /* Method to validate whether candidate id exists in the candidate list or not */
      public static boolean validateCandidateId(int candidateId)
    {
       
        return false;   
    }
   /* Method to get the voter instance by voter id */
      public static Voter getVoterInstanceById(int voterId)
      {
          vdbo.connectToDB();
        Voter noOne=new Voter();
        noOne.voterRegistration(0,"NONE", "NONE", "NONE", 0, 0);
          for(int i=0;i;i++)
          {
              if(vdboDbo.get(i).checkVotersInDatabase(voterId))
                  vdbo.get(i);
          }
          return noOne;
      }

      
   /* Method to calculate results */
   public static Result votingresults()
   {
        return null;  
   }
       
       
           
       
}
                  
          
  
          
           
   


 
     
    

