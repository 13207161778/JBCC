package dao;

import bean.Book;
import bean.User;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.JDBCUtils;
import utils.JQueryUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Decide {
    public static boolean decide( String user) throws SQLException {
        List<Map<String,Object>> lists= new JQueryUtils().query(JDBCUtils.getConnection(),"select * from user",new MapListHandler());
        for (int i = 0; i <lists.size() ; i++) {
            Map<String,Object> map = lists.get(i);
            for ( Map.Entry entry:map.entrySet()) {
                if(entry.getKey().equals("username") && entry.getValue().equals(user)){
                    return true;
                }
            }
        }
        return false;
    }
    public static User decide(Object user, Object password) throws SQLException {


        User query = new JQueryUtils().query(JDBCUtils.getConnection(),
                "select * from user where username=? and userpassword=?",
                new BeanHandler<User>(User.class), user, password);
        JSONObject jsonObject = JSONObject.fromObject(query);
      User user1  =  (User) JSONObject.toBean(jsonObject,User.class);
        return user1;

    }
    public static List<Book> decide(){
        List<Book> query = null;
        try {
           query  = new JQueryUtils().query(JDBCUtils.getConnection(), "select * from book", new BeanListHandler<Book>(Book.class));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

}
