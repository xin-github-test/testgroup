package test;

import com.opensymphony.xwork2.ActionSupport;

public class test1Action  extends ActionSupport {
   public String execute()
   {
       //获取资源文件的方式，ActionSupport中的方法,就近原则
       String key = getText("key");
       System.out.println(key);
       return SUCCESS;
   }

}
