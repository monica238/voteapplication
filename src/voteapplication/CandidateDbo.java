package voteapplication;

/**
 *
 * @author KING
 */
public class CandidateDbo 
{
    Candidate connection;//DB Connection Object declaration
    
    
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
    
    public boolean createCandidate(Candidate candidateInstance)
    {
        
        /* 2. Execure SQL Statement for Insert */
       INSERT INTO Candidate(candidateId,candidateFirstname,age,city,candidateParty);
       INSERT INTO Candidate values(1001,damini,mv,23,mysore,234567891)
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
