package com.itheima.product.service;

import com.itheima.product.dao.UserDao;
import com.itheima.product.domain.User;
import com.itheima.product.exception.UserException;
import com.itheima.product.utils.SendJMail;
import jdk.jshell.spi.ExecutionControl;

import java.sql.SQLException;

public class UserService {
    UserDao ud=new UserDao();
    public void regist(User user) throws UserException {
        try {
            ud.addUser(user);

            //添加成功就进行激活验证
            String emailMsg="注册成功，请<a href='http://192.168.137.1:8080/BookStore/activeServlet?activeCode="+user.getActiveCode()+"'>激活</a>后登陆!";
            SendJMail.sendMail(user.getEmail(),emailMsg);
        } catch (SQLException e) {
            e.printStackTrace();   //系统异常直接写入日志
            throw new UserException("注册失败！"); //自定义异常显示给用户，所以直接抛出去
        }
    }

    public void activeUser(String activeCode) throws UserException {
        User user= null;
        try {
            user = ud.findUserByActiveCode(activeCode);

        if(user!=null)
        {
            ud.activeCode(activeCode);
            return;
        }
        throw new UserException("激活失败!");  //如果没找到，就抛出异常
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("激活失败!"); //当语句执行时碰异常，也将该异常抛出
        }
    }

    public User login(String username, String password) throws UserException {
        User user=null;
        try {
            user=ud.findUserByUserNameAndPassword(username,password);
            if(user==null)
            {
                throw new UserException("用户名或密码错误！");

            }
            if(user.getState()==0)
            {
                throw  new UserException("用户未激活！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("用户名或密码错误！");
        }
        return user;
    }

    public User findUserById(String id) throws UserException {
        try {
            return ud.findUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("用户查找失败！");
        }

    }

    public void modifyUser(User user) throws UserException {
        try {
            ud.modifyUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("用户信息修改失败！");
        }
    }
}
