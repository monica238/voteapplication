/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voteapplication;

/**
 *
 * @author USER1
 */
public class VoterDbo 
{
     Voter connection;//DB Connection Object declaration
    
    
    public boolean connectToDB()
    {
        // Create DB Connection
        /* JDBC driver name and database url */
       static final String jdbc_driver="com.mysql.jdbc.driver";
       static final String db_url="jdbc:mysql://localhost";
    
  /* Database credentials */
     static final String USER= "username";
     static final String PASS= "password"; 
        // Check if connection is successful
     Connection conn=null;
     Statement stmt=null;
     try
      {
        /*Register JDBC driver*/
        Class.forName("com.mysql.jdbc.Driver");
        
        /* Open a connection */
    System.out.println("Connecting to database");
    conn=connectToDB.getConnection(db_url,USER,PASS);
      }
      // Return Success or Failure
      return true;
      catch(Exception e)
      {
          
      }
    
    /* 1. connectToDB() */
        System.out.println("Connecting to database");
      conn=connectToDB.getConnection(db_url,USER,PASS);
    // CRUD Operation
    
    public boolean createVoter(Voter voterInstance)
    {
        
        /* 2. Execure SQL Statement for Insert */
       INSERT INTO Voter(voterid,voterFname,voterLname,voterAge,voterLocation,voterAadharno);
       INSERT INTO Voter values(1001,damini,mv,23,mysore,234567891)
        /*3. Rerurn Success or Failure*/
    }
    
    public Voter getVoterObject(int voterId)
    {
        
        /* 2. Execure SQL Statement for Select */
        SELECT * FROM Voter;
        
       /* 3. Create VoterObject and Assign DB values to it */
        Voter voterobj=new voterobj();
        voterobj=
        /* 4. Rerurn Voter Object */
        return voterobj;
        
    }
    
    public boolean updateVoter(int voterId,Voter voterInstance)
    {
        /*
        1. connectToDB()
        3. Execure SQL Statement for Select
        4. Check if Voter ID is valid
        5. If Valid, Execure SQL Statement Update
        6. Return Success/Failure
        */
    }
    
    public boolean deleteVoter(int voterId)
    {
        /*
        1. connectToDB()
        3. Execure SQL Statement for Select
        4. Check if Voter ID is valid
        5. If Valid, Execure SQL Statement Delete
        6. Return Success/Failure
        */        
    }
    
}
