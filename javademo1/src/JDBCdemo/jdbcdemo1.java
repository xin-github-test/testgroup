package JDBCdemo;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

//使用jdbc实现查询数据库数据，并显示在控制台中
public class jdbcdemo1 {


    @Test//三个参数(实际常用）
    public void test1() throws Exception {
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 2.获取连接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "root");
        // 3.得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        // 4.执行sql语句并返回结果
        ResultSet rs = stmt.executeQuery("select * from student");
        // 5.处理结果
        while (rs.next()) {
            System.out.print("  " + rs.getObject(1));

            System.out.println("  " + rs.getObject(2));

            System.out.println("----------------");


        }

        // 6.关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }


    @Test //俩个参数

    public void test2() throws Exception {
    Properties info=new Properties();
    info.setProperty("user","root");
    info.setProperty("password","root");
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    // 2.获取连接Connection
   // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "root");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1",info);
    // 3.得到执行sql语句的对象Statement
    Statement stmt = conn.createStatement();
    // 4.执行sql语句并返回结果
    ResultSet rs = stmt.executeQuery("select * from student");
    // 5.处理结果
    while (rs.next())
    {
        System.out.print("  "  + rs.getObject(1) );

        System.out.println( "  "  +   rs.getObject(2) );

        System.out.println("----------------");


    }
    // 6.关闭资源
    rs.close();
    stmt.close();
    conn.close();
}

    @Test//一个参数

    public void test3() throws Exception
    {
        /*Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");*/
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接Connection
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "root");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1?user=root&password=root");
        // 3.得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        // 4.执行sql语句并返回结果
        ResultSet rs = stmt.executeQuery("select * from student");
        // 5.处理结果
        while (rs.next())
        {
            System.out.print("  "  + rs.getObject(1) );

            System.out.println( "  "  +   rs.getObject(2) );

            System.out.println("----------------");


        }
        // 6.关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }

}
