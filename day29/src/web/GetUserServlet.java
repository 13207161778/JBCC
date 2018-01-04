package web;

import dao.Decide;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GetUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object username = getServletContext().getAttribute("username");
//        String user = (String)username;
        Object userpassword = getServletContext().getAttribute("userpassword");
//        String paaword = (String)userpassword;
        System.out.println(username+"  "+userpassword);
        try {
            resp.getWriter().write(Decide.decide(username,userpassword).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
