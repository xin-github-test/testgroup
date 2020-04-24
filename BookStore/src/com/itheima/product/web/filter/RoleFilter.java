package com.itheima.product.web.filter;

import com.itheima.product.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RoleFilter",urlPatterns = {"/admin/*"})
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
      //强转
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        //处理业务
           //得到用户
          User user = (User) request.getSession().getAttribute("user");
            if(user!=null) {
                if (!"admin".equals(user.getRole())) {
                    response.getWriter().write("权限不足，你无法访问！");
                    response.setHeader("refresh", "2;url=" + request.getContextPath() + "/index.jsp");
                    response.sendRedirect("");
                    return;//如果权限不足，直接退出，不放行，跳转到其他页面

                }
                //放行
                chain.doFilter(request,response);
            }
          response.sendRedirect(request.getContextPath()+"login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
