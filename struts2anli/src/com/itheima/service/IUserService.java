package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户操作相关的业务层
 */
public interface IUserService {
    /**
     * 用户登陆
     * @param logoName
     * @param logoPwd
     * @return
     */
    User login(String logoName,String logoPwd);

    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int modifyUser(User user);

    /**
     * 根据用户ID删除用户
     * @param userID
     * @return
     */
    int removeUser(Integer userID);

    /**
     * 根据用户ID获取用户信息
     * @param userID
     * @return
     */
    User findUserById(Integer userID);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据条件查询用户信息
     * @param userName
     * @param gender
     * @param education
     * @param isUpload
     * @return
     */
    List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
}
