package demo4.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
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
