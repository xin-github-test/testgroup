package com.itheima.Service.Impl;

import com.itheima.Dao.Impl.UserDaoImpl;
import com.itheima.Dao.UserDao;
import com.itheima.Domain.User;
import com.itheima.Exception.UserExistException;
import com.itheima.Exception.UsersException;
import com.itheima.Service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public void register(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public User login(User user)throws UsersException {
        User u=null;
        try {
            u= userDao.findUser(user);
            if(u==null)
            {
                throw new UsersException("用户名或密码不正确！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean findUserByName(String username) throws UserExistException {
        boolean b= userDao.findUserByName(username);
        if(b)
        {
            throw new UserExistException("用户已存在!");//一旦存在用户，就将异常抛出去，等待捕获
        }
        return b;
    }
}
