package com.itheima.Web.servlet;

import com.itheima.Domain.User;
import com.itheima.Exception.UsersException;
import com.itheima.Service.Impl.UserServiceImpl;
import com.itheima.Service.UserService;
import com.itheima.Utils.DButils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "loginServlet",urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = new User();

        try {
            BeanUtils.populate(user, request.getParameterMap());//获取表单数据并将其封装到bean中
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserService us = new UserServiceImpl();
        User u;
        try {
            u = us.login(user);  //调用业务逻辑

            if (u != null) {
                request.getSession().setAttribute("u", user);//如果登陆成功就将用户类封装到session中
                request.getRequestDispatcher("/denglu.jsp").forward(request, response);//实现分发转向
            }else
            {
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }catch (UsersException e)
        {
            e.printStackTrace();

           // response.sendRedirect(request.getContextPath() + "/login.jsp");

        }

        }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doPost(request, response);
        }
    }
