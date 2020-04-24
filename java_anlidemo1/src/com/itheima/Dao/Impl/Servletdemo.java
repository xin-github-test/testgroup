package com.itheima.Dao.Impl;

import com.itheima.Domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Servletdemo",urlPatterns = {"/demo"})
public class Servletdemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setUsername("tom");
        user.setPassword("123");
        user.setEmail("tom@163.com");


        user.setBirthday(new Date());
        UserDaoImpl us=new UserDaoImpl();

        try {
            us.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
