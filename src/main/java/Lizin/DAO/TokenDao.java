package main.java.Lizin.DAO;



import main.java.Lizin.pojo.User;
import main.java.Lizin.pojo.Token;

import java.util.Date;

/**
 * Created by Ilya Evlampiev on 02.11.2015.
 */
public interface TokenDao {
    /**
     * Создает новую запись и соответствующий ей объект
     */
    public void create(Token token);

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    public Token readToken(String uuid);

     /**
     * Удаляет запись об объекте из базы данных
     */
    public void deleteUser(Token token);

    public void deleteToken(Token token);

    public void deleteToken(Date date);

    public User readUser(String uuid);
}
