package com.itheima.product.web.servlet;

import com.itheima.product.domain.Order;
import com.itheima.product.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findOrderItemsByOrderId",urlPatterns = {"/findOrderItemsByOrderId"})
public class findOrderItemsByOrderId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderid = request.getParameter("orderid");

        OrderService os=new OrderService();
       Order order=os.findOrderItemsByOrderId(orderid);

        request.setAttribute("order",order);
        request.getRequestDispatcher("/orderInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
