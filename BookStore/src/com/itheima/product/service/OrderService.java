package com.itheima.product.service;

import com.itheima.product.dao.OderDao;
import com.itheima.product.dao.OderItemDao;
import com.itheima.product.dao.ProductDao;
import com.itheima.product.domain.Order;
import com.itheima.product.exception.OrderException;
import com.itheima.product.utils.ManagerThreadLocal;

import java.sql.SQLException;
import java.util.List;

public class OrderService {

    OderDao orderDao=new OderDao();
    OderItemDao orderitemDao=new OderItemDao();
    ProductDao productDao=new ProductDao();

    public void addOrder(Order order)
    {
        try {
            ManagerThreadLocal.startTransaction();
            orderDao.addOrder(order);
            orderitemDao.addOrderItem(order);
            productDao.updateProductNum(order);
            ManagerThreadLocal.startTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
            ManagerThreadLocal.rollbackTransaction();
        }

    }

    public List<Order> findOrdersByUserId(int id) {

        try {
            return orderDao.findOrders(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order findOrderItemsByOrderId(String orderid) {
        try {
            return orderDao.findOrderItemsByOrderId(orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void modifyOrderState(String orderid) throws OrderException {
        try {
            orderDao.modifyState(orderid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("修改失败！");
        }
    }
}
