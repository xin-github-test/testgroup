package download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "downloadServlet",urlPatterns = {"/downloadServlet"})
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //设置一个要下载的文件
        response.setCharacterEncoding("UTF-8");
   String filename="销售榜单.csv";
  filename=new String (filename.getBytes("UTF-8"),"iso-8859-1");
   //告诉浏览器要下载文件
        response.setHeader("content-disposition","attachment;filename="+filename);
     //告诉浏览器文件的类型
        response.setContentType(this.getServletContext().getMimeType(filename));//根据文件名自动获得文件类型

   //创建一个文件输出流
        PrintWriter out =response.getWriter();
        out.write("电视机，20\n");
        out.write("洗衣机，10\n");
        out.write("冰箱，8\n");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
