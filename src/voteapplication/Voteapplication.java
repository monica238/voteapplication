 package voteapplication;
import java.io.DataInputStream;
import java.lang.Exception;
import java.util.ArrayList;

public class Voteapplication 
{   
  public static void main(String[] args) {
  AdminRole admin=new AdminRole();
  Voter voterInstance=new Voter();
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
 public static Voter createVoter()
 {                               
    Voter voterInstance=new Voter();
     String voterFirstName;
     int voterId;
     int aadharNo;
     int age;
     String address;
     String city;
     
           DataInputStream in=new DataInputStream(System.in);
           try
           {
              System.out.println("Please provide your details");

               System.out.println("Enter your name:");
               voterFirstName=in.readLine();

               System.out.println("Enter your voter id:");
           voterId=Integer.parseInt(in.readLine());

           System.out.println("Enter your aadhar number:");
           aadharNo=Integer.parseInt(in.readLine());

           System.out.println("Enter your age:");
           age=Integer.parseInt(in.readLine());

           System.out.println("Enter your address:");
           address=in.readLine();

           System.out.println("Enter your city:");
           city=in.readLine();

           voterInstance.voterRegistration(voterFirstName, city, address, voterId, aadharNo, age);           
           }
           catch (Exception e)
           {
               System.out.println(e);
           }
           return voterInstance;
        }
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
      public static Ballot createBallot()
      {
          
      }
      public boolean checkBallotcreationInDatabase(int voterId)
        {
            if(Ballot.validatecreateBallot()==true)
        {
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
            if(VoterList.contains(voterId))
            {
                System.out.println("voter id is valid and exists in voter list");
                CastVoteInstance=createCastVote();
               voterList.add(voterInstance);
                System.out.println(voterInstance.showVoterDetails());
                System.out.println(voterList.size());
            
            
              return true;
        
              int voterId;
              DataInputStream in=new DataInputStream(System.in);
              try
              {
               System.out.println("Enter your voterId:");
               voterId=Integer.parseInt(in.readLine());
              }
              catch(Exception e)
              {
                  System.out.println(e);
              }
              public boolean validatevoterid(int voterId)
              {
               if(this.voterId.compareTo(voterId))
               {
                  return true;
               }
              
               public Ballot displayCandidateList()
               {
                   for(int index=0;index<candidateList.size();index++)
                   {
                       System.out.println(candidateList.get(index));
                   }
               System.out.println("Select the candidate");
               if(this.)
               
                return false;
    }
     
               
               
  
          
        }     
   

}
 
     
    

