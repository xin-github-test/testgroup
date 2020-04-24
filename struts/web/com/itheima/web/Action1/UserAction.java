package com.itheima.web.Action1;

import com.itheima.domain1.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * 注意在表单中有日期类型时，应该用2020/3/23这种类型填写表单
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    //定义用户的数据模型，必须自己实例化对象
    private User user=new User();
  private IUserService service=new UserServiceImpl();
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public User getModel() {
        return user;
    }
    public String register()
    {
        //1.根据用户名获取数据库的用户对象
        User dbUser=service.findUserByUsername(user.getUsername());
        //2.判断用户是否存在
          if(dbUser!=null) {
              //2.1如果存在，返回exists
              return "exists";
          }
        //3.不存在，保存用户值
        int res=service.register(user);
          if(res>0) {
              //4.如果执行结果大于0
              return SUCCESS;
          }
        //5.如果不大于0，返回null
        return null;


    }
}
