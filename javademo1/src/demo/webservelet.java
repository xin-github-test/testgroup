package demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(name="webservelet",urlPatterns = {"/webservelet"})
public class webservelet implements Servlet {
//生命周期的方法，实例化 第一次访问调用
    public webservelet()
    {
        System.out.println("*******webservelet执行了********");
    }



  //生命周期的方法 ，服务的方法，每次访问都会执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {


        System.out.println("*******service执行了********");

    }
//初始化的方法 （生命周期的方法）第一次访问调用
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("*******init执行了********");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }
//销毁的方法（生命周期的方法）
    @Override
    public void destroy() {
        System.out.println("*******destroy执行了********");
    }


}
