package JDBCdemo;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class testCRUD {
    @Test  //sql语句最好在数据库中写好保证无错后再复制到java代码里面
    public void testInsert() throws Exception {
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
       int i=stmt.executeUpdate("INSERT INTO student  VALUES(5,'xaioh')");
         if(i>0)
         {
             System.out.println("s");
         }
       // 6.关闭资源
        //rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void testselect() {
        //加载驱动
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<student> list = null;//创建一个集合，因为数据库里面的一行就代表一个实体与java的一个类的一个实例相符，直接将数据封装在类里面


        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接Connection
            // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "root");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1?user=root&password=root");
            // 3.得到执行sql语句的对象Statement
            stmt = conn.createStatement();
            // 4.执行sql语句并返回结果
            rs = stmt.executeQuery("select * from student");
            list = new ArrayList<student>();
            while (rs.next()) {
                student stu = new student();//创建一个类的实例，将数据库中的数据存进去，然后将该类放入list集合中去
                stu.setStuid(rs.getInt("stuid"));
                stu.setStuname(rs.getString("stuname"));//循环完一次就将一行数据保存在一个类里面
                list.add(stu);    //将包含一行数据的类放入集合

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6.关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {

                    stmt.close();
                }
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }







        for (student stu:list)
        {
            System.out.println(stu.toString());
        }
    }
}
