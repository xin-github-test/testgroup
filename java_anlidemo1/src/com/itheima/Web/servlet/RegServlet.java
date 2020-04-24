package com.itheima.Web.servlet;

import com.itheima.Domain.User;
import com.itheima.Service.Impl.UserServiceImpl;
import com.itheima.Service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegServlet",urlPatterns = {"/regServlet"})
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        User user=new User();
        try
        {
            ConvertUtils.register(new DateLocaleConverter(), Date.class);

            BeanUtils.populate(user, request.getParameterMap());
            UserService us=new UserServiceImpl();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        response.getWriter().write("注册成功！1秒跳转到主页");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/reg.jsp");
    }
}
