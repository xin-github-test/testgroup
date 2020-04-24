package Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "showServlet",urlPatterns = {"/show"})
public class showServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        List<Book> list=(List<Book>)session.getAttribute("cart");
        if(list==null)
        {
            out.print("你还什么都没有买!");
            response.setHeader("refresh","2;url='"+request.getContextPath()+"/bl'");
        }
        else
        {
            for (Book book :
                    list) {
                out.print(book.getName()+"<br>");

            }
        }

    }
}
