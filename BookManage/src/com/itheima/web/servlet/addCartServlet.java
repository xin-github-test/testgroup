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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "addCartServlet",urlPatterns = {"/addCartServlet"})
public class addCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String id = request.getParameter("id");
        BookServiceImpl bs=new BookServiceImpl();
        Book b = bs.findBookById(id);

        //从session中取出购物车
        int num=1;//初始化购物车开始的书的数量
        HttpSession session = request.getSession();
        Map<Book,String> cart = (Map<Book,String>)session.getAttribute("cart");
        if(cart==null)  //若session中没有，就创建一个
        {
            cart=new HashMap<Book,String>();
        }
        if(cart.containsKey(b)) //如果加入的是同一本书
        { num=Integer.parseInt(cart.get(b))+1 ;//将其num取出并加一

        }
       cart.put(b,num+"");  //将书放入购物车

        session.setAttribute("cart",cart);//将购物车放入session

        out.print("<a href='"+request.getContextPath()+"/pageServlet'>继续购物</a>，<a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>");
    }
}
