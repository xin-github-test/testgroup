package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletclear" ,urlPatterns = {"/clear"})
public class Servletclear extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //创建一个cookie对象
         Cookie ck=new Cookie("lastAtime","");//将之前的servlet的cookie覆盖掉
        ck.setPath("/"); //设置删除的cookie的路径，不然可能出错
        ck.setMaxAge(0);//删除该cookie
        response.addCookie(ck);
    }
}
