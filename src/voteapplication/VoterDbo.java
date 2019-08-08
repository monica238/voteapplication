package voteapplication;
import java.sql.*;
import org.apache.log4j.*;
import static voteapplication.Voteapplication.validateVoterid;
/**
 * @author  
 */
public class VoterDbo 
{
     Voter connection;//DB Connection Object declaration
     Connection conn=null;
     Logger applog;
     
     public VoterDbo()
     {
         applog=Logger.getLogger(VoterDbo.class);
     }
    /* 1. connectToDB() */
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
    
            
    // CRUD Operation
    public boolean createVoter(Voter voterInstance)
    {
       String SQLStatement;
       Statement InsertStatement=null;
        
        /* 2. Execure SQL Statement for Insert */
       try
       {                  
       SQLStatement="INSERT INTO Voter(voterid,voterFname,voterLname,voterAge,voterLocation,voterAadharno) values(1001,damini,mv,23,mysore,234567891)";
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
    
    public Voter getVoterObject(int voterId)
    {
        
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
       Voter voterInstance=new Voter();
       voterInstance.setVoterId(rs(0));
       return voterInstance;
       }
       catch(Exception e)
       {
         return false;  
       }
        /*3. Rerurn Success or Failure*/
        
    }
    
    public boolean updateVoter(int voterId,Voter voterInstance)
    {
        /* 1. connectToDB()*/
        
        /* 2. Execure SQL Statement for Select */
        String SQLStatement;
       Statement SelectStatement=null;
       try
       {                  
       SQLStatement="SELECT * FROM vOTER WHERE VOTERiD="+voterId;
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
       if (validateVoterid(voterList,voterId))
         {
           System.out.println("Voter exists");
           /* 4. If Valid, Execure SQL Statement Update */
           try
            {                  
              SQLStatement="UPDATE VOTER SET VOTERiD=value"+voterId;
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
           System.out.println("voter does not exist");
       
        return false;
       }
        /* 5. Return Success/Failure */
    }    
    
    
    public boolean deleteVoter(int voterId)
    {
        /*3. Execure SQL Statement for Select*/
           String SQLStatement;
       Statement SelectStatement=null;
       try
       {                  
       SQLStatement="SELECT * FROM vOTER WHERE VOTERiD="+voterId;
       SelectStatement=conn.prepareStatement(SQLStatement);
       conn.commit();       
       ResultSet rs=SelectStatement.getResultSet();
       return true;
       }
       catch(Exception e)
       {
         return false;  
       }
       /* 4. Check if Voter ID is valid*/
      if (validateVoterid(voterList,voterId))
         {
           System.out.println("Voter exists");
           
       /* 5. If Valid, Execure SQL Statement Delete*/
             String SQLStatement;
       Statement SelectStatement=null;
       try
       {                  
       SQLStatement="DELETE  FROM VOTER WHERE VOTERiD="+voterId;
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
                
    }
    
   }
}