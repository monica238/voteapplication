package voteapplication;

public class Voter {
    
    // public static void main(String[] args) {
        int voterId,aadharNo,age;
        String voterFirstName,city,address;
        boolean voted;
        /*For the voter to register*/
        private void voterRegistration(int voterId,int aadharNo,int age,String voterName)
        {
            return checkUserInDatabase(voterId,aadharNo,age,voterName);
        }
        private boolean checkUserInDatabase(String voterFirstName,int voterId,int aadharNo)
        {
           /*To check whether the votername,voterId,aadharNo already exists in database*/
           return true;
        }
        
        
        /*For the voter to login*/
        private boolean voterLogin(String voterFullName,String password)
       {
           return checkUserInDatabase(voterFullName,password);
       }
       private boolean checkUserInDatabase(String voterFullName,String password)
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
    public String getvoterFirstName()
    {
       return voterFirstName; 
    }
}
