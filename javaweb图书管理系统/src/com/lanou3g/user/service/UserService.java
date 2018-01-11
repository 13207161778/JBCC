package com.lanou3g.user.service;

import com.lanou3g.user.dao.UserDao;
import com.lanou3g.user.dimain.User;
import com.lanou3g.user.service.exception.DuplicationEmailException;
import com.lanou3g.user.service.exception.DuplicationException;

public class UserService {
private UserDao userDao = new UserDao();
    public User byUser(String string){

        User coide = userDao.findByUserName(string);
        if (coide != null){
            try {
                throw new DuplicationException();
            } catch (DuplicationException e) {
                e.printStackTrace();
            }

        }
        return coide;
    }
    public User byUserEmail(String s){
        User coide = userDao.findByUserName(s);
        if (coide != null){
            try {
                throw new DuplicationEmailException();
            } catch (DuplicationEmailException e) {
                e.printStackTrace();
            }

        }
        return coide;
    }
}
