package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InServlet")
public class InServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");
       response.setContentType("utf-8");
        PrintWriter out=response.getWriter();
        out.println("中国"+"<br>");
        out.println("URI:"+request.getRequestURI()+"<br>");
        out.println("QiueryString:"+request.getQueryString()+"<br>");
        out.println("parameter p1:"+request.getParameter("p1")+"<br>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
