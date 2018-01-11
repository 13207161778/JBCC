package com.lanou3g.cart.web;


import com.lanou3g.book.dao.BookDao;
import com.lanou3g.book.domain.Book;
import com.lanou3g.cart.domain.CartItem;
import com.lanou3g.order.dao.OrderDao;
import com.lanou3g.user.dao.UserDao;
import com.lanou3g.user.dimain.User;
import com.lanou3g.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    BookDao bookDao = new BookDao();
    UserDao userDao = new UserDao();
    OrderDao orderDao = new OrderDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //随机生成OID
        String oid = UUID.randomUUID().toString();
        String[] split = oid.split("-");
        String s = split[0];
        //随机生成IID
        String iid = UUID.randomUUID().toString();
        String[] split1 = iid.split("-");
        String s1 = split1[0];
        //得到提交上来的书本数量
        String count = request.getParameter("count");
        int i = Integer.parseInt(count);
        request.setAttribute("count",count);
        //获得登录时用户名,查询该用户
        Object a = request.getSession().getAttribute("a");
        String uname = a.toString();
        User user = userDao.findByUserName(uname);
        //获得提交时保存在session中的book
        Object id = request.getSession().getAttribute("bk");
        String bid =  id.toString();
        char[] chars = bid.toCharArray();
        String c = String.valueOf(chars[1]);
        Book book = bookDao.showIDbook(c);
         //得到书的价格，和总价
        String price = book.getPrice();
       double d = Double.parseDouble(price);
       double sum = i * d;
       //获得添加到购物车额时间
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = dateFormat.format(date);
        //将该数保存到orders表中
//        orderDao.addOrder(s,format,user,book);
//        Order order = orderDao.findOrder(s);
//        bookDao.add(s1,count,sum,order.getOid(),book.getBid());
        //将一个CartItem对象保存到map中，将map保存到session中
//        List<Cart> cartBook = orderDao.findAllCartBook();
//        request.getSession().setAttribute("cart",cartBook);
         CartItem cartItem = new CartItem(book,count);
        List<CartItem> list = new ArrayList<>();
        list.add(cartItem);
        request.getSession().setAttribute("cart",list);
        response.sendRedirect(request.getContextPath()+"/jsps/cart/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String addCart(HttpServletRequest request,HttpServletResponse response){
        List<CartItem> list = (List<CartItem>) request.getSession().getAttribute("car");
        String count = request.getParameter("count");
        Object bk = request.getSession().getAttribute("bk");
        String bid =  bk.toString();
        char[] chars = bid.toCharArray();
        String c = String.valueOf(chars[1]);
        Book book = bookDao.showIDbook(c);
        System.out.println(book);

        CartItem cartItem = new CartItem(book,count);
        list.add(cartItem);
        request.getSession().setAttribute("cart",list);


        return "f:/jsps/cart/list.jsp";

    }
    public String remove(HttpServletRequest request ,HttpServletResponse response){
        String bname = request.getParameter("bname");
       List<CartItem> list = (List<CartItem>) request.getSession().getAttribute("cart");
        for (int i = 0;i<list.size();i++){

            CartItem item = list.get(i);
            if (bname.equals(item.getBook().getBname())){
                list.remove(item);
            }
        }
        return "f:/jsps/cart/list.jsp";
    }
    public String removeAll(HttpServletRequest request,HttpServletResponse response){
        List<CartItem> list = (List<CartItem>) request.getSession().getAttribute("cart");

            list.clear();

        return "f:/jsps/cart/list.jsp";
    }
}
