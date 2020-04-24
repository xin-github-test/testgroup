package com.itheima.Service.Impl;

import com.itheima.Dao.Impl.UserDaoImpl;
import com.itheima.Dao.UserDao;
import com.itheima.Domain.User;
import com.itheima.Service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public void register(User user) throws Exception {
        userDao.addUser(user);
    }
}
