package com.itheima.product.web.servlet;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.User;
import com.itheima.product.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findOrderByUserId")
public class findOrderByUserId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  User user= (User) request.getSession().getAttribute("user");

        OrderService os=new OrderService();
        List<Order> orders=os.findOrdersByUserId(user.getId());

        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/orderlist.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
