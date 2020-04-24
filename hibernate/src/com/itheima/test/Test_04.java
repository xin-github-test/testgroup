package com.itheima.test;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.List;

/**
 * 详解Query对象
 */
public class Test_04 {
    //query对象：封装HQL语句的对象
    //query中封装查询细节api
    @Test
    public void fun1()
    {
        Configuration conf= new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       /* Query query = session.createQuery("from com.itheima.test.User");

        //query,list(),将ql语句执行并返回结果（多行）
        List<User> list=query.list();*/
        //该方法返回一条结果，相应的前面的查询语句也需要改变(不改变也行，就直接返回多行结果中的第一行）
        Query query = session.createQuery("from com.itheima.test.User where name='tom'");
         User u = (User) query.uniqueResult();

         //分页：sql:limit index,count;
        //指定结果从第几个开始拿 相当于index
        query.setFirstResult(0);
        //指定拿几个 相当于count
        query.setMaxResults(2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
