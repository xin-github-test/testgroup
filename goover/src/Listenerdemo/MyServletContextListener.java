package Listenerdemo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    //必须在web.xml里面注册监听
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象创建了！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象销毁了！");
    }
}
