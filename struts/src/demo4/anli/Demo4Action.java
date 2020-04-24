package demo4.anli;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

public class Demo4Action extends ActionSupport {
    //无论显示主页还是其它页面都执行此方法，且都返回成功
    public String execute()
    {
        return SUCCESS;
    }

    /**
     * 用户登陆的方法
     * @return
     */
    public String login()
    {
        HttpSession session=ServletActionContext.getRequest().getSession();
        session.setAttribute("user","test");
        return SUCCESS;
    }
}
