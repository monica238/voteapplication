
package voteapplication;

public class admin {
    
    // public static void main(String[] args) {
       int adminId,voterId,aadharNo;
       String adminName;
       /*Admn to Login to the system*/
       private boolean adminLogin(String username,String password)
       {
           return checkUserInDatabase(username,password);
       }
       private boolean checkUserInDatabase(String username,String password)
       {
           /*To check whether the user is valid or not in Database*/
           return true;
       }
       /*To capture the details of candidate*/
       public String getcandidateDetails(String candidateFirstName,String candidateDoc)
       {
           voteapplication.Candidate obj=new voteapplication.Candidate();
         return  candidateDoc;
           
       }
       /*To add candidate dtails*/
       public String addcandidateDetails(String candidateFirstName,String candidatePartyName,int candidateId,int candidateCity,int age)
       {
           voteapplication.Candidate obj=new voteapplication.Candidate();
           return 
       }
       public String updatecandidateDetails(int candidateId,String candidateFirstName)
       {
          voteapplication.Candidate obj=new voteapplication.Candidate();
          candidateId= new candidateId;
          candidateFirstName= new candidateFirstName;
          candidatePartyName=new candidatePratyName;
          candidateCity= new candidateCity;
          age=new age;
          
          }
       private boolean checkUserInDatabase(int candidateId)
       {
           return true;
       }
       
       public int deletecandidateDetails(int candidateId)
       {
         voteapplication.Candidate obj=new voteapplication.Candidate();
         return candidateId;
       }
       private boolean checkUserInDatabase(int candidateId)
       {
           return true;
       }
       
       public int getAdminId()
       {
           return adminId;
       }
       public int getVoterId()
       {
           return voterId;
       }
       public int getAadharNo()
       {
           return aadharNo;
       }
       public String getAdminName()
       {
           return adminName;
       }
       
    
   public int submitReport(int report)//submission of candidate list
    {
       return report ; 
    }
   public char displayResult(char result)//display voting results
    {
      return result;  
    }
    
        
    
}

