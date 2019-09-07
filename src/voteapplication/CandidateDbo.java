package voteapplication;

import java.sql.*;
//import org.apache.log4j.*;

/**
 * @author
 */
public class CandidateDbo {

    Voter connection;//DB Connection Object declaration
    Connection conn;
   // Logger applog;

    public CandidateDbo() {
      //  applog = Logger.getLogger(VoterDbo.class);

    }
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Voting", USER, PASS);

            /* Open a connection */
            System.out.println("Connecting to database");
            //applog.info("DB connection successful!");
            return true;
        } /* Return Success or Failure */ catch (Exception e) {
           // applog.error(e);
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

    // CRUD Operation

    public boolean createCandidate(Candidate candidateInstance) {
        Statement InsertStatement;

        /* Execure SQL Statement for Insert */
        try {
            String SQLStatement = "insert into Candidate(candidateId,candidateFirstName,candidatePartyName,candidateLocation,candidateAge) values(" + candidateInstance.getCandidateId() + ",'" + candidateInstance.getCandidateFirstName() + "','" + candidateInstance.getCandidatePartyName() + "','" + candidateInstance.getCandidateLocation() + "'," + candidateInstance.getCandidateAge() + ")";
            InsertStatement = conn.createStatement();
            InsertStatement.execute(SQLStatement);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
        /*3. Rerurn Success or Failure*/
    }

    public Candidate getCandidateObjectById(int candidateId) {

        /* 2. Execure SQL Statement for Select */
        String SQLStatement;
        Statement SelectStatement = null;

        /* 2. Execure SQL Statement for Insert */
        try {
            SQLStatement = "Select * from Candidate where candidateId=" + candidateId;
            SelectStatement = conn.createStatement();
            SelectStatement.execute(SQLStatement);

            ResultSet candidateData = SelectStatement.getResultSet();
            candidateData.next();
            Candidate candidateInstance = new Candidate();
            candidateInstance.setCandidateId(candidateData.getInt("candidateId"));
            candidateInstance.setCandidateFirstName(candidateData.getString("candidateFirstName"));
            candidateInstance.setCandidatePartyName(candidateData.getString("candidatePartyName"));
            candidateInstance.setCandidateLocation(candidateData.getString("candidateLocation"));
            candidateInstance.setCandidateAge(candidateData.getInt("candidateAge"));
            return candidateInstance;
        } catch (Exception e) {
            System.out.println("No Record found for CandidateID:" + candidateId);
        }
        /* Rerurn Success or Failure*/
        return null;
    }
}
