package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import com.itheima.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findBookByIdServlet",urlPatterns = {"/findBookByIdServlet"})
public class findBookByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      String id=request.getParameter("id");//获取需要修改的书的id
        //调用业务逻辑
        BookServiceImpl bs=new BookServiceImpl();
        Book book=bs.findBookById(id);
        request.setAttribute("book",book);//将找到的书封装到request中
        //分发转向
        request.getRequestDispatcher("admin/products/edit.jsp").forward(request,response);
    }
}
