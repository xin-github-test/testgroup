package demo3.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
    public String save()
    {
        System.out.println("Demo1Action的动作方法执行了！");

        return SUCCESS;
    }
}
