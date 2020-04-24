package com.itheima.web.action;

/**
 * 创建动作类的第一种方式(有三种方式）：
 *  创建一个普通的java类
 *  他就是一个POJO，原始的老的java对象
 *  Plain Old Java Object
 *
 */
public class Demo1Action {
    public String sayHello()
    {
        System.out.println("方法执行了！");
        return "success";
    }
   public String saveUser()
   {
       System.out.println("用户保存执行了！");
       return "success";
   }
}
