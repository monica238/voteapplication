package voteapplication;

import java.sql.Connection;
import java.sql.*;
import org.apache.log4j.*;

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
       Candidate connection;//DB Connection Object declaration
     Connection conn;
     Logger applog;
     
     public CandidateDbo()
     {
         applog=Logger.getLogger(VoterDbo.class);         
     }
    /* 1. connectToDB() */
    public boolean connectToDB()
    {
        // Create DB Connection
        /* JDBC driver name and database url */
    final String jdbc_driver="com.mysql.jdbc.driver";
    final String db_url="jdbc:mysql://localhost";
    
  /* Database credentials */
     final String USER= "monica";
     final String PASS= "Learn@v2l"; 
        // Check if connection is successful     
     try
      {
        /*Register JDBC driver*/
        //Class.forName("com.mysql.jdbc.Driver");
          Class.forName("com.mysql.jdbc.Driver");  
          conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Voting","vish","Learn@v2l");          
        /* Open a connection */
        System.out.println("Connecting to database");                
        //applog.info("DB connection successful!");
        return true;
      }
      // Return Success or Failure      
      catch(Exception e)
      {
          //applog.error(e);
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
        
        /* 2. Execure SQL Statement for Select */
       String SQLStatement;
       Statement SelectStatement=null;
        
        /* 2. Execure SQL Statement for Insert */
       try
       {                  
       SQLStatement="SELECT * FROM vOTER WHERE VOTERiD="+voterId;
       SelectStatement=conn.prepareStatement(SQLStatement);
       conn.commit();       
       ResultSet rs=SelectStatement.getResultSet();
       Candidate candidateInstance=new Candidate();
       candidateInstance.setCandidateId(rs(0));
       return candidateInstance;
       }
       catch(Exception e)
       {
         return false;  
       }
        /*3. Rerurn Success or Failure*/
       return null; 
    }
       /* 3. Create CandidateObject and Assign DB values to it */
        
        /* 4. Rerurn candidate Object */
       
    
    
    public boolean updateCandidate(int candidateId,Candidate candidateInstance)
    {
        /* 1. connectToDB()*/
        
        /* 2. Execure SQL Statement for Select */
        String SQLStatement;
       Statement SelectStatement=null;
       try
       {                  
       SQLStatement="SELECT * FROM CANDIDATE WHERE CANDIDATEiD="+candidateId;
       SelectStatement=conn.prepareStatement(SQLStatement);
       conn.commit();       
       ResultSet rs=SelectStatement.getResultSet();
       return true;
       }
       catch(Exception e)
       {
         return false;  
       }
        /*3. Rerurn Success or Failure*/
        
    
     /* 3. Check if Voter ID is valid */
       if (validateCandidateId(candidateList,candidateId))
         {
           System.out.println("candidate exists");
           /* 4. If Valid, Execure SQL Statement Update */
           try
            {                  
              SQLStatement="UPDATE CANDIDATE SET CANDIDATEiD=value"+candidateId;
              SelectStatement=conn.prepareStatement(SQLStatement);
              conn.commit();       
              ResultSet rs=SelectStatement.getResultSet();
              return true;
            }
           catch(Exception e)
            {
               return false;  
            }
         }
       else
       {
           System.out.println("candidate does not exist");
       
        return false;
       }
        /* 5. Return Success/Failure */
        return true;
    }    
    }
    
    public boolean deleteCandidate(int candidateId)
    {
        
       /*3. Execure SQL Statement for Select*/
           String SQLStatement;
       Statement SelectStatement=null;
       try
       {                  
         SQLStatement="SELECT * FROM CANDIDATE WHERE CANDIDATEID="+candidateId;
         SelectStatement=conn.prepareStatement(SQLStatement);
         conn.commit();       
         ResultSet rs=SelectStatement.getResultSet();
         return true;
       }
       catch(Exception e)
       {
         return false;  
       }
       /* 4. Check if Candidate ID is valid*/
      if (validateCanididateid(candidateList,candidateId))
         {
           System.out.println("Candidate exists");
           
       /* 5. If Valid, Execure SQL Statement Delete*/
             String SQLStatement;
       Statement SelectStatement=null;
       try
       {                  
       SQLStatement="DELETE  FROM CANDIDATE WHERE CANDIDATEiD="+candidateId;
       SelectStatement=conn.prepareStatement(SQLStatement);
       conn.commit();       
       ResultSet rs=SelectStatement.getResultSet();
       return true;
       }
       catch(Exception e)
       {
         return false;  
       }
         }
      else
      {
          return false;
      }
      /*  6. Return Success/Failure*/
     return true;           
    }
    
   }

    }
    
 }
}