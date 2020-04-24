package com.itheima.product.dao;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.domain.Product;
import com.itheima.product.utils.ManagerThreadLocal;
import com.itheima.product.utils.c3p0;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OderDao {
   public void addOrder(Order order) throws SQLException {
       QueryRunner qr=new QueryRunner();
       qr.update(ManagerThreadLocal.getConnection(),"insert into orders values(?,?,?,?,?,?,?,?)",order.getId(),order.getMoney(),order.getReceiverAddress(),order.getReceiverName(),order.getReceiverPhone(),order.getPaystate(),order.getOrdertime(),order.getUser().getId());
   }

    public List<Order> findOrders(int id) throws SQLException {
        QueryRunner qr=new QueryRunner(c3p0.getDataSource());
        return qr.query("select * from orders where user_id=?",new BeanListHandler<Order>(Order.class),id);
    }

    public Order findOrderItemsByOrderId(String orderid) throws SQLException {
       QueryRunner qr=new QueryRunner(c3p0.getDataSource());
       Order order=qr.query("select * from orders where id=?",new BeanHandler<>(Order.class),orderid);//找到对应订单
       //List<OrderItem> orderItems =qr.query("select * from orderitem where order_id=?",new BeanListHandler<>(OrderItem.class),orderid);//属于该订单的订单项
       // List<Product> products= qr.query("select * from products where id in(select product_id from orderitem where order_id=?",new BeanListHandler<>(Product.class),orderid);//属于该订单的物品
      List<OrderItem> orderItems=qr.query("select * from orderitem o,products p where p.id=o.product_id and order_id=?", new ResultSetHandler<List<OrderItem>>() {
          @Override
          public List<OrderItem> handle(ResultSet rs) throws SQLException {
             List<OrderItem> orderItems=new ArrayList<>();
              while (rs.next())
              {
                  //封装item对象（只封装需要的数据不需要的数据可以不进行封装）
                  OrderItem oi=new OrderItem();
                   oi.setBuynum(rs.getInt("buynum"));
                 //封装product对象
                  Product p=new Product();
                  p.setName(rs.getString("name"));
                  p.setPrice(rs.getDouble("price"));
                  //讲product对象放入item中
                  oi.setP(p);
                    //再将item放入list中返回
                  orderItems.add(oi);
              }

              return orderItems;
          }
      }, orderid);
      //把所有的订单项添加到order中
      order.setOrderitems(orderItems);
       return order;
    }

    public void modifyState(String orderid) throws SQLException {

       QueryRunner qr=new QueryRunner(c3p0.getDataSource());
       qr.update("update orders set pqystate=1 where id=?",orderid);
    }
}
