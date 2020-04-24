package AjaxServletDemo.ckNameServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ckNameServlet",urlPatterns = {"/ckNameServlet"})
public class ckNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String name=request.getParameter("name");
        PrintWriter out = response.getWriter();
        if("tom".equals(name))
     {
           out.print(true);
     }else
        {
            out.print(false);
        }
    }
}
