package com.itheima.BeanFactory;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 创建一个负责生产Dao的工厂类
 */
public class BeanFactory {
    private static BeanFactory factory = new BeanFactory();
    //读取文件获得类的全类名
    private static ResourceBundle rb;
    //使得该类不能被其它类new 出对象，使其只能有一个实例，不能被反复创建实例
    private BeanFactory()
    {

    }
    static {
        rb=ResourceBundle.getBundle("com.itheima.properties.bean");

    }
    public static BeanFactory newInstance()
    {
        return factory;
    }
//生产Dao,拿到的是普通的对象
    public Object getUserDao(String className)
    {
        Object obj=null;
        //通过反射，进行类的实例化
        String classPath=rb.getString(className);
        try {
             obj=  Class.forName(classPath).getDeclaredConstructor().newInstance();
             return obj;
        } catch (Exception e) {
           throw new ExceptionInInitializerError(e);
        }


    }
    //生产Dao,拿到的是代理对象
    public Object getProxyDao(String className)
    {

        //通过反射，进行类的实例化
        String classPath=rb.getString(className);
        try {
            final Object obj=  Class.forName(classPath).getDeclaredConstructor().newInstance();

             //生成代理对象
//            new InvocationHandler() {
//                @Override
//                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                    return method.invoke(obj,args);
//                }
//            });
            Object proxyObj=Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),(Object proxy, Method method, Object[] args)->{
                //在执行方法前你想做什么
                return method.invoke(obj,args);
                //在执行方法后你想做什么
              });
             return proxyObj;
        } catch (Exception e) {
           throw new ExceptionInInitializerError(e);
        }


    }
}
