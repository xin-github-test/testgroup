package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DloginServlet")
public class DloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取表单数据
        String userName=request.getParameter("userName");
        String pwd=request.getParameter("pwd");

        //处理业务逻辑
        if("tom".equals(userName)&&"123".equals(pwd))
        {
            request.getRequestDispatcher("/JSP/jspsuccess.jsp").forward(request,response);
        }
        else
        {
            response.sendRedirect("/anli/JSP/login.jsp");
        }
        //分发转向
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
