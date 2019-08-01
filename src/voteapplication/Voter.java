package voteapplication;

public class Voter 
{
    
        private int voterId;
        private int aadharNo;
        private int age;
        private String voterFirstName;
        private String city;
        private String address;
        private boolean voted;
        /*For the voter to register*/
        public void voterRegistration(String voterFirstName,String city,String address,int voterId,int aadharNo,int age)
        {
            this.voterFirstName=voterFirstName;
            this.city=city;
            this.address=address;
            this.aadharNo=aadharNo;
            this.voterId=voterId;
            this.age=age;
            
           // return checkVotersInDatabase(voterName,voterId,aadharNo,age);
        }
        public boolean checkVotersInDatabase(int aadharNo)
        {
            if(this.aadharNo==aadharNo)
              return true;
           return false;
        }     
        
        public String showVoterDetails()
        {
            return voterId+voterFirstName+aadharNo+address+city+age;
        }
}