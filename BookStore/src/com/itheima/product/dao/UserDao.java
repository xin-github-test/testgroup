package com.itheima.product.dao;

import com.itheima.product.domain.User;
import com.itheima.product.utils.c3p0;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public void addUser(User user) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        String sql="insert into user(username,password,gender,email,telephone,introduce,activeCode,state,registtime)values(?,?,?,?,?,?,?,?,?)";
        qr.update(sql,user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRegistTime());
    }

    public User findUserByActiveCode(String activeCode) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        return  qr.query("select * from user where activecode=?",new BeanHandler<User>(User.class),activeCode);

    }

    public void activeCode(String activeCode) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        qr.update("update user set state=? where activecode=?",1,activeCode);
    }

    public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
       QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        return qr.query("select * from user where username=? and password=?",new BeanHandler<User>(User.class),username,password);


    }

    public User findUserById(String id) throws SQLException {

        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        return qr.query("select * from user where id=?",new BeanHandler<User>(User.class),id);
    }

    public void modifyUser(User user) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        qr.update("update user set password=?, gender=? ,telephone=? where id=?",user.getPassword(),user.getGender(),user.getId());
    }
}
