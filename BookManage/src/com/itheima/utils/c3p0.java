package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class c3p0 {
   //private static ComboPooledDataSource dataSource = new ComboPooledDataSource();//此处不能用DataSource接受，因为DataSource中没有下面的配置文件的方法
    //如果在xml里面配置的话，就可以用DataSource来接受
    private static DataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource()
    {
        return dataSource;
    }
    public static Connection getConnection()
      {
          try {
              return dataSource.getConnection();
          } catch (SQLException e) {
              throw new RuntimeException("服务器繁忙!");
          }
      }
    public static void release(Connection conn , Statement stmt, ResultSet rs)
    {
        if(rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs=null;
        }
        if(stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt=null;
        }
        if(conn!=null)
        {
            try {
                conn.close(); //这里的关闭并不是真的关闭，而是将器放回连接池，若不是连接池中的conn就关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn=null;
        }
    }
}
