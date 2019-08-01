package voteapplication;
public class Ballot {
        int candidateId;
        String candidateFirstName,candidateParty;
    
public int getcandidateId()
 {
     voteapplication.Candidate obj=new voteapplication.Candidate();
      return candidateId;  
 }
public String getcandidateFirstName()
{
    voteapplication.Candidate obj=new voteapplication.Candidate();
   return candidateFirstName;
}
public String getcandidateParty()
{
    voteapplication.Candidate obj=new voteapplication.Candidate();
   return candidateParty;
}
public boolean checkBallotcreationInDatabase(String candidateFirstName,String candidateParty)
{
    if(this.candidateFirstName.compareTo(candidateFirstName)==0 && this.candidateParty.compareTo(candidateParty)==0)
        {
            return true;
        }
        return false;
}

    
}
