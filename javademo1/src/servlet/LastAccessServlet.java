package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccessServlet" ,urlPatterns = {"/last"})
public class LastAccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String lastAccessTime = null;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAccess".equals(cookies[i].getName())) {
                lastAccessTime = cookies[i].getValue();
                break;
            }
        }
        if (lastAccessTime == null) {
            response.getWriter().print("您是首次访问本站！");
        } else {

          response.getWriter().print("您上次访问的时间是:"+lastAccessTime);
        }
        String currentTime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
     Cookie cookie=new Cookie("lastAccess",currentTime);
  response.addCookie(cookie);
    }
    }

