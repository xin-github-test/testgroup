package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delBookServlet",urlPatterns = {"/delBookServlet"})
public class delBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String id=request.getParameter("id");
        BookServiceImpl bs=new BookServiceImpl();
         bs.deleteBook(id);
         request.getRequestDispatcher("bookListServlet").forward(request,response);
    }
}
