package voteapplication;
import java.io.DataInputStream;
import java.lang.Exception;
import java.util.ArrayList;

public class Voteapplication 
 {   
   public static void main(String[] args) 
   {
     Admin admin=new Admin();                                       
     
     Ballot ballotForVoting=null;
     ArrayList voterList=new ArrayList();
     ArrayList candidateList=new ArrayList();
     ArrayList castVoteList=new ArrayList();
     
     boolean isBallotCreated=false;
   
     String adminUserName;
     String adminPassword;

//                             Voter voterInstance2=new Voter();
//                        //voterInstance=createVoter();
//                        //voterList.add(voterInstance);   
//                        VoterDbo voterDBObject1=new VoterDbo();
//                        voterDBObject1.connectToDB();
//                        voterDBObject1.createVoter(voterInstance2);
//     
     
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
        
            System.out.println(adminUserName+"-"+adminPassword);
        
            if(admin.validateAdminLogin(adminUserName, adminPassword)==true)
            {
                System.out.println("Login Success");
             
                // Iterative process for Voter Registration, Candidate Rwegistration, Ballot creation and Results
                do
                {
             
                    System.out.println("Please select the choice of operation:\n1. Voter Registraion\n2. Candidate Nomination\n3. Ballot creation\n4. Results\n5. Exit\n");
                    optionForOperation=Integer.parseInt(in.readLine());
             
                    if(optionForOperation==1)
                    {
                        /* Voter Registration */
                        Voter voterInstance=new Voter();
                        //voterInstance=createVoter();
                        //voterList.add(voterInstance);   
                        VoterDbo voterDBObject=new VoterDbo();
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
                        candidateList.add(candidateInstance);                    
                    }
                    else if(optionForOperation==3)
                    {
                        /* Create ballot */                        
                        ballotForVoting=createBallot(candidateList);
                        isBallotCreated=true;
                    }
                    else if(optionForOperation==4)
                    {
                        /* RESULTS */
                        System.out.println(castVoteList.size());                                            
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
                    System.out.println(voterList.size());
                    System.out.println("Please enter voter id to validate:");
                    DataInputStream in=new DataInputStream(System.in);
                    try
                    {
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
                           Candidate candidateInstance;
                           candidateInstance=ballotForVoting.getCandidate(candidateId);

                           /* Get Voter  Instance from the registration database */
                           Voter voterInstance;
                           voterInstance=getVoterInstanceById(voterList,voterId);


                           /* If voting is done add the cast vote to the cast vote list */
                           CastVote castVoteInstance;
                           castVoteInstance=new CastVote();

                           castVoteInstance.setCandidateInstance(candidateInstance);
                           castVoteInstance.setVoterInstance(voterInstance);

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
   public static boolean validateVoterid(ArrayList<Voter> voterList,int voterId)
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
      public static Voter getVoterInstanceById(ArrayList<Voter> voterList,int voterId)
      {
        Voter noOne=new Voter();
        noOne.voterRegistration(0,"NONE", "NONE", "NONE", 0, 0);
          for(int i=0;i<voterList.size();i++)
          {
              if(voterList.get(i).checkVotersInDatabase(voterId))
                  voterList.get(i);
          }
          return noOne;
      }
      
   /* Method to calculate results */
   public static void votingresults()
   {
     int candidate[]= new int[6];  
     int voters;
     int ballot=0;
     int count=0;
     int check=0,winner=0,looser=0;
     String str;
     try
     {
         
         System.out.println("enter the number of voters appeared for voting");
         check=Integer.parseInt(str);
         for(int i=1;i<=voters;i++)
             System.out.print("vote given by voter("+i+") to candidate:");
             str=readLine();
         if(check<1 && check>ArrayList<CastVote> castVoteList)
         {
             ballot=ballot+1;
             continue;
         }
         else
         {
             candidate[check]=candidate[check]+1;
         }
     }
     
     System.out.println("Voting results are");
     for(int i=1;i<=;i++)
     {
         System.out.println("candidateid:"+i+" has received "+candidate[i]+"votes");
     }   
     for(int i=1;i<=;i++)
         
     {
         if(i==1)
             winner=i;
        
     }
     
   }
       
       
           
       
   }
                  



     
               
               
  
          
           
   


 
     
    

