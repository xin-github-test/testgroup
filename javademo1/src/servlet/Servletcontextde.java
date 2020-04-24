package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletcontextde",urlPatterns = {"/sc"})
public class Servletcontextde extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过调用GenericServlet的getServletContext()方法得到context对象
        ServletContext application=this.getServletContext();//获取servletcontext对象（可以不通过config对象获取）
      application.setAttribute("name","tom");//向 ServletContext对象里面添加一个键值对（map集合)

    }
}
