package servlet;

import demo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             response.setContentType("text/html;charset=utf-8"); //防止乱码
        String username =request.getParameter("username");
        String password =request.getParameter("password");

        PrintWriter pw=response.getWriter();
        if(("itcast").equals(username)&&("123").equals(password))
        {
             User user=new User();
             user.setUsername(username);
             user.setPassword(password);
             request.getSession().setAttribute("user",user);
            response.sendRedirect("/IndexServlet");
        }else
        {
             pw.write("用户名或密码错误，登陆失败");
            //response.sendRedirect("/login.html");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }
}
