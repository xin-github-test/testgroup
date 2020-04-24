package com.itheima.product.utils;


import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {
    private static ThreadLocal<Connection> tl=new ThreadLocal<>();
    //用当前线程获取conn
    public static Connection getConnection()
    {
        Connection conn=tl.get();
        if(conn==null)
        {
            conn= c3p0.getConnection();
            tl.set(conn);
        }
        return conn;
    }
    //开启事务
    public static void startTransaction()
    {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public static void commitTransaction()
    {
        try {
            getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //回滚事务
    public static void rollbackTransaction()
    {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close()//将conn放回池中
    {
        try {
            getConnection().close();
            tl.remove();//将当前线程对象中的conn移除
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
