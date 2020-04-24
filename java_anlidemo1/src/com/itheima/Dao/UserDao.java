package com.itheima.Dao;

import com.itheima.Domain.User;

public interface UserDao {  //接口主要用于定义后面需要的方法，然后在其实现类里面将接口的功能都实现
    public void addUser(User user)throws Exception;
}
