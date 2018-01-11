package com.lanou3g.order.web;

import com.lanou3g.book.dao.BookDao;
import com.lanou3g.book.domain.Book;
import com.lanou3g.cart.domain.CartItem;
import com.lanou3g.order.dao.OrderDao;
import com.lanou3g.order.domain.*;
import com.lanou3g.order.service.exception.NotPayException;
import com.lanou3g.user.dao.UserDao;
import com.lanou3g.user.dimain.User;
import com.lanou3g.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet (name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet{
 UserDao userDao = new UserDao();
OrderDao orderDao =new OrderDao();
BookDao bookDao = new BookDao();



    public  String addOrder(HttpServletRequest request, HttpServletResponse response){
        Object money = request.getSession().getAttribute("money");
         request.getSession().setAttribute("money",money);
        //获得添加到购物车额时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        request.getSession().setAttribute("time",format);

       String d1 = UUID.randomUUID().toString();
        String[] split = d1.split("-");
        String s = split[4];
        request.getSession().setAttribute("d",s);

        String str =  request.getSession().getAttribute("a").toString();
        User name = userDao.findByUserName(str);
        Object cart = request.getSession().getAttribute("cart");
        List<CartItem> list = (List<CartItem>) cart;
        request.getSession().setAttribute("cart",list);
//        Book book = null;
//        String count = null;
//        for (int i = 0; i < list.size(); i++) {
//            String string = UUID.randomUUID().toString();
//            String[] split = string.split("-");
//            String oid = split[0];
//
//            String id = UUID.randomUUID().toString();
//            String[] split1 = id.split("-");
//            String iid = split1[0];
//            CartItem item = list.get(i);
//             book = item.getBook();
//             count = item.getCount();
//            orderDao.addOrder(oid,format,name,book);
//            String price = book.getPrice();
//            double d = Double.parseDouble(price);
//            int j = Integer.parseInt(count);
//            double sum = j * d;
//            bookDao.add(iid,count,sum,oid,book.getBid());
//        }
//        List<Order> orders = orderDao.findOrders();
//        List<Orderitem> orderItem = orderDao.findOrderItem();
//        List<Book> books = orderDao.findOrderBook();
//        request.getSession().setAttribute("orders",orders);
//        request.getSession().setAttribute("orderitem",orderItem);
//        request.getSession().setAttribute("books",books);
        return "f:/jsps/order/desc.jsp";
    }
    public String showMyOrder(HttpServletRequest request,HttpServletResponse response){
        String a = request.getSession().getAttribute("a").toString();
        User user = userDao.findByUserName(a);
        String address = request.getParameter("address");
        String d = request.getSession().getAttribute("d").toString();
        String time = request.getSession().getAttribute("time").toString();
        double money = (Double)request.getSession().getAttribute("money");

        Object cart = request.getSession().getAttribute("cart");
        List<CartItem> list = (List<CartItem>) cart;

        orderDao.addOrder(d,time,user,money,address);
        Book book = null;
        for (int i = 0; i < list.size(); i++) {
            CartItem item = list.get(i);
            String count = item.getCount();
            book = item.getBook();

            //随机生成IID
            String iid = UUID.randomUUID().toString();
            String[] split1 = iid.split("-");
            String s1 = split1[0];

            String price = book.getPrice();
            double p  = Double.parseDouble(price);
            int j = Integer.parseInt(count);
            double dd = p * j;
            bookDao.add(s1,count,dd,d,book.getBid());
        }

        OrderPage orderPage = new OrderPage(d,time,money,list,address);
        request.getSession().setAttribute("ord",orderPage);

        return "f:/jsps/order/list.jsp";
    }
    public String myOrders(HttpServletRequest request,HttpServletResponse response){

        String a = request.getSession().getAttribute("a").toString();
        User user = userDao.findByUserName(a);
        List<Order> orders = orderDao.findorders(user.getUid());
        List<List<BookCount>> bookCounts = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            Order order  = orders.get(i);
            List<BookCount> counts = orderDao.ordersBook(order.getOid());
            bookCounts.add(counts);
        }

        request.getSession().setAttribute("boks",bookCounts);
        request.getSession().setAttribute("order",orders);


        return "r:/jsps/order/list.jsp";
    }
    public String load(HttpServletRequest request,HttpServletResponse response){

        String ooid = request.getParameter("ooid");
        String ootime = request.getParameter("ootime");
        String ooprice = request.getParameter("ooprice");
        List<BookCount> bookCounts = orderDao.ordersBook(ooid);
        request.getSession().setAttribute("bookCounts",bookCounts);
        request.getSession().setAttribute("ootime",ootime);
        request.getSession().setAttribute("ooprice",ooprice);
        request.getSession().setAttribute("ooid",ooid);
        return "f:/jsps/order/desc.jsp";
    }

    public String payMent(HttpServletRequest request,HttpServletResponse response){

      String s  =  request.getParameter("oid");
         orderDao.updateState(s);

        return "f:/jsps/order/list.jsp";
    }

    public String affrim(HttpServletRequest request,HttpServletResponse response){

        String oooid = request.getParameter("oooid");
        Order order = orderDao.queryState(oooid);
        if (order.getState().equals("1")){
            try {
                throw new NotPayException();
            } catch (NotPayException e) {
                e.printStackTrace();
            }
            return "f:/jsps/order/list.jsp";
        }
        if (order.getState().equals("2")){

            orderDao.updateStates(oooid);
        }
        List<BookCount> bookCounts = orderDao.ordersBook(oooid);
      request.getSession().setAttribute("id",oooid);
       request.getSession().setAttribute("bcs",bookCounts);
        return "f:/jsps/order/msg.jsp";
    }

}
