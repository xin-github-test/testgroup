package com.itheima.web.demo1;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 动态封装的第二种方法
 * 数据模型和动作类分开写
 *
 */
public class Demo2Action extends ActionSupport {
    //
    private User user;

    public User getUser() {
        //看一下是怎么执行的（此处并没有创建user对象所以会出现下面的情况，如果一开始就创建user对象，就不会有第二个setUser()了）
        /**
         * 先调用getUser(),看对象是否存在，不存在就利用反射创建一个对象
         * 在调用setUser(),将创建的对象set回去
         * 最后调用getUser(),得到user对象，用其set方法给属性赋值
         */
        System.out.println("getUser");
        return user;
    }

    public void setUser(User user) {
        //看一下是怎么执行的
        System.out.println("setUSer");
        this.user = user;
    }

    public String addUser()
    {
        //System.out.println(user.getUsername()+","+user.getAge());
        return null;//不返回任何结果视图
    }
}
