package com.itheima.Dao.Impl;

import com.itheima.Dao.UserDao;
import com.itheima.Domain.User;
import com.itheima.Utils.DButils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) throws Exception {
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;

        try {
            conn=DButils.getConnection();
            ps=conn.prepareStatement("INSERT INTO USER (username,PASSWORD,email,birthday) VALUES(?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(1,user.getPassword());
            ps.setString(1,user.getEmail());
            SimpleDateFormat sdf=new SimpleDateFormat();
            String date = sdf.format(user.getBirthday());
            ps.setString(1,date);
            int i=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("添加失败");
        } finally {
            DButils.closeAll(rs,ps,conn);
        }
    }


}
