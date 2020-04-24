package servlet;

import demo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet" ,urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null) {
            response.getWriter().print("您还没有的登陆，请<a href='/login.html'>登陆</a>");
        }
        else
        {
            response.getWriter().print("您已登录，欢迎你，"+user.getUsername()+"!");
            response.getWriter().print("<a href='/LogoutServlet'>退出</a>");
            Cookie cookie = new Cookie("JSESSION",session.getId());
            cookie.setMaxAge(60*30);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}
