package gloableCode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
          //强转
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
          //req.setCharacterEncoding("UTF-8"); //只能解决post提交的数据乱码问题（解决方式：装饰设计模式，增强request中getParameter()中的功能功能
          req=new MyRequest(req);
        //放行
        filterChain.doFilter(req,servletResponse);//将包装后的req传过去
    }

    @Override
    public void destroy() {

    }
}
//实现与被包装类相同的接口  (直接继承适配器比较方便）
//定义一个与被包装类相同的引用
//定义一个构造方法，把被包装对象传过来
//对于不需要改写的方法调用原方法
// 重写需要改写的方法
class MyRequest extends HttpServletRequestWrapper
{
    HttpServletRequest request;
    public MyRequest(HttpServletRequest request)
    {
         super(request);
        this.request=request;
    }

    @Override
    public String getParameter(String name) {
        name=request.getParameter(name);
        try {
           return new String (name.getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}