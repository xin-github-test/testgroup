package com.itheima.test;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * 详解cretiaria对象
 * 该对象与query对象很像，也可以控制查询
 */
public class cretiaria {

    @Test
    public void fun1()
    {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Hibernate独有的面向对象的查询（无语句）
        Criteria criteria = session.createCriteria(User.class);
        //设置查询条件使得返回一条结果,下面的语句就相当于查询name属性值为tom的值
        criteria.add(Restrictions.eq("name","tom"));

        //查询名字中含有 o的,value的值的形式和sql语句中差不多
        criteria.add(Restrictions.like("name","%o%"));

        //查找id大于1的用户,gt相当于大于的意思，小于是 lt 等于是 eq 大于等于：ge  小于等于：le
        criteria.add(Restrictions.gt("id",1));
      //执行查询并返回结果 （多行）
        List<User> list = criteria.list();

        //返回一个结果，使用该语句也需要变化一下的查询语句，但因为其无语句，所以就需要使用方法来变化
        User u = (User) criteria.uniqueResult();

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
