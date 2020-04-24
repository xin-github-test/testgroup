package com.itheima.web.interceptor;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *检查登陆的拦截器（继承该类可以过滤一些不需要拦截的方法)
 */
public class CheckLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //1.获取session对象
        HttpSession session=ServletActionContext.getRequest().getSession();
        //2.在session中找到user对象
        User user = (User) session.getAttribute("user");

        //3.有的话就放行，没有的话就前往登陆页面
        if(user!=null)
        {//放行
           return actionInvocation.invoke();
        }
      return "login";

    }
}
