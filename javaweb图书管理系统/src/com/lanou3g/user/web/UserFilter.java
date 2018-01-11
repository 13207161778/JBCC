package com.lanou3g.user.web;

import com.lanou3g.user.service.exception.NotLoginException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserFilter",urlPatterns = "/jsps/main.jsp")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        Object password = session.getAttribute("password");
        if (username != null  && password != null){
            chain.doFilter(req, resp);
        }else {
            try {
                throw new NotLoginException();
            } catch (NotLoginException e) {
                e.printStackTrace();
            }
            response.sendRedirect(request.getContextPath()+"/jsps/user/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
