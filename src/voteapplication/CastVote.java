package voteapplication;
/**
 * @author Monica
 *@datecreated 27-Jul-2019
 */
/* Class definition to cast the vote from voter*/
public class CastVote 
{
  private Voter voterInstance;
  private Candidate candidateInstance;
  
  
 public void castVote()
 {
     CastVoteDbo cvdbo=new CastVoteDbo();
     cvdbo.connectToDB();
     cvdbo.createCastVote(this);
 }
  
  /* Method to accept candidate Id*/
  public Candidate getCandidateInstance()
   { 
     return candidateInstance;
   }
  
  public boolean checkIfVotingIsDone(int voterId)
  {
      CastVoteDbo cvdbo=new CastVoteDbo();
      cvdbo.connectToDB();
      return cvdbo.checkIfVotingIsDone(voterId);
  }
  
  /*Method to accept voter Id*/
  public Voter getVoterInstance()
   {
     return voterInstance;
   }
  /* Method to set voter instance */
  public void setVoterInstance(Voter voterInstance)
  {
      this.voterInstance=voterInstance;
  }
  /* Method to set candidate instance */
  public void setCandidateInstance(Candidate candidateInstance)
  {
      this.candidateInstance=candidateInstance;
  }
  
  
}
    

