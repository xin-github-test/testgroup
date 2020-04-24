package JDBCdemo;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    private static String driverclass;
    private static String url;
    private static String username;
    private static String password;//将这些变量的值放入配置文件里面，方便后期修改（dbinfo.propertities)

    static{
        ResourceBundle rb=ResourceBundle.getBundle("dbinfo");//加载配置文件
        driverclass= rb.getString("driverclass");
        url=rb.getString("url");
        username=rb.getString("username");
        password=rb.getString("password");
        try {
            Class.forName(driverclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }//加载驱动
    }//通过静态代码块将变量直接赋初值
    public static Connection getConnections() throws Exception {

        return DriverManager.getConnection(url,username,password);
    }
    public static void closeAll(ResultSet rs, Statement stmt,Connection conn)
    {
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

    }

