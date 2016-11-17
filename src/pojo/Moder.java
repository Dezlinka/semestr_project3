package pojo;

/**
 * Created by Данил on 15.11.2016.
 */
public class Moder extends User{


    public Moder() {
        super.setRole(UserTypes.MODER.toString());
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
