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
        this.candidateList=candidateList;
        BallotDbo bdo=new BallotDbo();
        bdo.connectToDB();
        bdo.createBallot(username);
    }
    
  /*Method to get candidate object*/  
   public Candidate getCandidate(int candidateId)
    {
        Candidate noOne=new Candidate();
        noOne.candidateDetails("NONE", "NONE", "NONE", 0, 0);
      for(int i=0;i<;i++)
          if(.get(i).checkCandidateInDatabase(candidateId))
              return .get(i);
      return noOne;
    }
   
  public Ballot getCandidates()
  {
      BallotDbo bdbo=new BallotDbo();
      bdbo.connectToDB();
      return bdbo.getBallotCandidates();
  }
  /*Method to validate whether the ballot is created or not*/
   public boolean checkBallotcreationInDatabase()
    {
      if(>0)        
            return true;
        return false;
     }
}
