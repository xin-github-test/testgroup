package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import com.itheima.domain.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet",urlPatterns = {"/pageServlet"})
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  //初始化显示每页的记录数
    int pageSize=4;
    int currentPage=1;//当前页
    String currPage = request.getParameter("currentPage");//从jsp中获得的数据（上一页或下一页）相当于获取表单数据
    if(currPage!=null)
    {
        currentPage=Integer.parseInt(currPage);
    }
    //调用业务逻辑

        BookServiceImpl bs=new BookServiceImpl();

        PageBean pb=bs.findBooksPage(currentPage,pageSize); //因为需要返回的数据不止一个，所以将需要返回的数据都封装在一个Bean中，方便一次取到多个值
        request.setAttribute("pb", pb);
        //分发转向
            request.getRequestDispatcher("/product_list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
