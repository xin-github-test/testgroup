package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import com.itheima.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findBookByIdInfoServlet",urlPatterns = {"/findBookInfoServlet"})
public class findBookByIdInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        //调用业务逻辑
        BookServiceImpl bs=new BookServiceImpl();
        Book book = bs.findBookById(id);
        request.setAttribute("b",book);
        //分发转向
        request.getRequestDispatcher("/product_info.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doPost(request,response);
    }
}
