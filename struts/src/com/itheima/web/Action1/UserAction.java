package com.itheima.web.Action1;

import com.itheima.domain1.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * 注意在表单中有日期类型时，应该用2020/3/23这种类型填写表单
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    //定义用户的数据模型，必须自己实例化对象
    private User user=new User();
    private String username=null;

    public void setUsername(String username) {
        this.username = username;
    }

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

    /**
     * 在strus2中，也提供一个Map<表单字段名，错误提示>
     *    我们要做的是：
     *       往Map中放错误信息
     *   编程式验证：(弊端：硬编码）
     *    1.动作类必须继承ActionSupport
     *    2.重写validate方法
     *    validate 方法会在动作方法执行之前，进行验证
     *该方法会对动作类中的所有方法都进行校验
     * 解决方式：
     * 第一种方式：
     *  使用@SkipValidation
     * 第二种方式：
     *  定义验证方法的名称：validate+动作名称(动作名称的首字母要大写)
     * 声明式验证：
     *  通过编写验证规则的xml文件，需要验证时，编写xml文件，不要验证就不写
     *   建立一个ActionClassName-validation.xml文件
     *
     * @return
     */
//    public void validateRegister()
//    {
//        if(StringUtils.isEmpty(user.getUsername()))
//       {
//           addFieldError("username","请输入用户名！");
//        }
//    }
//    public void validate()
//    {
//        if(StringUtils.isEmpty(user.getUsername()))
//        {
//            addFieldError("username","请输入用户名！");
//        }
//    }
    //@SkipValidation
    public String findAll()
    {
        return SUCCESS;
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
