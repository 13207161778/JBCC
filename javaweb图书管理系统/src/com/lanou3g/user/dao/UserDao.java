package com.lanou3g.user.dao;

import com.lanou3g.user.dimain.User;
import com.lanou3g.util.JQuery;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.lanou3g.admin.JDBCUtils;

import java.sql.SQLException;

public class UserDao {

    public int addUser(User user){

        int i = 0;
        try {
            i = new JQuery().update(JDBCUtils.getConnection(), "insert into user values(?,?,?,?,?,?)",
                    user.getUid(),user.getUsername(),user.getPASSWORD(),user.getEmail(),user.getCode(),user.getState());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int updateUser(String s,String user){
        int i = 0;
        try {
           i  = new JQuery().update(JDBCUtils.getConnection(),
                    "update user set state=?,uid=? where username=?","1", s,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return i;
    }
    public User findByUserName(String username){
        User user = null;
        try {
            user = new JQuery().query(JDBCUtils.getConnection(), "select * from user where username=?", new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User findByUserName(String password,String username){
        User user = null;
        try {
            user = new JQuery().query(JDBCUtils.getConnection(), "select * from user where PASSWORD=? and username =?", new BeanHandler<User>(User.class), password,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User findByUserEmail(String s){
        User user = null;
        try {
            user = new JQuery().query(JDBCUtils.getConnection(), "select * from user where email=?", new BeanHandler<User>(User.class), s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
