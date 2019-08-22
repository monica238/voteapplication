package voteapplication;
import java.sql.*;
import org.apache.log4j.*;
/**
 *
 * @author USER1
 */
public class CastVoteDbo 
{
     Connection conn;
     Logger applog;
     
    /* connectToDB() */
    public boolean connectToDB()
    {
        /* Create DB Connection */
        /* JDBC driver name and database url */
        final String jdbc_driver="com.mysql.jdbc.driver";
        final String db_url="jdbc:mysql://localhost";

        /* Database credentials */
        final String USER= "vish";
        final String PASS= "Learn@v2l"; 

        /* Check if connection is successful */     
        try
        {
            /*Register JDBC driver*/
            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Voting",USER,PASS);

            /* Open a connection */
            System.out.println("Connecting to database");                
            //applog.info("DB connection successful!");
            return true;
        }

        /* Return Success or Failure */      
        catch(Exception e)
        {
            applog.error(e); 
        }
        return false;
    }
    public boolean createCastVote(CastVote castVoteInstance)
    {
       Statement InsertStatement;
              
       /* Execure SQL Statement for Insert */
       try
        {            
            String SQLStatement="insert into CastVote(castVoteId,voterId,candidateId,dateOfVoting) values(1,'"+castVoteInstance.getVoterInstance().getVoterId()+"','"+castVoteInstance.getCandidateInstance().getCandidateId()+"','date('2019-9-14')))";
            InsertStatement=conn.createStatement();
            InsertStatement.execute(SQLStatement);       
            return true;
        }
        catch(Exception e)
        {
              System.out.println(e);
        }
         /*3. Rerurn Success or Failure*/  
        return false;
          
    }
    public CastVote getCastVoteInstanceById(int candidateId)
    {
        String SQLStatement;
        Statement SelectStatement=null;
        try
       {                  
//       SQLStatement="Select * from Ballot where candidateId="+candidateId;
//       SelectStatement=conn.createStatement();
//       SelectStatement.execute(SQLStatement);
//       ResultSet castVoteData=SelectStatement.getResultSet();
//       castVoteData.next();       
//       CastVote castVoteInstance=new CastVote();
//       castVoteInstance.setCandidateId(castVoteData.getInt("candidateId"));
       }
     catch(Exception e)
       {
          System.out.println("No CandidateID is found :"+candidateId);
       }
        /* Rerurn Success or Failure*/
       return null;  
        }
       
    }
             
    

