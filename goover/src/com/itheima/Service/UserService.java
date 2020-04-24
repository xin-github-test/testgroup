package com.itheima.Service;

import com.itheima.Domain.User;
import com.itheima.Exception.UserExistException;
import com.itheima.Exception.UsersException;

public interface UserService {
    public void register(User user) throws Exception;
    public User login(User user)throws UsersException;
    public boolean findUserByName(String username)throws UserExistException;//先抛出异常，等到具体实现的时候再去解决
}
