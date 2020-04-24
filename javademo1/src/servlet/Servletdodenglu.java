package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servletdodenglu",urlPatterns = {"/ddl"})
public class Servletdodenglu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
           response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取表单数据
        String userName = request.getParameter("userName");//根据表单中name的属性获取其中的值
        String passWord = request.getParameter("passWord");
        String remember = request.getParameter("remember");
        Cookie ck=new Cookie("userName",userName);//将用户名记录进cookie当中，以便下次可以得到用户名的值
        ck.setPath("/");
        //处理业务逻辑
        //分发转向
        
      if("tom".equals(userName)&&"123".equals(passWord))
      {
           if(remember!=null)   //多选框和单选框不选中的值都为null
           {

               ck.setMaxAge(Integer.MAX_VALUE); //永久保存
           }else
           {
               ck.setMaxAge(0);
           }

          response.addCookie(ck);
               //输入成功
          out.write("登陆成功！");

      }else
      {
          out.write("登陆失败！");
          //设置2秒钟跳转到重新登陆
          response.setHeader("refresh","2;url=/ddl");
      }


    }
}
