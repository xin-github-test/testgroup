package DBCP;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.imageio.stream.FileImageInputStream;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtil {
    private static DataSource ds=null;//得到一个数据源对象
    static
    {
         Properties prop=new Properties();
        try {
            prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));//加载配置文件
           ds= BasicDataSourceFactory.createDataSource(prop);//得到一个数据源
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化错误！请检查配置文件！");
        }
    }

    public static Connection getConnection()
    {
        try {
            return  ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("服务器繁忙！");
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
