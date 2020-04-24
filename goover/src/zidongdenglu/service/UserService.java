package zidongdenglu.service;

import zidongdenglu.Dao.UserDao;
import zidongdenglu.domain.User;

import java.sql.SQLException;

public class UserService {
    UserDao ud=new UserDao();

    public User findUser(String username, String password) {
        try {
            return  ud.findUser(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
