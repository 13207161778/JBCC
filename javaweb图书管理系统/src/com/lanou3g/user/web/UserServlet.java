package com.lanou3g.user.web;

import com.lanou3g.cart.domain.CartItem;
import com.lanou3g.user.dao.UserDao;
import com.lanou3g.user.dimain.User;
import com.lanou3g.user.service.UserService;
import com.lanou3g.user.service.exception.*;
import com.lanou3g.util.BaseServlet;
import com.lanou3g.util.JavaMailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    UserService us = new UserService();
    UserDao ud = new UserDao();
    User user = new User();
    JavaMailUtil javaMailUtil = new JavaMailUtil();

    public String login(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<CartItem> list = new ArrayList<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        session.setAttribute("username",username);
        session.setAttribute("a",username);
        session.setAttribute("password",password);
        session.setAttribute("car",list);
        User byUser = ud.findByUserName(username);
        if (byUser==null){
            try {
                throw new WrongUsernameException();
            } catch (WrongUsernameException e) {
                e.printStackTrace();
            }
            try {
                request.getRequestDispatcher(request.getContextPath()+"/jsps/user/login.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (ud.findByUserName(password,username)==null){
            try {
                throw new WrongUserException();
            } catch (WrongUserException e) {
                e.printStackTrace();
            }
            try {
                request.getRequestDispatcher(request.getContextPath()+"/jsps/user/login.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (byUser.getState().equals("0")){
            try {
                throw new CokeyException();
            } catch (CokeyException e) {
                e.printStackTrace();
            }
            try {
                request.getRequestDispatcher(request.getContextPath()+"/jsps/user/login.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "r:/jsps/main.jsp";

    }
public String register(HttpServletRequest request,HttpServletResponse response){
        getServletContext().setAttribute("i",0);
   String code = UUID.randomUUID().toString();
    String[] split = code.split("-");
    String s1 = split[0];
    String email = request.getParameter("email");
    user.setEmail(email);
    user.setUsername(request.getParameter("username"));
    user.setPASSWORD(request.getParameter("password"));
    user.setUid(s1);
    user.setCode(code);
    user.setState("0");
      if (ud.findByUserName(user.getUsername())!=null){
          try {
              throw new DuplicationException();
          } catch (DuplicationException e) {
              e.printStackTrace();
          }
          try {
              response.sendRedirect(request.getContextPath()+"/jsps/user/regist.jsp");
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      if (ud.findByUserEmail(user.getEmail())!=null){
          try {
              throw new DuplicationEmailException();
          } catch (DuplicationEmailException e) {
              e.printStackTrace();
          }
          try {
              response.sendRedirect(request.getContextPath()+"/jsps/user/regist.jsp");
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      ud.addUser(user);
    try {
        new JavaMailUtil().t1(user.getEmail());
    } catch (MessagingException e) {
        e.printStackTrace();
    }

    return "f:jsps/msg.jsp";
   }
      public String active(HttpServletRequest request ,HttpServletResponse response){
          ud.updateUser(user.getUid(),user.getUsername());
          return "r:jsps/msg.jsp";
      }

}
