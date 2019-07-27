package voteapplication;
import java.io.DataInputStream;
import java.lang.Exception;

public class Voteapplication {
    public static void main(String[] args) {
        AdminRole admin=new AdminRole();
        VoterRole voter=new VoterRole();
        
        String adminUserName;
        String adminPassword;
        
        System.out.println("Enter Username and Password for Admin:");
        try
        {
        DataInputStream in=new DataInputStream(System.in);
        adminUserName=in.readLine();
        adminPassword=in.readLine();
        
        System.out.println(adminUserName+"-"+adminPassword);
        
        if(admin.validateAdminLogin(adminUserName, adminPassword)==true)
            System.out.println("Login Success");
        else
            System.out.println("Login Failure");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
       
                
        
        
    }
    
}
