package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoLogin",urlPatterns = {"/dl"})
public class DoLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
         if("123".equals(password)&&"Tom".equals(username))
         {
             response.sendRedirect(request.getContextPath()+"/su");
         }else
         {

             response.setHeader("refresh","2;url='"+request.getContextPath()+"/dl'");
         }
    }
}
