package web;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import domain.User;

public class RegisterVerify extends ActionSupport{
    UserDao userDao = new UserDao();
     private User user = new User();
    public String register(){
        userDao.addUser(user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
