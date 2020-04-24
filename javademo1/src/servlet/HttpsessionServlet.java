package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HttpsessionServlet",urlPatterns = {"/sessiondemo1"})
public class HttpsessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //session也是一个域对象
        String name = request.getParameter("name");
        HttpSession session =request.getSession();//获取session对象
        session.setAttribute("name",name); //将name存入域对象，该session的作用域比request大，比servletcomtext小

    }
}
