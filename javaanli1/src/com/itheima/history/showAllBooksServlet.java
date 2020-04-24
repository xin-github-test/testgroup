package com.itheima.history;

import com.itheima.entity.Book;
import com.itheima.util.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "showAllBooksServlet",urlPatterns = {"/showallbooksservlet"})
public class showAllBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s="addcart";
        out.write("本站有以下书籍：<br/>");
        Map<String, Book> books = DButil.findAllBooks();
        for (Map.Entry<String,Book> book:books.entrySet()) {
            out.write("<a href='"+request.getContextPath()+"/showBookDetial?id="+book.getKey()+"'target='_blank'>"+book.getValue().getName()+" </a> ");
            out.write("&nbsp<a href='"+request.getContextPath()+"/addCart?id="+book.getKey()+"'target='_blank'>"+s+"</a><br/>");
        }
         out.print("<a href='"+request.getContextPath()+"/showCart' target='_blank'>查看购物车</a>");
        out.write("<hr/>您最近浏览过的书有：<br/>");
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies!=null&&i < cookies.length; i++) {
             if("historyid".equals(cookies[i].getName()))
             {
                  String value=cookies[i].getValue();
                 String[] values = value.split("-");
                 for (int j = 0; j < values.length; j++) {

                     out.write("<a href='"+request.getContextPath()+"/showBookDetial?id="+values[j]+"' target='_blank'>"+books.get(values[j]).getName()+"</a></br>");
                     
                 }

             }
        }
    }
}
