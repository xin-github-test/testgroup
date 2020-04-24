package Timerdemo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

public class SessionsListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        //得到application对象中的list集合
        ServletContext application = session.getServletContext();
        //得到session对象并放入到list集合中
        List<HttpSession> list = (List<HttpSession>) application.getAttribute("sessions");
        list.add(session);
        System.out.println("添加了"+session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
