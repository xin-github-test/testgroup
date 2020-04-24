package com.itheima.web.demo1;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 第三种方式：模型驱动
 * 要想使用模型驱动，必须数据模型和动作类分开
 * 实现模型驱动的步骤：
 *     1.实现一个ModelDriver的接口
 *     2.实现接口中的抽象方法，该方法返回的是一个泛型（数据模型）
 *     3.在使用模型驱动的时候，数据模型必须由我们自己实例化
 *是由一个ModelDriver的拦截器为我们做的
 * 实际开发中采用的方式
 *
 */
public class Demo4Action extends ActionSupport implements ModelDriven<User> {
  //使用模型驱动必须自己实例化
    private User user=new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return user;
    }
    public String addUser()
    {
System.out.println(user.getUsername()+","+user.getAge());
  return null;
    }

}
