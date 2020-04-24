package Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")  //servlet3.0以上支持注解配置，包括servler的url配置，所以说servler3.0以上的版本web.xml不是必需的，替代它的就是注解，使用情况根据url更改情况决定
public class myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("dofilter执行了！");//如果访问servlet就会进入这里，如果想要访问指定servlet中的内容就必须在这里放行，不然是访问不到servlet中的内容的
       //放行,该过滤器在访问时过滤一遍，响应时也会过滤一遍
        filterChain.doFilter(servletRequest,servletResponse);
        //响应后的拦截
        System.out.println("拦截结束了");
    }

    @Override
    public void destroy() {

    }
}
