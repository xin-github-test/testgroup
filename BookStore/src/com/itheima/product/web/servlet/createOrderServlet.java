package com.itheima.product.web.servlet;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.domain.Product;
import com.itheima.product.domain.User;
import com.itheima.product.service.OrderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "createOrderServlet",urlPatterns = {"/createOrderServlet"})
public class createOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.封装Order对象
        Order order=new Order();
        try {
            BeanUtils.populate(order,request.getParameterMap());
            order.setId(UUID.randomUUID().toString());
            order.setUser((User) request.getSession().getAttribute("user"));
        }  catch (Exception e) {
            e.printStackTrace();
        }
        //2.获取session中的购物车数据
        Map<Product,String> cart = (Map<Product, String>) request.getSession().getAttribute("cart");
        //3.遍历购物车中的数据，添加到orderitem对象中，同时把多个item对象添加到list中
        List<OrderItem> list=new ArrayList<>();
        for (Product p:cart.keySet()
             ) {
            OrderItem oi=new OrderItem();
            oi.setOrder(order);
            oi.setP(p);
            oi.setBuynum(Integer.parseInt(cart.get(p)));
            list.add(oi);
        }
        //4.把集合放入order中
        order.setOrderitems(list);
        //调用业务逻辑
        OrderService os=new OrderService();
          os.addOrder(order);
          //分发转向
        request.setAttribute("orderid",order.getId());
        request.setAttribute("money",order.getMoney());
        request.getRequestDispatcher("/pay.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
