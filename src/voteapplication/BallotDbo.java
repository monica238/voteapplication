/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voteapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import java.util.ArrayList;

/**
 *
 * @author USER1
 */
public class BallotDbo {

    private Connection conn;
    private Logger applog;

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

    public boolean createBallot(String createdBy) {
        Statement SQLStatement;
        try {
            SQLStatement = conn.createStatement();
            SQLStatement.execute("insert into Ballot(ballotId,createdBy,createdDate) values(101,'" + createdBy + "',date('2019-9-14'))");
            SQLStatement.execute("insert into Ballot_candidates select \"101\" as ballotid,candidateid from candidate");
            return true;
        } catch (Exception e) {
            applog.error(e);
        }
        return false;

    }

    public ArrayList<Candidate> getBallotCandidates() {
        ArrayList<Candidate> candidatesInBallot = new ArrayList();
        String SQLStatement;
        Statement SelectStatement;
        try {
            SQLStatement = "select * from ballot_Candidates";
            SelectStatement = conn.createStatement();
            SelectStatement.execute(SQLStatement);

            ResultSet candidateData = SelectStatement.getResultSet();

            while (candidateData.next()) {
                CandidateDbo cdbo = new CandidateDbo();
                cdbo.connectToDB();
                int candidateId;
                candidateId = candidateData.getInt("CandidateId");
                candidatesInBallot.add(cdbo.getCandidateObjectById(candidateId));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return candidatesInBallot;

    }

    public boolean isBallotCreated() {
        String SQLStatement;
        Statement SelectStatement;
        try {
            SQLStatement = "select count(CandidateId) as BallotCount from ballot_Candidates";
            SelectStatement = conn.createStatement();
            SelectStatement.execute(SQLStatement);

            ResultSet ballotData = SelectStatement.getResultSet();

            while (ballotData.next()) {
                int ballotCount;
                ballotCount = ballotData.getInt("BallotCount");
                if (ballotCount > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

}
