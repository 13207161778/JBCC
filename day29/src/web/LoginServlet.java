package web;

import dao.Decide;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             req.setCharacterEncoding("utf-8");
            String username  =   req.getParameter("username");
            String userpassword = req.getParameter("userpassword");
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("userpassword",userpassword);
        User user = null;
        try {
           user  = Decide.decide(username,userpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

            if (user != null){

            resp.sendRedirect("http://localhost:8080/index.jsp");
            }else {
                resp.sendRedirect("http://localhost:8080/Login.jsp");
            }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        session.removeAttribute("userpassword");
        resp.sendRedirect("/Login.jsp");
    }
}
