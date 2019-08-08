package voteapplication;

import java.sql.Connection;
import java.sql.*;
import org.apache.log4j.*;
import static voteapplication.Voteapplication.validateCandidateid;

/**
 *
 * @author KING
 */
public class CandidateDbo 
{
    Candidate connection;//DB Connection Object declaration
     Connection conn=null;
    
     
    
    public boolean connectToDB()
    {
         // Create DB Connection
        /* JDBC driver name and database url */
    final String jdbc_driver="com.mysql.jdbc.driver";
    final String db_url="jdc:mysql://localhost";
    
  /* Database credentials */
     final String USER= "username";
     final String PASS= "password"; 
        // Check if connection is successful     
     try
      {
        /*Register JDBC driver*/
        Class.forName("com.mysql.jdbc.Driver");
        
        /* Open a connection */
        System.out.println("Connecting to database");        
        conn=DriverManager.getConnection(db_url,USER,PASS);
        applog.info("DB connection successful!");
        return true;
      }
      // Return Success or Failure      
      catch(Exception e)
      {
          applog.error(e);
          return false;
      }
    }
     
    
    public boolean createCandidate(Candidate candidateInstance)
    {
        String SQLStatement;
       Statement InsertStatement=null;
        
        
        /* 2. Execure SQL Statement for Insert */
       try
       {                  
       SQLStatement ="INSERT INTO Candidate(candidateId,candidateFirstname,age,city,candidateParty)values(1001,damini,mv,23,mysore,234567891)";
       InsertStatement=conn.prepareStatement(SQLStatement);
       conn.commit();       
       return true;
       }
       catch(Exception e)
       {
         return false;  
       }
       
        /*3. Rerurn Success or Failure*/
    }
    
    public Voter getCandidateObject(int voterId)
    {
        
        /* 2. Execure SQL Statement for Select */
        SELECT * FROM Candidate;
        
       /* 3. Create CandidateObject and Assign DB values to it */
        Candidate candidateobj=new candidateobj();
        candidateobj=
        /* 4. Rerurn candidate Object */
        return candidateobj;
        
    }
    
    public boolean updateCandidate(int candidateId,Candidate candidateInstance)
    {
        /*
        1. connectToDB()
        3. Execure SQL Statement for Select
        4. Check if candidate ID is valid
        5. If Valid, Execure SQL Statement Update
        6. Return Success/Failure
        */
    }
    
    public boolean deleteCandidate(int candidateId)
    {
        /*
        1. connectToDB()
        3. Execure SQL Statement for Select
        4. Check if candidate ID is valid
        5. If Valid, Execure SQL Statement Delete
        6. Return Success/Failure
        */        
    }
    
}

}
