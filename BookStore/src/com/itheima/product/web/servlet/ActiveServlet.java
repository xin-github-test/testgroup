package com.itheima.product.web.servlet;

import com.itheima.product.exception.UserException;
import com.itheima.product.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActiveServlet",urlPatterns = {"/activeServlet"})
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取激活码
        String activeCode = request.getParameter("activeCode");
        UserService us=new UserService();
        try {
            us.activeUser(activeCode);
        } catch (UserException e) {
            e.printStackTrace();
           response.getWriter().write(e.getMessage()); //直接将该信息显示到页面
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
