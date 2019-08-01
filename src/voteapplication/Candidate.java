package voteapplication;
public class Candidate 
{
   private String candidateFirstName;
   private String candidateParty;
   private int candidateId;
   private int age;
   private int count;
   private String city;
        
public void candidateDetails(String candidateFirstName,String candidateParty,String city,int candidateId,int age)
        {
            this.candidateFirstName=candidateFirstName;
            this.candidateParty=candidateParty;
            this.city=city;
            this.candidateId=candidateId;
            this.age=age;
            
           // return checkVotersInDatabase(voterName,voterId,aadharNo,age);
        }
        public boolean checkCandidateInDatabase(int candidateId)
        {
            if(this.candidateId==candidateId)
              return true;
           return false;
        }     
        
        public String showCandidateDetails()
        {
            return candidateFirstName +"|"+ candidateParty +"|"+ city +"|"+ candidateId +"|"+ age;
        }

}

            