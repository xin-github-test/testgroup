package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet(name = "PrintServlet" ,urlPatterns ={ "/PrintServlet"})  //在使用注解方式声明Servlet时,需要引入javax.servlet.annotation.WebServletD的包,且不需要手动配置web.xml
public class PrintServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String data="itcaset";
        PrintWriter print=response.getWriter();
        print.write(data);
    //OutputStream out=response.getOutputStream();  俩种流不能同时使用
   // out.write(data.getBytes());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        doGet(request,response);
    }
}

