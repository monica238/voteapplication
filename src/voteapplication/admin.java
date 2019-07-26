
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
       public String getcandidateDetails(String candidateName,String candidateDoc)
       {
         return  candidateDoc;
           
       }
       /*To add candidate dtails*/
       public String addcandidateDetails(String candidateName,String candidateParty,int candidateId)
       {
           
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

