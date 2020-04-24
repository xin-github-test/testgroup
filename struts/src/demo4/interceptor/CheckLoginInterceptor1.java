package demo4.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * 检查登陆的拦截器的最终版本，可以过滤一些不需要拦截的动作
 */
public class CheckLoginInterceptor1 extends MethodFilterInterceptor {
    @Override
    public String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //获取session
        HttpSession session=ServletActionContext.getRequest().getSession();
        //从session中取出登陆标记
        Object obj=session.getAttribute("user");
        //判断是否有登陆标记
        if(obj==null)
        {
            //用户没有登陆
             return "input";
        }
        //用户登陆了，放行
         String rtValue=actionInvocation.invoke();
        return rtValue;


    }
}
