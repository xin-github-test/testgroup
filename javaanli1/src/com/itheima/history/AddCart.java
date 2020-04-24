package com.itheima.history;

import com.itheima.entity.Book;
import com.itheima.util.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddCart",urlPatterns = {"/addCart"})
public class AddCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //根据id得到书
        String id=request.getParameter("id");
        Book book = DButil.findById(id);
        HttpSession session=request.getSession();
        //从session中取出list
        List<Book> list=(List<Book>) request.getSession().getAttribute("cart");

        if (list == null) {
            list =new ArrayList<Book>();

        }
  list.add(book);
        session.setAttribute("cart",list);
    }
}
