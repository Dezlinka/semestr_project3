package main.java.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDao {

    Connection getConnection()
    {
        try {
            return DaoFactory.getDAOFactory(1).getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
