package com.itheima.product.web.servlet;

import com.itheima.product.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyAccount",urlPatterns = {"/myAccount"})
public class MyAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中取出对象
     User user= (User) request.getSession().getAttribute("user");
        //判断user是否为空
        if (user == null) {

          response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else
        {    //普通用户页面
            String path="/myAccount.jsp";
             if("admin".equals(user.getRole()))
             {
                  path="/admin/login/home.jsp";
             }
             request.getRequestDispatcher(path).forward(request,response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
