package com.lanou3g.book.dao;

import com.lanou3g.book.domain.Book;
import com.lanou3g.util.JQuery;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.lanou3g.admin.JDBCUtils;
import java.sql.SQLException;
import java.util.List;

public class BookDao {

    public List<Book> showBooks(String bookname){
        List<Book> books = null;
        try {
            books = new JQuery().query(JDBCUtils.getConnection(),
                    "SELECT  b.* FROM category c\n" +
                            "  INNER JOIN book b ON c.cid = b.cid\n" +
                            "WHERE c.cname=?",
                    new BeanListHandler<Book>(Book.class),bookname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public List<Book> showAllBook(){
        List<Book> books = null;
        try {
             books= new JQuery().query(JDBCUtils.getConnection(),
                    "select * from book", new BeanListHandler<Book>(Book.class)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
   public Book showbook(String bname){
       Book book = null;
       try {
           book = new JQuery().query(JDBCUtils.getConnection(),
                   "select * from book where bname=?", new BeanHandler<Book>(Book.class), bname);
       } catch (SQLException e) {
           e.printStackTrace();
       }
      return book;
   }
    public Book showIDbook(String bid){
        Book book = null;
        try {
            book = new JQuery().query(JDBCUtils.getConnection(),
                    "select * from book where bid=?", new BeanHandler<Book>(Book.class), bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
   public int add(String iid , String count, double sub, String oid,String bid){
       int i = 0;
       try {
           i = new JQuery().update(JDBCUtils.getConnection(),
                   "insert into orderitem values(?,?,?,?,?)",
                   iid, count, sub, oid, bid);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return i;
      }
}
