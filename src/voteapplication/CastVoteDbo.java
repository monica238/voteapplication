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
    
        public void closeDbConnection()
    {
        try
        {
        conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public boolean createCastVote(CastVote castVoteInstance)
    {
       Statement InsertStatement;
              
       /* Execure SQL Statement for Insert */
       try
        {            
            String SQLStatement="insert into CastVote(castVoteId,voterId,candidateId,dateOfVoting) values(1,"+castVoteInstance.getVoterInstance().getVoterId()+","+castVoteInstance.getCandidateInstance().getCandidateId()+",current_date())";
            System.out.println(SQLStatement);
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
    
     public boolean checkIfVotingIsDone(int voterId)
    {
        
        /* 2. Execure SQL Statement for Select */
       String SQLStatement;
       Statement SelectStatement=null;
        
        /* 2. Execure SQL Statement for Insert */
       try
       {                  
       SQLStatement="Select count(VoterId) as cnt from CastVote where VoterId="+voterId;
       SelectStatement=conn.createStatement();
       SelectStatement.execute(SQLStatement);
       
       ResultSet voterData=SelectStatement.getResultSet();
       voterData.next();       
       if(voterData.getInt("cnt")>0)
        return true;              
       }
       catch(Exception e)
       {
          System.out.println("No Record found for VoterId:"+voterId);
       }
        /* Rerurn Success or Failure*/
       return false; 
    }  
       
    }
             
    

