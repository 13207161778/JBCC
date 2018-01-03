package dao;

import utils.JDBCUtils;
import utils.JQueryUtils;

import java.sql.SQLException;


public class AddUser {

    public static int addUser(User user){
        int i = 0;
        try {
          i =   new JQueryUtils().update(JDBCUtils.getConnection(),"insert into user values(null,?,?,?)",user.getUsername(),user.getSex(),user.getUserpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


}
