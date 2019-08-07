package voteapplication;
/**
 * @author Monica
 *@datecreated 27-Jul-2019
 */
/* Class definition to access admin login*/
public class Admin {
    private String adminUserName;
    private String adminPassword;
    
    Admin()
    {
        adminUserName="admin";
        adminPassword="password";
    }
    /* Method to validate admin login*/
    public boolean validateAdminLogin(String userName,String password)
    {
        if(this.adminUserName.compareTo(userName)==0 && this.adminPassword.compareTo(password)==0)
        {
            return true;
        }
        return false;
    }    
}
