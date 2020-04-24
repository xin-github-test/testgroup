package com.itheima.pool;

import com.itheima.Utils.DButils;
import com.itheima.datasource.MyConnection;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
    private static LinkedList<Connection> pool=(LinkedList<Connection>)Collections.synchronizedList(new LinkedList<Connection>());//通过collections中的方法给linkedlist加上线程锁
    static {
        try {
            for (int i = 0; i <10 ; i++) {
                Connection conn=DButils.getConnection();
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化数据库连接失败，请检查配置文件是否正确！");
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn=null;
        if(pool.size()>0)
        {
            conn= pool.removeFirst();//移除第一个并获得该对象
            Connection myConn = new MyConnection(conn, pool);//将conn进行装饰，修改其中的close方法
            return myConn;
        }else
        {
            //等待
            //解决方式：新创建一个连接,而这个连接用完之后直接close就行了
            throw new RuntimeException("服务器繁忙！");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
