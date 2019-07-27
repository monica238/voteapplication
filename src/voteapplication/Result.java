package voteapplication;
public class Result {
        int candidateId,count;
        String result;
        
     public int getCandidateId()
     {
         voteapplication.Candidate obj=new voteapplication.Candidate();
         return candidateId;
    }
    public int getVoteCount()
     {
         voteapplication.CastVote obj=new voteapplication.CastVote();
         return count;
    }
    
}
