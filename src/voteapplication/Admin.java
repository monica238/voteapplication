package voteapplication;

/**
 * @author Monica
 * @datecreated 27-Jul-2019
 */
/* Class definition to access admin login*/
public class Admin {
    private AdminDbo ado;

    /* Method to validate admin login*/
    public boolean validateAdminLogin(String userName, String password) {
        ado = new AdminDbo();
        ado.connectToDB();
        return ado.authenticateAdmin(userName, password);
    }
}
