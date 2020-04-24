package Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "booklistServlet",urlPatterns = {"/bl"})
public class booklistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
         Collection<Book> books=BookDB.getAll();
         String contextpath=request.getContextPath();
        for (Book book :
                books) {
           out.print("本站提供的图书有:"+book.getName()+"<br/>");

           out.print("<a href='"+contextpath+"/cartServlet?id="+book.getId()+"'>加入购物车</a>");
           out.print("<a href='"+contextpath+"/cartBook?id="+book.getId()+"'>查看详情</a><br/>");
            out.print("<br>");
        }
        out.print("<a href='"+contextpath+"/show'>查看购物车:</a><br/>");
        out.print("历史记录:"+"<br>");
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies!=null&&i < cookies.length; i++) {
            if("history".equals(cookies[i].getName()))
            {
                String value=cookies[i].getValue();
                String [] v=value.split("-");
                for (int j = 0; j < v.length; j++) {
                    out.print(BookDB.getBook(v[j]).getName());
                    out.print("<br>");
                }

            }

        }


    }
}
