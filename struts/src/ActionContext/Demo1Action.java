package ActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *利用ActionContext存数据
 *
 */
public class Demo1Action extends ActionSupport {
    public String execute()
    {
        //1.得到ActionContext对象
        ActionContext context =ActionContext.getContext();//因为其绑定了局部线程，所以必须使用该类自己的方法才能保证取到的是我们想要的对象
        //2.往map中存入数据
        context.put("contextMap","hello contextMap");
        //3.往session中存数据
        //第一种方式 ：获取key值为session的map
        Map<String,Object> sessionAttribute = context.getSession();
         sessionAttribute.put("sessionmap","hello sessionmap");
         //第二种方式：使用原始的httpSession
        HttpSession session=ServletActionContext.getRequest().getSession();
        session.setAttribute("sessionmap1","hello sessionmap1");
     //往servletContext中存入数据
        //第一种方式：获取key值为application的map集合
        Map<String,Object> applicationAttribute=context.getApplication();
        applicationAttribute.put("applicationmap","hello application");
        //第二种方式：获取原始的对象
        ServletContext application=ServletActionContext.getServletContext();
        application.setAttribute("applicationmap1","hello applicationmap1");
        return SUCCESS;
    }
}
