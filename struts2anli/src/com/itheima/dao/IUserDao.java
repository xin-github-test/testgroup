package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户相关操作持久层相关的接口
 */
public interface IUserDao {
    /**
     * 根据用户的登陆名和密码查找用户
     * @param logoName
     * @param logoPwd
     * @return
     */
    User selectUserByInfo(String logoName, String logoPwd);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户id删除用户
     * @param userID
     * @return
     */
    int deleteUser(Integer userID);

    /**
     * 根据用户id查询用户信息
     * @param userID
     * @return
     */
    User selectUserById(Integer userID);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAllUser();

    /**
     * 根据指定的条件获取用户信息
     * 当条件是null的时候，表示忽略条件
     * @param userName
     * @param gender
     * @param education
     * @param isUpload
     * @return
     */
    List<User> selectUserByCondition(String userName, String gender, String education, String isUpload);

}
