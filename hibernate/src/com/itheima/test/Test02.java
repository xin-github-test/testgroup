package com.itheima.test;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * 详解SessionFactory 创建session的工厂
 */

public class Test02 {
    @Test
    public void fun1()
    {
        //1.加载配置
        Configuration conf = new Configuration().configure();
        //2.根据Configuration 配置信息创建SessionFactory
        SessionFactory sf= conf.buildSessionFactory();
        //3.获取session
         //3.1 openSession()是获取一个全新的session对象
         sf.openSession();
         //3.2 getCurrentSession:获取与当前线程绑定的session，使用该方法需要先配置
          sf.getCurrentSession();
          //之后就是使用session添加数据
    }
    @Test
    //添加数据
    public void fun2()
    {
        Configuration conf = new Configuration().configure();
        //2.根据Configuration 配置信息创建SessionFactory
        SessionFactory sf= conf.buildSessionFactory();
        //3.获取session
        //3.1 openSession()是获取一个全新的session对象
        Session session = sf.openSession();
        //添加数据
        User u=new User();
        u.setName("jerry");
        u.setPassword("1234");
        session.save(u);
        //关闭资源
        session.close();
        sf.close();


    }
    @Test
    //改数据
    public void fun3()
    {
        Configuration conf = new Configuration().configure();
        //2.根据Configuration 配置信息创建SessionFactory
        SessionFactory sf= conf.buildSessionFactory();
        //3.获取session
        //3.1 openSession()是获取一个全新的session对象
        Session session = sf.openSession();
        //打开事务
        Transaction ts=session.beginTransaction();
        //修改数据
          //首先需要查询数据,第一个参数是取出对象的类型，第二个是需要取出对象的id
         User user= (User) session.get(User.class,3);
        System.out.println(user);
         //然后在查询结果上进行修改
          user.setName("jerry1");
          //之后调用update方法保存修改
         session.update(user);
         //提交事务
         ts.commit();
        //关闭资源
        session.close();
        sf.close();


    }
    //删除数据
    @Test
    public void fun4()
    {
        Configuration conf = new Configuration().configure();
        //2.根据Configuration 配置信息创建SessionFactory
        SessionFactory sf= conf.buildSessionFactory();
        //3.获取session
        //3.1 openSession()是获取一个全新的session对象
        Session session = sf.openSession();
        //打开事务
        Transaction ts=session.beginTransaction();
        //删除数据
          //首先需要查询数据,第一个参数是取出对象的类型，第二个是需要取出对象的id
        // User user= (User) session.get(User.class,3);
         //也可以直接生成一个新的user,将其id设置为需要删除的对象相同的id
         User user=new User();
         user.setId(3);
       //直接调用delete方法删除(根据id删除）
        session.delete(user);
         //提交事务
         ts.commit();
        //关闭资源
        session.close();
        sf.close();


    }
    //查询数据(第一种方法）
    @Test
    public void fun5()
    {
        Configuration conf = new Configuration().configure();
        //2.根据Configuration 配置信息创建SessionFactory
        SessionFactory sf= conf.buildSessionFactory();
        //3.获取session
        //3.1 openSession()是获取一个全新的session对象
        Session session = sf.openSession();
        //打开事务
        Transaction ts=session.beginTransaction();
        //查询数据，调用get方法查询
        User user = (User) session.get(User.class, 4);
        System.out.println(user);
        //提交事务
         ts.commit();
        //关闭资源
        session.close();
        sf.close();


    }
    //查询数据(第二种方法）
    @Test
    public void fun6()
    {
        Configuration conf = new Configuration().configure();
        //2.根据Configuration 配置信息创建SessionFactory
        SessionFactory sf= conf.buildSessionFactory();
        //3.获取session
        //3.1 openSession()是获取一个全新的session对象
        Session session = sf.openSession();
        //打开事务
        Transaction ts=session.beginTransaction();
        //查询数据，load
        User user = (User) session.load(User.class, 4);

        //提交事务
         ts.commit();
        //关闭资源
        session.close();
        sf.close();
        System.out.println(user);

    }
    /**
     * 俩种查询方法的区别：
     * get:方法被调用时就发送sql语句进行查询
     * load:调用时并没有查询数据库，当我们需要使用该对象的时候，才查询数据库
     * 其中get就是直接将查询到的数据直接封装到user并返回给程序，而load则是使用了一个代理对象，改代理对象中只有id属性值，
     * 并将该代理对象返回给程序，当使用该代理对象的时候，该代理对象会自动用session发送sql语句到数据库中查询数据，然后初始化属性
     *  load设计的好处：用于提高hibernate的执行效率，（延迟加载）
     */
    // 查询所有user对象,第一种方法
    @Test
    public void fun7()
    {
        Configuration conf = new Configuration().configure();
        //2.根据Configuration 配置信息创建SessionFactory
        SessionFactory sf= conf.buildSessionFactory();
        Session session = sf.openSession();

        Transaction ts = session.beginTransaction();
        //HQL（hibernate 查询语言）
        //createQuery 传入HQL语言(面向对象的）
        //sql:select * from t_user;
        Query query = session.createQuery("from com.itheima.test.User");
        //list方法，将语句执行，并返回结果
        List<User> list=query.list();
        System.out.println(list);
        ts.commit();
        session.close();
       sf.close();


    }
    //查询所有user对象的第二种方法
    @Test
    public void fun8()
    {
        Configuration conf= new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //查询所有的user对象
         //使用Hibernate独创的面向对象的查询语句:无语句
        Criteria criteria = session.createCriteria(User.class);

        //相当于执行select * from t_user;将结果封装到一个list集合中
        criteria.list();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    //查询所有user第三种方法
    @Test
    public void fun9()
    {
        Configuration conf= new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        //原生的sql查询
        SQLQuery query = session.createSQLQuery("select * from t_user");

        //加入这样的一行代码，就可以将执行后的结果的数据封装到User中（不如前面几种直接封装），此时执行完sql语句后，泛型就可以写User了
        query.addEntity(User.class);
        //执行语句并返回结果(此处的list不加泛型是因为，这不是面向对象的查询，所以框架也不知道将结果封装到什么类型中：想看的话直接打印就行了）
        //此时List中的数据只是封装了表中数据的数组，若要想将其封装到指定的User类中的话，需要在执行前加入一行代码
        List<User> list=query.list();
        /*List<Object[]> list = query.list();
          //对该集合进行遍历
        for (Object[] objs:list
        ){
            System.out.println(Arrays.toString(objs));

    }*/

        System.out.println(list);

        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
