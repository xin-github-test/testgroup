package com.itheima.Dao.Impl;

import com.itheima.Dao.IUserDao;
import com.itheima.domain1.User;
import com.itheima.utils.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements IUserDao{
    QueryRunner qr =new QueryRunner(DBCPUtil.getDataSource());
    @Override
    public User selectUserByUsername(String username) throws SQLException {

        return qr.query("select * from user where username=?",new BeanHandler<User>(User.class),username);

    }

    @Override
    public int addUser(User user) throws SQLException {

       return qr.update("insert into user (username,password,birthday,hobby,married) values(?,?,?,?,?)",user.getUsername(),user.getPassword(),user.getBirthday(),user.getHobby(),user.isMarried());

    }
}
