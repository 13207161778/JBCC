package servlet;

import dao.AddUser;
import dao.Decide;
import dao.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddUserSlrvlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setSex(req.getParameter("sex"));
        user.setUserpassword(req.getParameter("userpassword"));
        Boolean b = null;
        try {
            b = Decide.decide(user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(b){
           resp.sendRedirect("http://localhost:8080/register.html");
       }else {
            AddUser.addUser(user);
           resp.sendRedirect("http://localhost:8080/Login.html");
       }

    }
}
