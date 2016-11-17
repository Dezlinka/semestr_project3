package DAO;

import pojo.User;

/**
 * Created by Данил on 14.11.2016.
 */
public interface UserDAO {

    void createUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUser(int userId);

    User read(String login, String password);

    User read(String login);
}
