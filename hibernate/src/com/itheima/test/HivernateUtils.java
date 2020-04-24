package com.itheima.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 由于使用Hibernate 框架的时候有些代码的重复性太高了，所以就将某些代码 封装成为一个工具类
 */
public class HivernateUtils {
    private static SessionFactory sf;

    static {
        //初始化
        Configuration conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        //在运行时，给虚拟机制定一个关闭时的任务（关闭资源）
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("虚拟机关闭了。。。");
            sf.close();
        }));
    }

    //获得session 的方法
    public static Session openSession() {
        return sf.openSession();
    }

    public static Session getCurrentSession() {
        return sf.getCurrentSession();
    }


    public static void main(String[] args) {
        System.out.println(openSession());
    }
}