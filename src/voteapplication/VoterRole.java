/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voteapplication;

/**
 *
 * @author Monica
 * @datecreated 27-Jul-2019
 */

/*
Class definition to accept Voter profile details
*/

public class VoterRole {
    private int voterId; 
    private String voterFname;
    private String voterLname;
    private String voterLocation;
    private int voterAge;
    
    /*
    Method to register voter into database
    */
    public void registerVoterDetails(int id, String fname, String lname, String location, int age)
    {
        voterId=id;
        voterFname=fname;
        voterLname=lname;
        voterLocation=location;
        voterAge=age;
    }
    
    /*
    Method to retrieve voter profile details
    format of retrival: ID | FNAME | LNAME | LOCATION | AGE
    */
    public String showVoterDetails()
    {
        return voterId +"|"+ voterFname +"|"+ voterLname +"|"+ voterLocation +"|"+ voterAge;
    }
}
