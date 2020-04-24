package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servletresponse" ,urlPatterns = {"/ress"})
public class Servletresponse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         response.setCharacterEncoding("utf-8");//告诉服务器用什么编码解析文本
//         response.setHeader("content-type","text/html;charset=utf-8");//告诉浏览器用什么编码
         response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();

        out.write("z！");//通过字符流将字符串传输到浏览器上面，因为时局部变量所以执行完就会被销毁，所以不用关闭流

    }
}
