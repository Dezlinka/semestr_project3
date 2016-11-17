package servlets;

import DAO.DaoFactory;
import DAO.TokenDao;
import pojo.Lizin;
import pojo.Token;
import pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import DAO.UserDAO;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    static UserDAO userDao = DaoFactory.getDAOFactory(1).getUserDao();
    static TokenDao tokenDao = DaoFactory.getDAOFactory(1).getTokenDao();

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User newUser = new Lizin();

        newUser.setUsername(req.getParameter("username"));
        newUser.setPassword(req.getParameter("password"));

        try {
            userDao.createUser(newUser);
            newUser = userDao.read(newUser.getUsername());
            Token tk = new Token();
            tk.setUuid(java.util.UUID.randomUUID().toString());
            tk.setUser(newUser);
            tokenDao.create(tk);

            getServletContext().getRequestDispatcher("/userCreated.jsp").forward(req, resp);
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        processRequest(req, resp);
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
        dispatcher.forward(req, resp);




    }
}
