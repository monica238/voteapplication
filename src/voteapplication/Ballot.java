package voteapplication;
import java.util.ArrayList;
/**
 * @author Monica
 *@datecreated 30-Jul-2019
 */
/*Class definition to create Ballot*/
public class Ballot 
{

    private ArrayList<Candidate> candidateList;
    
    public void createBallot(ArrayList<Candidate> candidateList)
    {
        this.candidateList=candidateList;
    }
    
  /*Method to get candidate object*/  
   public Candidate getcandidate(int candidateId)
    {
        Candidate noOne=new Candidate();
        noOne.candidateDetails("NONE", "NONE", "NONE", 0, 0);
      for(int i=0;i<candidateList.size();i++)
          if(candidateList.get(i).checkCandidateInDatabase(candidateId))
              return candidateList.get(i);
      return noOne;
    }
   
  public ArrayList<Candidate> getCandidates()
  {
          return candidateList;
  }
  /*Method to validate whether the ballot is created or not*/
   public boolean checkBallotcreationInDatabase()
    {
      if(candidateList.size()>0)        
            return true;
        return false;
     }
}
