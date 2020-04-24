package com.itheima.history;

import com.itheima.entity.Book;
import com.itheima.util.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

@WebServlet(name = "showBookDetialServlet",urlPatterns = {"/showBookDetial"})
public class showBookDetialServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获得id
        String id = request.getParameter("id");
        Book book = DButil.findById(id);
        out.write(book.toString());
        //out.print(book);
        //把当前浏览过的id写回到客户端
        String historyid=orgnizeId(id,request);
        Cookie ck=new Cookie("historyid",historyid);
        ck.setPath("/");
        ck.setMaxAge(Integer.MAX_VALUE);

        response.addCookie(ck);//写回客户端


    }

    private String orgnizeId(String id, HttpServletRequest request) {
        //得到客户端的cookie
        Cookie[] cookies = request.getCookies();
        if(cookies==null)  //判断cookie是否为空
        {
            return id;
        }
        //寻找是否有name为historyid的cookie（此时cookie不为空)
        Cookie historyBook=null;
        for (int i = 0; i <cookies.length ; i++) {
             if("historyid".equals(cookies[i].getName()))
             {
                 historyBook=cookies[i];
             }

        }
        //若是没有name为historyid的cookie，也直接将id返回
        if (historyBook == null) {

            return id;
        }
        String value=historyBook.getValue();
        String []values=value.split("-");
        LinkedList<String> list=new LinkedList<>(Arrays.asList(values));

        if(list.size()<3)  //只能存三本书
        {
         if(list.contains(id)) //若集合中有该书的id就将其删除
         {
             list.remove(id);
         }
        }else
        {
            if(list.contains(id)) //若集合中有该书的id就将其删除
            {
                list.remove(id);
            }else
            {
                list.removeLast();  //若不包含就直接删除最后一个元素
            }

        }
        list.addFirst(id);//不管如何最新浏览的书总是放在最开头
       StringBuffer sb=new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if(i>0)
            {
                sb.append("-");
            }
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
