package main.java.pojo;

/**
 * Created by Ilya Evlampiev on 20.10.2015.
 */
public class Lizin extends User {

    public Lizin() {
        super.setRole(UserTypes.LIZIN.toString());
    }


    @Override
    public boolean isModer() {
        return false;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }
}
