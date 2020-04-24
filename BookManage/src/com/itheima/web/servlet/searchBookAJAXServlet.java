package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchBookAJAXServlet" ,urlPatterns = {"/searchBookAJAXServlet"})
public class searchBookAJAXServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");//只能解决post提交方式的乱码
       response.setContentType("text/html;charset=UTF-8");
       //获取搜索框里面的内容
        String name = request.getParameter("name");
        //调用业务逻辑
        BookServiceImpl bs=new BookServiceImpl();
        List<Object> list =bs.searchBookByName(name);
        //把集合中的数据（object)转换成字符串返回到网页,此处还是比较麻烦，可以使用json对象（需要导包）
  /*      String str="[";
        for (int i = 0; i < list.size(); i++) {
               if(i>0)
               {
                   str+=",";
               }
               str+="\""+list.get(i)+"\"";  //最后形成:1001,1002这种形式，然后将这个字符串封装到request作用域中
        }
               str+="]";  //直接将字符串弄成["1001","1002"]*/
        //System.out.println(str);
               String str=JSONArray.fromObject(list).toString(); //可以代替上面一大堆的代码
        response.getWriter().write(str);//将该字符串写回到用户浏览器上，然后用js中的req取出该字符串就行了
//          request.setAttribute("str",str);
//        //分发转向
//        request.getRequestDispatcher("/index.jsp").forward(request,response);



    }
}
