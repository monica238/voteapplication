/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voteapplication;

import java.sql.*;
import org.apache.log4j.*;

/**
 *
 * @author USER1
 */
public class AdminDbo {
    
    private Connection conn;
    private Logger applog;
    
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
        
    public boolean authenticateAdmin(String username,String password)
    {
        Statement SQLStatement;
        try
        {
        SQLStatement=conn.createStatement();
        ResultSet rs=SQLStatement.executeQuery("select * from Authentication where username='"+username+"' and password='"+password+"'");        
        
        if (rs.next())    
            return true;
        }
        catch (Exception e)
        {
            applog.error(e);
        }
        closeDbConnection();
        return false;
    
    }
    
}
