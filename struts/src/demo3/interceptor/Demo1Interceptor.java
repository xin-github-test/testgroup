package demo3.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器
 *  1.创建一个类继承AbstractInterceptor,实现抽象方法
 *  2.在struts.xml中配置拦截器
 *      2.1声明拦截器
 *
 */
public class Demo1Interceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Demo1Interceptor拦截器拦截了！(执行动作方法之前");
        //放行：如果有下一个拦截器就执行下一个拦截器，没有就到达动作方法
        String rtValue = actionInvocation.invoke();//rtValue就是结果视图的名称 success
        System.out.println("Demo1Interceptor拦截器拦截了！(执行动作方法之后");
        return rtValue;
    }
}
