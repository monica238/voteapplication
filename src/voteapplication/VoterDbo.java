package voteapplication;
import java.sql.*;
import org.apache.log4j.*;

/**
 * @author  
 */
public class VoterDbo 
{
     Voter connection;//DB Connection Object declaration
     Connection conn;
     Logger applog;
     
     public VoterDbo()
     {
         applog=Logger.getLogger(VoterDbo.class);         
     }
    /* connectToDB() */
    public boolean connectToDB()
    {
        /* Create DB Connection */
        /* JDBC driver name and database url */
      final String jdbc_driver="com.mysql.jdbc.driver";
      final String db_url="jdbc:mysql://localhost";
    
     /* Database credentials */
     final String USER= "monica";
     final String PASS= "Learn@v2l"; 
     
        /* Check if connection is successful */     
     try
      {
        /*Register JDBC driver*/
          Class.forName("com.mysql.jdbc.Driver");
          Class.forName("com.mysql.jdbc.Driver");  
          conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Voting","vish","Learn@v2l");
          
        /* Open a connection */
        System.out.println("Connecting to database");                
        applog.info("DB connection successful!");
        return true;
      }
     
      /* Return Success or Failure */      
      catch(Exception e)
      {
          applog.error(e);
          return false;
      }
    }
    
            
    // CRUD Operation
    public boolean createVoter(Voter voterInstance)
    {       
       Statement InsertStatement;
        
        /* Execure SQL Statement for Insert */
       try
        {            
         String SQLStatement="insert into Voter(voterId,voterFirstName,voterLastName,voterLocation,voterAge,voterAadharnumber) values(106,'Sandeep','S','Mysore',23,12345)";       
         InsertStatement=conn.createStatement();
         InsertStatement.execute(SQLStatement);       
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
        /* Rerurn Success or Failure*/
       return null; 
    }
    
    public boolean updateVoter(int voterId,Voter voterInstance)
    {
        /* connectToDB()*/
        
        /* Execure SQL Statement for Select */
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
        /* Return Success or Failure*/
        
    
        /* Check if Voter ID is valid */
       if (validateVoterid(voterList,voterId))
         {
           System.out.println("Voter exists");
           /* If Valid, Execure SQL Statement Update */
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
        /* Return Success/Failure */
        return true;
    }    
    
    
    public boolean deleteVoter(int voterId)
    {
        /* Execure SQL Statement for Select */
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
       /* Check if Voter ID is valid*/
      if (validateVoterid(voterList,voterId))
         {
           System.out.println("Voter exists");
           
       /* If Valid, Execure SQL Statement Delete*/
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
      /* Return Success/Failure*/
     return true;           
    }
    
   }
