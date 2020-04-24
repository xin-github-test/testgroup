package com.itheima.web.demo1;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * 静态参数封装，第一种情况
 * 缺点：数据模型和动作类写在一起了
 */
public class Demo1Action extends ActionSupport {

    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String addUser()
     {
         System.out.println(username+","+age);
         return null;//不返回任何结果视图
     }

}
