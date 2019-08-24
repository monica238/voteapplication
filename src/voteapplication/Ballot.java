package voteapplication;
import java.util.ArrayList;
/**
 * @author Monica
 * @datecreated 30-Jul-2019
 */
/*Class definition to create Ballot*/
public class Ballot {
    
    private BallotDbo bdbo;
    private CandidateDbo cdbo;
    /* Method to create ballot */

    public void createBallot(String username) {
        bdbo = new BallotDbo();
        bdbo.connectToDB();
        bdbo.createBallot(username);
    }

    /*Method to get candidate object*/
    public Candidate getCandidate(int candidateId) {
        cdbo = new CandidateDbo();
        cdbo.connectToDB();
        return cdbo.getCandidateObjectById(candidateId);
    }

    public ArrayList getCandidates() {
        bdbo = new BallotDbo();
        bdbo.connectToDB();
        return bdbo.getBallotCandidates();
    }
    /*Method to validate whether the ballot is created or not*/

    public boolean isBallotCreated() {
        bdbo = new BallotDbo();
        bdbo.connectToDB();
        return bdbo.isBallotCreated();
    }
}
