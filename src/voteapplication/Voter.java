package voteapplication;

public class Voter {
    
    // public static void main(String[] args) {
        int voterId,aadharNo;
        String voterName,city,address;
        /*For the voter to register*/
        private void voterRegistration(int voterId,int aadharNo,String voterName)
        {
            return checkUserInDatabase(voterId,aadharNo,voterName);
        }
        private boolean checkUserInDatabase(String voterName,int voterId,int aadharNo)
        {
           /*To check whether the votername,voterId,aadharNo already exists in database*/
           return true;
        }
        
        
        /*For the voter to login*/
        private boolean voterLogin(String votername,String password)
       {
           return checkUserInDatabase(votername,password);
       }
       private boolean checkUserInDatabase(String votername,String password)
       {
           /*To check whether the username already exists in database*/
           return true;
       }
        
    
    public int getvoterId()
    {
      return voterId;  
    }
    public int getaadharNo()
    {
       return aadharNo; 
    }
    public String getvoterName()
    {
       return voterName; 
    }
}
