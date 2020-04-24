package test;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化的小测试
 *
 */

public class test {

    @Test
    public void test2() {
        //使用resourceBundle的getBundle方法获取一个对象。参数使用消息资源包文件+名称和所处的语言环境
        //注意在给定消息资源包的时候，不需要指定语言代码和国家代码
        ResourceBundle rb = ResourceBundle.getBundle("test.message", Locale.CHINA);
      String key=rb.getString("username");
        System.out.println(key);
    }
}