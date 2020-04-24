package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import com.itheima.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchBooksServlet",urlPatterns = {"/searchBooksServlet"})
public class searchBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("UTF-8");
          response.setContentType("text/html;charset=UTF-8");
          //获取表单数据
        String id = request.getParameter("id").trim();
        String category = request.getParameter("category").trim();
        String name = request.getParameter("name").trim();
        String minprice = request.getParameter("minprice").trim();
        String maxprice = request.getParameter("maxprice").trim();
        //调用业务逻辑
        BookServiceImpl bs=new BookServiceImpl();
        List<Book> list =bs.searchBooks(id,category,name,minprice,maxprice);
        //分发转向
        request.setAttribute("books",list);
        request.getRequestDispatcher("admin/products/list.jsp").forward(request,response);

    }
}
