package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "demo1" ,urlPatterns = {"/d1"})
public class demo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
    System.out.println("我要办事");
        System.out.println("你的事我办不了，我可以帮你找人办");
//          String path=this.getServletContext().getRealPath("/WEB-INF/classes/servlet/demo2.java");
//          System.out.println(path);
       this.getServletContext().getRequestDispatcher("/demo2")//参数写上需要转到的文件的路径
           .forward(request,response);  //将两个参数（请求和响应）传过去 向下传递
        System.out.println("你的事办完了");
       response.getWriter().print("cp"+request.getContextPath());
        response.getWriter().print("url"+request.getRealPath("/WEB-INF/classes/servlet/demo1"));

    }
}
