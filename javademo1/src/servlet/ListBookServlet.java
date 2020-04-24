package servlet;

import demo.Book;
import demo.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ListBookServlet")
public class ListBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        Collection<Book> books= BookDB.getAll();
        out.write("本站提供的图书有:<br>");
        for(Book book:books)
        {
            String url="/PurchaseServlet?id="+book.getId();
            //重写url
//            String newurl=response.encodeRedirectURL(url);
//            out.write(book.getName()+"<a href=' "+newurl+" ' >点击购买</a><br>");
            out.write(book.getName()+"<a href=' "+url+" ' >点击购买</a><br>");
        }
    }
}
