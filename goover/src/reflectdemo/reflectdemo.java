package reflectdemo;

import com.itheima.Domain.User;
import itcast.reflect.Person;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.ResourceBundle;

public class reflectdemo {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以去执行任意方法
        /*
         要求：不改变该类的任何代码，来实现创建任意类的对象，且执行其中的方法
         步骤：将全类名和方法名写在配置文件中，然后用反射技术进行对象的创建和方法的执行
         */
        /*Properties p=new Properties();
        ClassLoader classLoader = reflectdemo.class.getClassLoader();//获取类加载器
        p.load(classLoader.getResourceAsStream("pro.properties"));
        String className1 = p.getProperty("ClassName");
        String methodName1 = p.getProperty("methodName");*/

      //获取配置文件的数据
        ResourceBundle rb=ResourceBundle.getBundle("pro");
        String className = rb.getString("ClassName");
        String methodName = rb.getString("methodName");

        //将类加载进内存
        Class cls = Class.forName(className);
        //创建对象
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        //执行方法，默认为无参的方法
        method.invoke(obj);

    }
/*   public Object getcls(String classnaem)throws Exception//得到该类的Class对象
   {
        Class cls=null;
        cls = Class.forName("classname");
       return cls.getConstructor().newInstance();
   }
   public void invokem(String classnaem,String methodname) throws Exception {
       Class cls=null;
       cls = Class.forName("classname");
       cls.getMethod(methodname).invoke(cls.getConstructor().newInstance());
   }*/
}
