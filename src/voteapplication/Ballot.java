package voteapplication;
public class Ballot {
        int candidateId;
        String candidateFirstName,candidatePartyName;
    
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
public String getcandidatePartyName()
{
    voteapplication.Candidate obj=new voteapplication.Candidate();
   return candidatePartyName;
}

    
}
