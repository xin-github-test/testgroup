package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletdemo7" ,urlPatterns = {"/demo7"})
public class Servletdemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("A:我要借钱");
      System.out.println("B:我没有，但我可以告诉你谁有");
//      response.setStatus(302);//302代表告诉客户端需要重定向，告知服务器访问别的servlet
//      response.setHeader("location","/demo8 ");//告诉浏览器访问哪个路径
        //请求重定向
        response.sendRedirect("/demo8");//上面俩句话的综合
      System.out.println("我去了"); //其中这个servlet的三句话同时显示，最后才执行跳转的代码,因为该此servlet通过响应的方式响应给服务器告诉服务器跳转的路径，然后服务器再发送请求去该服务器，并不会回到当前的servlet
    }
}
