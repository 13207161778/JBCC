package service;

import dao.UserDao;
import domain.User;

import java.util.List;

public class UserService {
   private UserDao userDao = new UserDao();

   public List<User> findAll(){

       List<User> users = userDao.all();
       if (users==null){
           return null;
       }

       return users;

   }

}
