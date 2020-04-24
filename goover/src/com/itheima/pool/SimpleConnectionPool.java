package com.itheima.pool;

import com.itheima.Utils.DButils;

import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

//模拟数据库连接池，但不具备实际开发意义
public class SimpleConnectionPool {
    //创建一个存放连接的池子
    //LinkedList<Connection> pool=new LinkedList<>();//这样写的话就不具备线程安全
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
  public Connection getConnectionFromPool()
  {
      Connection conn=null;
      if(pool.size()>0)
      {
          conn= pool.removeFirst();//移除第一个并获得该对象
          return conn;
      }else
      {
          //等待
          //解决方式：新创建一个连接,而这个连接用完之后直接close就行了
          throw new RuntimeException("服务器繁忙！");
      }

  }
  //释方资源,将不用的连接放到list的最后一个
  public void release(Connection conn)
  {
      pool.addLast(conn);
  }

}
