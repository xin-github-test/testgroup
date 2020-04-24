package com.itheima.product.web.servlet;

import com.itheima.product.domain.User;
import com.itheima.product.exception.UserException;
import com.itheima.product.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

//@WebServlet(name = "UserServlet",urlPatterns = {"/user"})
public class UserServlet extends BaseServlet {

    /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
     }
t
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取请求参数
         String method = request.getParameter("method");
         if(!"".equals(method))
         {
             if("login".equals(method))
             {
                  login(request,response);
             }
             if("register".equals(method))
             {
                  register(request,response);
             }
             if("logout".equals(method))
             {
                  logout(request,response);
             }
             if("findUserById".equals(method))
             {
                 findUserById(request,response);
             }

         }

     }*/
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService us = new UserService();
        try {
            String path = "/index.jsp";
            User user = us.login(username, password);
            if ("admin".equals(user.getRole()))//权限控制，看账是什么用户，然后跳转不同的页面
            {
                path = "/admin/login/home.jsp";
            }
            request.getSession().setAttribute("user", user);//将返回的user放入session
            request.getRequestDispatcher(path).forward(request, response);
        } catch (UserException e) {
            e.printStackTrace();
            request.setAttribute("user_msg", e.getMessage());//如果捕获到了异常，就将其放入作用域
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理验证码
        String ckcode = request.getParameter("ckcode");
        String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
        if (!checkcode_session.equals(ckcode)) {
            //如果俩个验证码不一致，跳回注册页面
            request.setAttribute("ckcode_msg", "验证码错误！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        //获取表单数据
        User user = new User();
        try {
            user.setActiveCode(UUID.randomUUID().toString());//手动添加一个激活码,用来验证用户的身份
            BeanUtils.populate(user, request.getParameterMap());


            //调用业务逻辑
            UserService us = new UserService();
            us.regist(user);
            //分发转向
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);

        } catch (UserException e) {
            request.setAttribute("user_msg", e.getMessage());//该自定义异常是显示给用户看的,所以放入request作用域中
            request.getRequestDispatcher("/register.jsp").forward(request, response);//转发回去让用户看到信息
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    protected void findUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        UserService us = new UserService();
        try {
            User user = us.findUserById(id);
            request.setAttribute("u", user);
            request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
        } catch (UserException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}

