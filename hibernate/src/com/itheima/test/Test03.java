package com.itheima.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;



/**
 * transaction对象
 */
public class Test03 {
    //transaction对象:封装了事务的操作
    //开启事务
    //提交事务
    //回滚事务
    @Test
    public void fun1()
    {
        Configuration conf= new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        //打开事务
        Transaction transaction = session.beginTransaction();

        //获得已经打开的事务对象（很少用）
        session.getTransaction();

        //Transaction 控制如何关闭事务
        //提交
        transaction.commit();
        //回滚
        transaction.rollback();
        session.close();
        sessionFactory.close();
    }

    //事务的细节
    @Test
    public void fun2()
    {
        Configuration conf= new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();

        //获得与当前线程绑定的session,事务关闭时，会自动把当前线程关联的session关闭，并删除
        Session session = sessionFactory.getCurrentSession();

           //测试两个session是否是同一个（在事务结束后，session会被关闭并删除，所以，后面获得的session是一个新的对象，如果没有这下面这句代码，则事务没有结束，则俩个session对象是一样的
           session.beginTransaction().commit();//开启事务并提交，结束事务

        Session session1 = sessionFactory.getCurrentSession();

        System.out.println(session==session1);



    }
}
