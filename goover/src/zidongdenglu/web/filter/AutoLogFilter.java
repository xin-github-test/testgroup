package zidongdenglu.web.filter;


import zidongdenglu.domain.User;
import zidongdenglu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override//注意：记得在web.xml里面进行配置
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         //1.转换俩个对象HttpservletRequest和HttpservletResponse
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
         //并不是所有的jsp页面都需要被拦截，此时应该加一个条件
          String uri=req.getRequestURI();
          String path=req.getContextPath();
          path=uri.substring(path.length());//截取页面的名称
        if(!("/log.jsp".equals(path)||"/logServlet".equals(path))) { //如果不是从这俩个页面进来的，就进行拦截
            User user = (User) req.getSession().getAttribute("user");//获取session
            if(user==null) {//如果user为空，说明没有存放信息
                //2.处理业务
                //得到cookies数组
                Cookie[] cookies = req.getCookies();
                //从数组中找到想要的cookie
                Cookie cookie = null;
                String username = "";
                String password = "";
                for (int i = 0; cookies != null && i < cookies.length; i++) {
                    if ("user".equals(cookies[i].getName())) {

                        String value = cookies[i].getValue();
                        String[] values = value.split("&");
                        username = values[0];
                        password = values[1];
                    }
                }


                UserService us = new UserService();
                User u = us.findUser(username, password);
                if (u != null) {
                    req.getSession().setAttribute("user", u);//如果登陆成功，就将信息存入session
                }
            }
        }
        //3.放行
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
