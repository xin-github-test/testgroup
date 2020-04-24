package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servletdenglu" ,urlPatterns = {"/dl"})
public class Servletdenglu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter(); //将一些html语句发送到浏览器
         String userName="";
         String checked="";
        //得到用户保存的cookies
        Cookie[] cookies=request.getCookies();
        for (int i = 0; cookies!=null&&i < cookies.length; i++) {
              if("userName".equals(cookies[i].getName()))
              {
                  userName=cookies[i].getValue();//得到保存的用户值
                  checked="checked='checked'";//将勾画上


              }
        }

        out.write("<form action='/ddl' method='post'>");
        out.write("用户名：<input type='text' name='userName' value='"+userName+"'/><br/>");
        out.write("密&nbsp&nbsp&nbsp码：<input type='text' name='passWord'/><br/>");
        out.write("记住用户名：<input type='checkbox' name='remember'"+checked+"/><br/>");
        out.write("<input type='submit' value='登陆'/><br/>");

        out.write("</form>");

    }
}
