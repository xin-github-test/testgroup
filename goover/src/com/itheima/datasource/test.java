package com.itheima.datasource;

import com.itheima.pool.MyDataSource;
import org.junit.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
    @Test
    public void test()
    {
        Connection conn=null;
        PreparedStatement ps=null;

        DataSource ds=new MyDataSource();
        try {
            conn = ds.getConnection();//从池中取出conn,此时的conn不是原来的conn了，而是装饰后的
            ps=conn.prepareStatement("");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();  //此时的conn中的close方法已经改写，所以不是直接关闭，而是将其返还到list中
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
