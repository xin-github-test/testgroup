package Timerdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.*;

//注意：写完不要忘了注册监听
public class myServletcontextListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
           //通过事件源对象得到事件源（servletContext)
        ServletContext application = sce.getServletContext();
             //创建一个集合用于存储所有session对象
        //final List<HttpSession> list=new ArrayList<>();  //该对象的线程不安全，当多人同时访问的时候会有异常
        final List<HttpSession> list=Collections.synchronizedList(new ArrayList<>()); //此时加上线程锁，线程就安全了
        //把集合放入application的域中
         application.setAttribute("sessions",list);
         //创建一个计时器对象
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("开始扫描！");
                for (Iterator iterator=list.iterator();iterator.hasNext();
                     ) {
                    HttpSession session= (HttpSession) iterator.next();
                    long l = System.currentTimeMillis() - session.getLastAccessedTime();
                    if(l>5000)
                    {
                        System.out.println(session.getId()+"被移除！");
                        session.invalidate();
                        iterator.remove();//使用迭代器就必须使用迭代器中的remove方法
                    }
                }
            /*    for (HttpSession session:list   //匿名内部类中需要final类型的数据,但是foreach不能修改元素的值
                     ) {
                    long l = System.currentTimeMillis() - session.getLastAccessedTime();//用当前时间减去session最后访问时间算出间隔时间
                    if(l>5000) //如果时间大于5000毫秒（5秒），把session销毁,同时在list中移除该session
                    {
                      session.invalidate();
                      list.remove(session);
                    }
                }*/
            }
        }, 2000, 5000);//延迟2s执行，每隔5s执行一次

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

