package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletconfig",urlPatterns = {"/sh"})
public class Servletconfig extends HttpServlet {

//    private ServletConfig config;
// @Override//第一种方法
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       String encoding =config.getInitParameter("encoding"); //获取配置信息的方法
//        System.out.println(encoding);
        //第二种方法：由于GenericServlet实现了servletconfig接口,且实现了getInitParameter()方法，又实现了servlet接口，且实现了其init方法（提供了config对象）和getServletConfig()（返回对象），然后被HttpServlet继承下来了，而我们写的这个类又继承了HttpServlet,所以可以直接获取config对象，然后通过该对象获取配置信息
         String encoding =this.getServletConfig().getInitParameter("encoding");
        System.out.println(encoding);
         //第三种方法：直接用this或super调用getInitParameter()方法  原因：该方法被GenericServlet实现了，然后被HttpServlet继承下来了，而我们写的这个类又继承了HttpServlet，所以可以直接用this、super调用
//         String encoding=super.getInitParameter("encoding");
//         System.out.println(encoding);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doPost(request,response);
    }
}
