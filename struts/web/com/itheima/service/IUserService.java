package com.itheima.service;

import com.itheima.domain1.User;

/**
 *用户相关操作的业务接口
 *
 */
public interface IUserService {
    /**
     * 根据用户名判断用户是否存在
     * @param username
     * @return
     */
    User findUserByUsername(String username);
    /**
     * 用户注册
     * @param user
     * @return
     */
   int  register(User user);  //返回影响数据库的行数
}
