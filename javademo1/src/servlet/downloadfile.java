package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "downloadfile" ,urlPatterns = {"/down"})
public class downloadfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过路径得到一个输入流
        String path=this.getServletContext().getRealPath("/WEB-INF/classes/b.jpg");
        FileInputStream fis=new FileInputStream(path);  //得到该图片的字节流

        ServletOutputStream sos=response.getOutputStream();//创建输出流

        String filename=path.substring(path.lastIndexOf("\\")+1);//获取文件的名字
         filename=URLEncoder.encode(filename,"utf-8");//设置文件名的编码，不然会出现文件名错误(将不安全的字符变为utf-8,
                 /*字母数字字符 "a" 到 "z"、"A" 到 "Z" 和 "0" 到 "9" 保持不变。
特殊字符 "."、"-"、"*" 和 "_" 保持不变。
空格字符 " " 转换为一个加号 "+"。
所有其他字符都是不安全的*/
        response.setHeader("content-disposition","attachment;filename="+filename);//告诉浏览器该文件需要下载
         response.setHeader("content-type","image/jpeg");//告知浏览器文件的类型
        int len=1;
        byte b[]=new byte[1024];
        while((len=fis.read(b))!=-1)
        {
            sos.write(b,0,len);
        }
        sos.close();
        fis.close();

    }
}
