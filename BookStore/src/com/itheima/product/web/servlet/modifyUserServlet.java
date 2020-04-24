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
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "modifyUserServlet",urlPatterns = {"/modifyUserServlet"})
public class modifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //封装表单数据
        User user=new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());

            UserService us=new UserService();
            us.modifyUser(user);

            request.getSession().invalidate();//销毁session，修改信息后重新登陆
            //跳转到modifyUserInfoSuccess.jsp
            response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
        }  catch (UserException e)
        {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());

        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doPost(request,response);
    }
}
