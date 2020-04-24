package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "ServletCopathdemo",urlPatterns = {"/scp"})
public class ServletCopathdemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到当前文件的绝对路径
        //test1();
        //test2();
        test3();
    }

    private void test3() throws IOException {
        String path=this.getServletContext().getRealPath("/WEB-INF/classes/servlet/c.properties");  //src里面的文件经过tomcat服务器后会转移到WEB-INF/classes目录下，二其中填写的路径使该文件在服务器中的地址
        Properties prop=new Properties();//创建一个文件对象
        prop.load(new FileInputStream(path));//创建一个流对象
        System.out.println(path);
        System.out.println(prop.get("key"));//通过key来获取里面的值
    }

    private void test2() throws IOException {
        String path=this.getServletContext().getRealPath("/WEB-INF/classes/b.properties");  //src里面的文件经过tomcat服务器后会转移到WEB-INF/classes目录下，二其中填写的路径使该文件在服务器中的地址
        Properties prop=new Properties();//创建一个文件对象
        prop.load(new FileInputStream(path));//创建一个流对象
        System.out.println(path);
        System.out.println(prop.get("key"));//通过key来获取里面的值
    }

    private void test1() throws IOException {
        String path=this.getServletContext().getRealPath("/WEB-INF/a.properties");//参数一定要以/开头（“/”代表当前项目的根目录）
        Properties prop=new Properties();//创建一个文件对象
        prop.load(new FileInputStream(path));//创建一个流对象
        System.out.println(path);
        System.out.println(prop.getProperty("key"));//通过key来获取里面的值
    }
}
