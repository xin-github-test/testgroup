package ActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo8Action extends ActionSupport
{
    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String login()
     {
         System.out.println(name);
         return SUCCESS;
     }

}
