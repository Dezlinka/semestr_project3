package DAO;



import java.sql.Connection;
import java.sql.SQLException;


public abstract class DaoFactory {

    public static final int MYSQL = 1;

    public static DaoFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case MYSQL:
                return new MySQLDaoFactory();
            default           :
                return null;
        }
    }

    public abstract Connection getConnection() throws SQLException;

    public abstract UserDAO getUserDao();

    public abstract TokenDao getTokenDao();


}
