package com.itheima.DBUtils;

import com.mchange.v2.codegen.bean.Property;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtiles {
     private static DataSource ds=null;

     static{
         Properties property=new Properties();
         try {
             property.load(DBCPUtiles.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
             ds=BasicDataSourceFactory.createDataSource(property);
         } catch (Exception e) {
             throw new ExceptionInInitializerError("初始化错误，请检查配置文件！");

         }

     }
     public static DataSource getDataSource()
     {
     return ds;
     }

     public static Connection getConnection()
     {
         try {
             return ds.getConnection();
         } catch (SQLException e) {
             throw new RuntimeException("服务器繁忙！");

         }
     }
     public static void realse(Connection conn , Statement stmt, ResultSet rs)
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
