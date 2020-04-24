package com.itheima.Web.servlet;

import com.itheima.Domain.User;
import com.itheima.Domain.UserForm;
import com.itheima.Exception.UserExistException;
import com.itheima.Service.Impl.UserServiceImpl;
import com.itheima.Service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
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

@WebServlet(name = "RegServlet",urlPatterns = {"/regServlet"})
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserForm uf=new UserForm();
        try {
            BeanUtils.populate(uf,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
         if(!uf.Validate())//如果map不为空，则说明有错误
         {
             request.setAttribute("uf",uf);//将该类放入request的域中
             request.getRequestDispatcher("/reg.jsp").forward(request,response);
             return;//有错的话就直接结束，下面的代码就可以不用继续执行了
         }

        User user=new User();
        try
        {
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object o) {
                    Date date1=null;
                    if(o instanceof String )
                    {
                        String date=(String) o;
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date1=sdf.parse(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    return date1;
                }
            }, Date.class);

            BeanUtils.populate(user, request.getParameterMap());
            /*String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String birthday = request.getParameter("birthday");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(birthday);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setBirthday(date);*/
            boolean isE=false;
            UserService us=new UserServiceImpl();
            try {
                 us.findUserByName(user.getUsername());//通过用户名查看用户是否已存在
            } catch (UserExistException e) { //捕捉当时抛出的可能出现的异常
                isE=true;
                request.setAttribute("error","用户名已存在!");
                request.getRequestDispatcher("/reg.jsp").forward(request,response);
                e.printStackTrace();

            }

               if(!isE)//当用户存在时，就不向数据库中插入数据了
               {
                   us.register(user);
               }



        }catch(Exception e)
        {
            e.printStackTrace();
        }
        response.getWriter().write("注册成功！1秒跳转到主页");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/login.jsp");
    }
}
