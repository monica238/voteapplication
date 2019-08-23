package voteapplication;
import java.util.ArrayList;
/**
 * @author Monica
 *@datecreated 30-Jul-2019
 */
/*Class definition to create Ballot*/
public class Ballot 
{   
    /* Method to create ballot */
    public void createBallot(String username)
    {        
        BallotDbo bdo=new BallotDbo();
        bdo.connectToDB();
        bdo.createBallot(username);
    }
    
  /*Method to get candidate object*/  
   public Candidate getCandidate(int candidateId)
    {
        CandidateDbo cdbo=new CandidateDbo();
        cdbo.connectToDB();                
        return cdbo.getCandidateObjectById(candidateId);
    }
      
   
  public ArrayList getCandidates()
  {
      BallotDbo bdbo=new BallotDbo();
      bdbo.connectToDB();
      return bdbo.getBallotCandidates();
  }
  /*Method to validate whether the ballot is created or not*/
   public boolean isBallotCreated()
    {
           BallotDbo bdbo=new BallotDbo();
           bdbo.connectToDB();
           return bdbo.isBallotCreated();
     }
}
