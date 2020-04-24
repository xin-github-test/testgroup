package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRequest",urlPatterns = {"/req"})
public class ServletRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      String str="aaa";
      System.out.println("A:我想办事");
      System.out.println("B:我办不了，但我可以找人帮你");
      request.setAttribute("s",str);//验证request的域对象，实现一定范围的共享,和context的域对象差不多，都是将数据放在一个Map集合中，实现非表单数据的转发
      //request.getRequestDispatcher("/requede").forward(request,response);//将请求转向其他servlet
        //请求包含
         request.getRequestDispatcher("/requede").include(request,response);//将此servlet的代码全部转移到另一个servlet上，将俩个资源当成一个来处理
      System.out.println("B:办完了");
        System.out.println("路径："+request.getContextPath());

    }
}
