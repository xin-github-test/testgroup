package com.itheima.web.ServletAPI;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo1Action extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {

    /**
     *
     * 获取ServletAPI
     *  第一种方式：
     *  使用ServletActionContext    推荐使用
     *  第二种方式：
     *   这种方式是由一个拦截器实现的
     *   使用的是依赖注入的形式，把我们想要的对象注入进来,但是需要实现接口，需要注入几个对象就需要实现几个接口
     *
     * @return
     * @throws Exception
     */
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext application;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request=ServletActionContext.getRequest();//这个request不是tomcat服务器提供的，二是经过包装后的
        HttpServletResponse response=ServletActionContext.getResponse();
        ServletContext application=ServletActionContext.getServletContext();
        HttpSession session=request.getSession();
        System.out.println(request);
        System.out.println(response);
        System.out.println(application);
        System.out.println(session);
        return null;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;

    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
    this.response=response;
    }

    @Override
    public void setServletContext(ServletContext application) {
  this.application=application;

    }
}
