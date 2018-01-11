package com.lanou3g.book.web;

import com.lanou3g.book.dao.BookDao;
import com.lanou3g.book.domain.Book;
import com.lanou3g.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BookServlet",urlPatterns ="/book")
public class BookServlet extends BaseServlet {
   private BookDao bookDao = new BookDao();
   public String showBook(HttpServletRequest request, HttpServletResponse response){
       String bname = request.getParameter("bname");
       System.out.println(bname);
       Book book = bookDao.showbook(bname);
       request.getSession().setAttribute("book",book);
       return "f:/jsps/book/desc.jsp";
   }

}
