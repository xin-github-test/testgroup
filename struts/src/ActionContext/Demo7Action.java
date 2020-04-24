package ActionContext;

import ActionContext.domain.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 表单的一个小例子
 */
public class Demo7Action extends ActionSupport implements ModelDriven<Customer> {
  //定义一个模型，必须自己实例化
     private Customer customer=new Customer();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String save()
    {
        System.out.println(customer);
        return null;
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
