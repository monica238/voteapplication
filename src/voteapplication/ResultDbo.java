package voteapplication;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.*;

/*
 * @author 
 */
public class ResultDbo {

    Connection conn;
    Logger applog;

    /* connectToDB() */
    public boolean connectToDB() {
        /* Create DB Connection */
        /* JDBC driver name and database url */
        final String jdbc_driver = "com.mysql.jdbc.driver";
        final String db_url = "jdbc:mysql://localhost";

        /* Database credentials */
        final String USER = "vish";
        final String PASS = "Learn@v2l";

        /* Check if connection is successful */
        try {
            /*Register JDBC driver*/
            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Voteapplication", USER, PASS);

            /* Open a connection */
            System.out.println("Connecting to database");
            applog.info("DB connection successful!");
            return true;
        } /* Return Success or Failure */ catch (Exception e) {
            applog.error(e);
        }
        return false;
    }
    public void closeDbConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   public ArrayList<String> checkResults()
   {
        String SQLStatement;
        Statement SelectStatement = null;
        ArrayList<String> results=new ArrayList<String>();

        /* 2. Execure SQL Statement for Insert */
        try {
            SQLStatement = "Select candidate.candidateId,candidateFirstName,candidatePartyName,count(candidate.candidateId)as voteCount from candidate,Ballot,castVote where candidate.candidateId=castVote.candidateId,Ballot.candidateId=castVote.candidateId group by candidate.candidateId,candidateFirstName,candidatePartyName";
            SelectStatement = conn.createStatement();
            SelectStatement.execute(SQLStatement);

            ResultSet voterData = SelectStatement.getResultSet();
            while(voterData.next())
            {
                String result_rows;
                result_rows=voterData.getString("candidateId")+"|"+voterData.getString("candidateFirstName")+"|"+voterData.getString("candidatePartyName")+"|"+voterData.getString("voteCount");
                results.add(result_rows);
            }
            return results;
            
        } catch (Exception e) {
            System.out.println("No votes found ");
        }
        /* Rerurn Success or Failure*/
        return null;
    }
  
   }
    


