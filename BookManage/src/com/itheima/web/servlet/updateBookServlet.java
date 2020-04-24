package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import com.itheima.domain.Book;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "updateBookServlet",urlPatterns = {"/updateBookServlet"})
public class updateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    Book book=new Book();
        try {
            BeanUtils.populate(book,request.getParameterMap());
        } catch (Exception e) {

            e.printStackTrace();
        }
        BookServiceImpl bs=new BookServiceImpl();
        //调用业务逻辑

        bs.updateBook(book);
        //分发转向
        request.getRequestDispatcher("bookListServlet").forward(request,response);
    }
}
