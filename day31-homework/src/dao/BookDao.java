package dao;

import bean.Book;
import utils.JDBCUtils;
import utils.JQueryUtils;

import java.sql.SQLException;

public class BookDao {

    public static void addBook(Book book){
        try {
            new JQueryUtils().update(JDBCUtils.getConnection(),"insert into book values(null,?,?,?)",book.getBname(),book.getAutor(),book.getPay());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
