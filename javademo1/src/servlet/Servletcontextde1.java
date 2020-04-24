package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletcontextde1",urlPatterns = {"/sc1"})
public class Servletcontextde1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //在另一个servlet里面访问其他servlet设置的属性  注意：在访问其他的servlet的属性的时候必须先将其进行访问，使得键值对被放入context对象中
        String name=(String)this.getServletContext().getAttribute("name");
        System.out.println(name);
    }
}
