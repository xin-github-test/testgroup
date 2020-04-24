package Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cartServlet",urlPatterns = {"/cartServlet"})
public class cartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        HttpSession session = request.getSession();
        Book book=BookDB.getBook(id);
        List<Book> list=(List<Book>)session.getAttribute("cart");
        if (list == null) {
            list=new ArrayList<Book>();
        }
        list.add(book);//list会自动处理相同的元素

       session.setAttribute("cart",list);


    }
}
