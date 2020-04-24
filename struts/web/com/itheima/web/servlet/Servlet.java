package com.itheima.web.servlet;

import com.itheima.domain1.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Servlet",urlPatterns = {"/register2"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService service=new UserServiceImpl();
       User user=new User();
       ConvertUtils.register(new Converter() {
           @Override
           public Object convert(Class aClass, Object o) {
               Date result=null;
               if(o instanceof String)
              {
                  String date=(String)o;
                  SimpleDateFormat sf=new SimpleDateFormat("yy-MM-dd");
                  try {
                      result = sf.parse(date);
                  } catch (ParseException e) {
                      e.printStackTrace();
                  }
              }
               return result;
           }
       },Date.class);

        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int register = service.register(user);
        if(register>0)
        {request.getRequestDispatcher("/success.jsp").forward(request,response);}
        else
        {
            response.getWriter().print("注册失败！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
