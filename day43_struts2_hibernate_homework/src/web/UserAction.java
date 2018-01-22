package web;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import domain.User;
import org.apache.struts2.ServletActionContext;
import service.UserService;

public class UserAction extends ActionSupport{
    private User user = new User();
    private String username;
    private String password;

    private UserService userService  = new UserService();
    private UserDao userDao = new UserDao();

    public String loginbefore(){

        ServletActionContext.getContext().getSession().put("username",username);
        ServletActionContext.getContext().getSession().put("password",password);

        return SUCCESS;
    }

    public String loginafter(){
         ServletActionContext.getRequest().setAttribute("users",userService.findAll());

        if (username.equals("zhangsan")&& password.equals("123")){
            return "success";
        }
        return LOGIN;
    }
//    public String adduser(){
//        userDao.addUser(user);
//        return SUCCESS;
//    }
    public String findAll(){
        System.out.println(userDao.all());
        ServletActionContext.getRequest().setAttribute("findusers",userDao.all());
        return SUCCESS;
    }
      public String edit(){

          String name1 = ServletActionContext.getRequest().getParameter("name1");
          User user = userDao.finduser(name1);
          ServletActionContext.getRequest().setAttribute("edit",user);
          return SUCCESS;
      }
      public String submitEdit(){

        userDao.update(user);

          return SUCCESS;
      }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
