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
    //DB Connection Object declaration
    
    public boolean connectToDB()
    {
        // Create DB Connection
        // Check if connection is successful
        // Return Success or Failure
    }
    
    // CRUD Operation
    
    public boolean createVoter(VoterRole voterInstance)
    {
        /*
        1. connectToDB()
        3. Execure SQL Statement for Insert
        4. Rerurn Success or Failure
        */
    }
    
    public VoterRole getVoterObject(int voterId)
    {
        /*
        1. connectToDB()
        3. Execure SQL Statement for Select
        4. Create VoterObject and Assign DB values to it
        5. Rerurn Voter Object
        */
        
    }
    
    public boolean updateVoter(int voterId,VoterRole voterInstance)
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
