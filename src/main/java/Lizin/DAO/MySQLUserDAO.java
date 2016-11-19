package main.java.Lizin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQLUserDAO extends MySqlDao implements UserDAO {

    @Override
    public void createUser(User user) {

        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("INSERT INTO users " + "(username, password)" + "VALUES( ?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteUser(User user) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("DELETE FROM users WHERE id =  ?");
            stmt.setInt(1, user.getDatabaseId());

            stmt.execute();
            //log.trace("Addition to notes by user " + note.getUser().getUsername());
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //log.error("Addition of new comment failed " + e.getLocalizedMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User read(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? and password = ?";
        User s = null;
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserTypes e = UserTypes.valueOf(rs.getString("role"));
                switch (e) {
                    case ADMIN:
                        s = new Admin();
                        break;
                    case MODER:
                        s = new Moder();
                        break;
                    case LIZIN:
                        s = new Lizin();
                        break;
                }


                s.setDatabaseId(rs.getInt("id"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getString("role"));
            } else {
                s = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return s;
    }

    @Override
    public User read(String login) {
        String sql = "SELECT * FROM users WHERE username = ?";
        User s = null;
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserTypes e = UserTypes.valueOf(rs.getString("role"));
                switch (e) {
                    case ADMIN:
                        s = new Admin();
                        break;
                    case MODER:
                        s = new Moder();
                        break;
                    case LIZIN:
                        s = new Lizin();
                        break;
                }

                s.setDatabaseId(rs.getInt("id"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getString("role"));
            } else {
                s = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return s;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUser(int userId) {
        return null;
    }
}
