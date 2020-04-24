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

@WebServlet(name = "bookListServlet",urlPatterns = {"/bookListServlet"})
public class bookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        //调用业务逻辑
        BookServiceImpl bsi=new BookServiceImpl();
        List<Book> list = bsi.findAllBooks();
        //if(list!=null)//实际list永远不会为空，执行select语句后，如果没有查询到数据则返回的list的size为0，而List不会为null
       // {//跳转页面
            request.setAttribute("books",list);//把得到的list集合放入request作用域中传入下一个页面
            request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
       // }
    }
}
