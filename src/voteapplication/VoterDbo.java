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
            
    // CRUD Operation
    public boolean createVoter(Voter voterInstance)
    {       
       Statement InsertStatement;
              
       /* Execure SQL Statement for Insert */
       try
        {            
            String SQLStatement="insert into Voter(voterId,voterFirstName,voterLastName,voterLocation,voterAge,voterAadharnumber) values("+voterInstance.getVoterId()+",'"+voterInstance.getVoterFname()+"','"+voterInstance.getVoterLname()+"','"+voterInstance.getVoterLocation()+"',"+voterInstance.getVoterAge()+","+voterInstance.getVoterAadharNo()+")";       
            InsertStatement=conn.createStatement();
            InsertStatement.execute(SQLStatement);       
            return true;
        }
        catch(Exception e)
        {
              System.out.println(e);
        }
        return false;
        /*3. Rerurn Success or Failure*/       
    }
    
    public Voter getVoterObjectById(int voterId)
    {
        
        /* 2. Execure SQL Statement for Select */
       String SQLStatement;
       Statement SelectStatement=null;
        
        /* 2. Execure SQL Statement for Insert */
       try
       {                  
       SQLStatement="Select * from Voter where VoterId="+voterId;
       SelectStatement=conn.createStatement();
       SelectStatement.execute(SQLStatement);
       
       ResultSet voterData=SelectStatement.getResultSet();
       voterData.next();       
       Voter voterInstance=new Voter();
       voterInstance.setVoterId(voterData.getInt("voterId"));
       voterInstance.setVoterFname(voterData.getString("voterFirstName"));
       voterInstance.setVoterLname(voterData.getString("voterLastName"));
       voterInstance.setVoterLocation(voterData.getString("voterLocation"));
       voterInstance.setVoterAge(voterData.getInt("voterAge"));
       voterInstance.setVoterAadharNo(voterData.getInt("voterAadharNumber"));       
       return voterInstance;       
       }
       catch(Exception e)
       {
          System.out.println("No Record found for VoterId:"+voterId);
       }
        /* Rerurn Success or Failure*/
       return null; 
    }        
   }
