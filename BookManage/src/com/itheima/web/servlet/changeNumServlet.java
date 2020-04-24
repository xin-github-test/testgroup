package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import com.itheima.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "changeNumServlet",urlPatterns = {"/changeNumServlet"})
public class changeNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String num = request.getParameter("num");
        HttpSession session = request.getSession();
        Book b=new Book();
        b.setId(id);
        Map<Book,String> cart= (Map<Book, String>) session.getAttribute("cart");
        if("0".equals(num))
        {
            cart.remove(b);
        }


        if(cart.containsKey(b))  //因为book中是通过书的id进行hash算法的，所以只需要书的id就可以判断是否为同一本书
        {
          cart.put(b,num);//如果直接用b的话，b中是只有id的，没有书的其他信息，所以需要先将书的完整信息查询出来，在将其放入cart中
        }
response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }
}
