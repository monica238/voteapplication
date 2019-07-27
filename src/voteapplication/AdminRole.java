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
public class AdminRole {
    private String adminUserName;
    private String adminPassword;
    
    AdminRole()
    {
        adminUserName="admin";
        adminPassword="password";
    }
    
    public boolean validateAdminLogin(String userName,String password)
    {
        if(this.adminUserName.compareTo(userName)==0 && this.adminPassword.compareTo(password)==0)
        {
            return true;
        }
        return false;
    }    
}
