package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Servletcookie",urlPatterns = {"/cookie"})
public class Servletcookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获得客户端保存的最后访问时间
        Cookie[] cookies = request.getCookies();
        test1(out, cookies);
        //test2(out, cookies);


        //创建cookie，并把信息写会到客户端
        Cookie ck = new Cookie("lastAtime", +System.currentTimeMillis() + "");//value里面不能存中文
        Cookie ck1 = new Cookie("lastAtime1", new Date().toLocaleString());
        ck.setPath("/");//设置路径为当前应用，只要在该路径下的cookie都能访问到
        response.addCookie(ck);
      response.addCookie(ck1);

    }

    private void test2(PrintWriter out, Cookie[] cookies) {
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAtime1".equals(cookies[i].getName())) {

                out.write("你的最后访问时间为:" + cookies[i].getValue());
            }
        }
    }

    private void test1(PrintWriter out, Cookie[] cookies) {
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAtime".equals(cookies[i].getName())) {
                long l = Long.parseLong(cookies[i].getValue());
                out.write("你的最后访问时间为:" + new Date(l).toLocaleString());
            }
        }
        out.print("<a href='/clear'>clear</a>");//使用print可以输出很多类型而write只能输出字符型
    }
}