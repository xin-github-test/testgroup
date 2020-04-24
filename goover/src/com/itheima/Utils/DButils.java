package com.itheima.Utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DButils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        username=rb.getString("username");
        password=rb.getString("password");

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }




    public static Connection getConnection ()throws Exception
    {
        return DriverManager.getConnection(url,username,password);
    }
    public static void closeAll(ResultSet rs, Statement stmt,Connection conn)
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
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn=null;
        }
    }

}
