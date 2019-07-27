package voteapplication;

public class Voter {
    
    // public static void main(String[] args) {
        int voterId,aadharNo,age;
        String voterFirstName,city,address;
        boolean voted;
        /*For the voter to register*/
        private void voterRegistration(String voterName,int voterId,int aadharNo,int age)
        {
           // return checkVotersInDatabase(voterName,voterId,aadharNo,age);
        }
        private boolean checkVotersInDatabase(String voterFirstName,int voterId,int aadharNo)
        {
           /*To check whether the votername,voterId,aadharNo already exists in database*/
           return true;
        }
        
        
        /*For the voter to login*/
        private boolean voterLogin(String voterFullName,String password)
       {
           return checkVotersInDatabase(voterFullName,password);
       }
       private boolean checkVotersInDatabase(String voterFullName,String password)
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
