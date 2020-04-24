package zidongdenglu.web.servlet;

import zidongdenglu.domain.User;
import zidongdenglu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logServlet",urlPatterns = {"/logServlet"})
public class logServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

         UserService us=new UserService();
         User user=us.findUser(username,password);
         if(user!=null)
         {
             String autologin = request.getParameter("autologin");
             Cookie cookie = new Cookie("user",user.getUsername()+"&"+user.getPassword());
             cookie.setPath("/");
             if(autologin!=null)//要记住用户名和密码
             {
                cookie.setMaxAge(60*60*24*7);//以秒为单位，保存7天
             }else //要清除用户名和密码的保存记录
             {
                 cookie.setMaxAge(0);
             }
             response.addCookie(cookie);
             request.getSession().setAttribute("user",user);
             request.getRequestDispatcher("/home.jsp").forward(request,response);
         }else
         {
             request.setAttribute("msg","用户名或密码错误！");
             request.getRequestDispatcher("/log.jsp").forward(request,response);
         }
    }
}
