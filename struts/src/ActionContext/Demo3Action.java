package ActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Struts2对EL表达式的改变（其中struts中得到的requset是经过struts2的包装的）
 *  实际就是如果在request域中找到了值，就直接返回该值，如果没有找到就取valuestack中取，valuestack没有就去actioncontext中取，如果还没有就去session中取，还没有就去application中取
 *
 */
public class Demo3Action extends ActionSupport {

    private String name = "动作类中的name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute()
    {
     //   HttpServletRequest request=ServletActionContext.getRequest();
      //  request.setAttribute("name","请求域中的name");//这个会放在大Map中的一个key为request的小map中
        ServletContext application=ServletActionContext.getServletContext();
        application.setAttribute("name","application域中的name");
//获取actioncontext对象
        ActionContext context=ActionContext.getContext();
        context.put("name","ActionContext中的name");
        return SUCCESS;
    }

}
