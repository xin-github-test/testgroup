package com.itheima.Dao.Impl;

import com.itheima.Dao.UserDao;
import com.itheima.Domain.User;
import com.itheima.Utils.DButils;


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
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(user.getBirthday());
            ps.setString(4,date);
            int i=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("添加失败");
        } finally {
            DButils.closeAll(rs,ps,conn);
        }
    }

    @Override
    public User findUser(User user) throws Exception {
       Connection conn=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       User u=null;

        try {
            conn=DButils.getConnection();
            ps=conn.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            if(rs.next())
            {
                u=new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButils.closeAll(rs,ps,conn);
        }


        return u;
    }
    public boolean findUserByName(String username)
    {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try
        {
            conn=DButils.getConnection();
            ps=conn.prepareStatement("select * from user where username=?");
            ps.setString(1,username);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            DButils.closeAll(rs,ps,conn);
        }
        return  false;
    }

}
