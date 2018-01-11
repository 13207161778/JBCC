package com.lanou3g.category.web;

import com.lanou3g.book.dao.BookDao;
import com.lanou3g.book.domain.Book;
import com.lanou3g.util.BaseServlet;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/cate")
public class CategoryServlet extends BaseServlet {
    BookDao bookDao = new BookDao();

    public String findAllBook(HttpServletRequest request, HttpServletResponse response){

        List<Book> books = bookDao.showAllBook();
        request.setAttribute("books",books);
        //JSONArray jsonArray = JSONArray.fromObject(books);
//        HttpSession session = request.getSession();
//        session.setAttribute("books",books);
        try {
            request.getRequestDispatcher(request.getContextPath()+"/jsps/book/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "f:/jsps/book/list.jsp";
    }
    public String findSEBook(HttpServletRequest request, HttpServletResponse response){
        String book = request.getParameter("sebook");
        List<Book> books = bookDao.showBooks(book);
        request.setAttribute("SEbooks",books);
//        request.getSession().setAttribute("SEbooks",books);
//        request.getSession().setAttribute("sebook",book);
        try {
            request.getRequestDispatcher(request.getContextPath()+"/jsps/book/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "f:/jsps/book/list.jsp";
    }
    public String findEEBook(HttpServletRequest request, HttpServletResponse response){
        String book = request.getParameter("eebook");
        List<Book> books = bookDao.showBooks(book);
        request.setAttribute("EEbooks",books);
//        request.getSession().setAttribute("EEbooks",books);
//        request.getSession().setAttribute("eebook",book);
        try {
            request.getRequestDispatcher(request.getContextPath()+"/jsps/book/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "f:/jsps/book/list.jsp";

    }
    public String findJSBook(HttpServletRequest request, HttpServletResponse response){
        String book = request.getParameter("jsbook");
        List<Book> books = bookDao.showBooks(book);
        request.setAttribute("JSbooks",books);
        try {
            request.getRequestDispatcher(request.getContextPath()+"/jsps/book/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "f:/jsps/book/list.jsp";

    }
}
