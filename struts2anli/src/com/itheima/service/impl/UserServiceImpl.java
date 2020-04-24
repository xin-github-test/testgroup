package com.itheima.service.impl;

import com.itheima.BeanFactory.BeanFactory;
import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
   //这样写的话，耦合度高，非常依赖daoImpl这个类，所以需要建立一个工厂类，替我们去得到dao这个对象
     //private IUserDao dao=new UserDaoImpl();
       private IUserDao dao= (IUserDao) BeanFactory.newInstance().getUserDao("USERDAO");
    @Override
    public User login(String logoName, String logoPwd) {
        return dao.selectUserByInfo(logoName,logoPwd);
    }

    @Override
    public int saveUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public int modifyUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public int removeUser(Integer userID) {
        return dao.deleteUser(userID);
    }

    @Override
    public User findUserById(Integer userID) {
        return dao.selectUserById(userID);
    }

    @Override
    public List<User> findAllUser() {
        return dao.selectAllUser();
    }

    @Override
    public List<User> findUserByCondition(String userName, String gender, String education, String isUpload) {
        return dao.selectUserByCondition(userName,gender,education,isUpload);
    }
}
