package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        Connection conn;
        try {
          conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/usermessage","root","123");
     return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;

    }
}
