package com.lanou3g.order.dao;

import com.lanou3g.book.domain.Book;
import com.lanou3g.order.domain.BookCount;
import com.lanou3g.order.domain.Order;
import com.lanou3g.order.domain.Orderitem;
import com.lanou3g.user.dimain.User;
import com.lanou3g.util.JQuery;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.lanou3g.admin.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {

    public int addOrder(String oid,String data ,User user, double sum,String address){
        int i = 0;
        try {
             i = new JQuery().update(JDBCUtils.getConnection(),
                    "insert into orders values(?,?,?,?,?,?)",
                    oid,data, sum,1, user.getUid(),address
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return i;
    }

    public List<Order> findOrders(){
        List<Order> query = null;
        try {
          query  = new JQuery().query(JDBCUtils.getConnection(),
                    "select * from orders",
                    new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return query;
    }

    public List<Orderitem> findOrderItem(){

        List<Orderitem> query = null;
        try {
            query  = new JQuery().query(JDBCUtils.getConnection(),
                    "select * from orderitem",
                    new BeanListHandler<Orderitem>(Orderitem.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
   public List<Book> findOrderBook(){
       List<Book> books = null;
       try {
           books = new JQuery().query(JDBCUtils.getConnection(),
                   "SELECT b.* FROM orderitem o\n" +
                           "INNER JOIN book b ON o.bid = b.bid",
                   new BeanListHandler<Book>(Book.class));
       } catch (SQLException e) {
           e.printStackTrace();
       }
   return books;
   }

    public List<BookCount> ordersBook(String str){
        List<BookCount> books = null;
        try {
           books  = new JQuery().query(JDBCUtils.getConnection(),
                    "SELECT b.*,r.COUNT,r.oid FROM orderitem r\n" +
                            "   INNER JOIN book b ON r.bid = b.bid\n" +
                            "WHERE r.oid=?", new BeanListHandler<BookCount>(BookCount.class), str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return books;

    }

    public List<Order> findorders(String uid){
        List<Order> orders = null;
        try {
            orders = new JQuery().query(JDBCUtils.getConnection(),
                    "SELECT * FROM orders where uid=?", new BeanListHandler<Order>(Order.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    public int updateState(String oid){
     int i = 0;
        try {
           i=  new JQuery().update(JDBCUtils.getConnection(),
                    "update orders set state=2 where oid=?",oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return i;
    }
    public int updateStates(String oid){
        int i = 0;
        try {
            i=  new JQuery().update(JDBCUtils.getConnection(),
                    "update orders set state=3 where oid=?",oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public Order queryState(String oid){
     Order order = null;
        try {
           order =   new JQuery().query(JDBCUtils.getConnection(),
                    "select * from orders where oid = ?",new BeanHandler<Order>(Order.class),
                    oid
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return order;
    }
}
