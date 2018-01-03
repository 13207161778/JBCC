package servlet;

import dao.Decide;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username  =   req.getParameter("username");
            String userpassword = req.getParameter("userpassword");

        getServletContext().setAttribute("username",username);
        boolean b = false;
        try {
          b =  Decide.decide(username,userpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
        if (b){
            resp.sendRedirect("http://localhost:8080/index.jsp");
        }else {
            resp.sendRedirect("http://localhost:8080/Login.html");
        }
    }
}
