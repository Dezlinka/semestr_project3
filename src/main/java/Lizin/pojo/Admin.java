package main.java.Lizin.pojo;

/**
 * Created by Данил on 15.11.2016.
 */
public class Admin extends User {

    public Admin() {
        super.setRole(UserTypes.ADMIN.toString());
    }


    @Override
    public boolean isModer() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }
}
