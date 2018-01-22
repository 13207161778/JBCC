package dao;

import com.lanou3g.util.HibernateUtil;
import domain.User;
import org.hibernate.Query;
import org.junit.Test;

import java.util.List;

public class UserDao {

    public List<User> all(){

        List<User> users = HibernateUtil.handler(session -> {
            Query query = session.createQuery("from " + User.class.getName());
            List<User> list = query.list();
            return list;

        });
        return users;
    }

    public void addUser(User user){

        HibernateUtil.handler(session -> {
            session.save(user);
             return null;
        });


    }
        public User finduser(String sid){

            User user1 = HibernateUtil.handler(session -> {
                String sql = "from User where uid=?";
                Query uid = session.createQuery(sql).setString(0, sid);
                User user = (User) uid.uniqueResult();

                return user;
            });
            return user1;
        }

        public void update(User user){
            HibernateUtil.handler(session -> {
                User user1 = session.get(User.class, user.getUid());
                user1.setUname(user.getUname());
                user1.setAge(user.getAge());
                user1.setDepartment(user.getDepartment());
                user1.setTime(user.getTime());
                user1.setAdderss(user.getAdderss());
                user1.setPhone(user.getPhone());
                session.update(user1);
                return null;
            });
        }
}
