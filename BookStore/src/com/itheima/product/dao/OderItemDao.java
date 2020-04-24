package com.itheima.product.dao;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.utils.ManagerThreadLocal;
import com.itheima.product.utils.c3p0;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

public class OderItemDao {
    public void addOrderItem(Order order) throws SQLException {
        List<OrderItem> orderItems=order.getOrderitems();
        QueryRunner qr=new QueryRunner();
        Object[][] params=new Object[orderItems.size()][];
        for (int i = 0; i <params.length ; i++) {
             params[i]=new Object[]{order.getId(),orderItems.get(i).getP().getId(),orderItems.get(i).getBuynum()};
        }
        qr.batch(ManagerThreadLocal.getConnection(),"insert into orderitem values(?,?,?)",params);
    }
}
