package Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "cartBook",urlPatterns = {"/cartBook"})
public class cartBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        String id = request.getParameter("id");
        Book book=BookDB.getBook(id);
        out.print(book.toString());
        String history=OrgId(id,request );
        Cookie ck=new Cookie("history",history);
        ck.setPath("/");
        ck.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(ck);
    }
    public String OrgId(String id,HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
        Cookie historyBook=null;
        if (cookies == null) {
            return id;
        }
        for (int i = 0; i <cookies.length ; i++) {
            if("history".equals(cookies[i].getName()))
            {
                historyBook=cookies[i];
            }
        }
        if(historyBook==null)
        {
            return id;
        }
        String value=historyBook.getValue();
        String [] values=value.split("-");
        LinkedList<String> list=new LinkedList<String>(Arrays.asList(values));
        if(list.size()<3)
        {
            if(list.contains(id))
            {
                list.remove(id);
            }
        }else
        {
            if(list.contains(id))
            {
                list.remove(id);

            }else
            {
                list.removeLast();
            }
        }
        list.addFirst(id);
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
