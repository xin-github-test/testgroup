package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RpServlet")
public class RpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8"); //设置对象的解码方式（只对Post提交方式有效）
        String name =request.getParameter("username");
     String password =request.getParameter("password");
     System.out.println("用户名:"+name);
        System.out.println("密码:"+password);  //输出用户名和密码

        String [] hobbys=request.getParameterValues("hobby");
        for(int i=0;i< hobbys.length;i++)
        {

            System.out.println(hobbys[i]+",");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
