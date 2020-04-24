package com.itheima.service.impl;

import com.itheima.Dao.IUserDao;
import com.itheima.Dao.Impl.UserDaoImpl;
import com.itheima.domain1.User;
import com.itheima.service.IUserService;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    private IUserDao dao=new UserDaoImpl();
    @Override
    public User findUserByUsername(String username) {
        try {
            return dao.selectUserByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int register(User user) {
        try {
            return dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
