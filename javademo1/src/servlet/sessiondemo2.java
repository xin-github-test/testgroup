package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "sessiondemo2",urlPatterns = {"/sessiondemo2"})
public class sessiondemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取上个servlet的值
        HttpSession session=request.getSession();
       String  name = (String )session.getAttribute("name");
        if (name != null) {
            System.out.println(name);
        }else
        {
System.out.println("你不能直接访问此资源！");
        }


    }
}
