package com.itheima.history;

import com.itheima.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowCartServlet",urlPatterns = {"/showCart"})
public class ShowCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("购物车里以下商品：</br>");
        //得到session对象
        HttpSession session = request.getSession();
        List<Book> books = (List<Book>)session.getAttribute("cart");
        if (books == null) {

            out.print("您还什么都没有买！");
            response.setHeader("refresh","2;url="+request.getContextPath()+"/showallbooksservlet");
            //response.sendRedirect(request.getContextPath()+"/showallbooksservlet");
            return ;
        }
        for (Book book:books) {
          out.write(book.getName()+"</br>");
        }
    }
}
