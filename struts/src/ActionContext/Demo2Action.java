package ActionContext;

import ActionContext.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Map;

/**
 *利用value Stack存取数据
 *
 */
public class Demo2Action extends ActionSupport {
    private String name="tom1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute()
    { //1.获取value stack 的引用
         //第一种方式
        ActionContext context=ActionContext.getContext();
       /*  Map<String,Object> requestAttribute= (Map<String, Object>) context.get("request");
        ValueStack vs2 = (ValueStack) requestAttribute.get("struts.valueStack");
        System.out.println("vs2="+vs2.hashCode());
        //第二种方式
       HttpServletRequest request=ServletActionContext.getRequest();
       //根据key获取value stack对象
      ValueStack vs1= (ValueStack) request.getAttribute("struts.valueStack");
        System.out.println("vs1="+vs1.hashCode());*/
        //第三种方式：最简单
        ValueStack vs3=context.getValueStack();
        //System.out.println("vs3="+vs3.hashCode());
        //压栈
        vs3.set("s2",new Student("里斯",20));
      vs3.push(new Student("tom",18));
      /* valueStack的其它方法
        setValue(String expr,Object value)
        expr:OGNL表达式
        value：我们要操作的数据
        把数据存到哪去？
        看OGNL表达式，带#号就操作ContextMap
        没有#号就操作ValueStack

            */
      vs3.setValue("#name","cat"); //将数据存入ActionContext中的大Map中
      vs3.setValue("name","cat1");//将数据存入ValueStack中（准确的说是赋值，就是在valustack中寻找name属性，找到了就用该值覆盖原来的，找不到name属性对应的setName()方法就报错）
        /**
         * 其中还有一个set（String key,Object o)的方法
         *   其中：String key:Map的key
         *   Oject o:map的value
         *    如果栈顶元素是一个map元素，直接把key 作为map的key,把Object作为map的value存入的是栈顶
         *    如果栈顶不是一个map元素，创建一个Map对象，把key作为map的key,Object作为map的value压入栈顶
         */
        vs3.set("s1",new Student("王五",18));
        return SUCCESS;
    }
}
