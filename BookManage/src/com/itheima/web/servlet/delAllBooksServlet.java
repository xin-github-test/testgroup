package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delAllBooksServlet",urlPatterns = {"/delAllBooksServlet"})
public class delAllBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //得到所有的id
        String[] ids = request.getParameterValues("ids");
        //调用业务逻辑
        BookServiceImpl bs=new BookServiceImpl();
        bs.deleAllBooks(ids);
        //分发转向
        request.getRequestDispatcher("bookListServlet").forward(request,response);
    }
}
