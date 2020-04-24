package servlet;

import JDBCdemo.student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletkuangjia" ,urlPatterns = {"/kj"})
public class Servletkuangjia extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  request.setCharacterEncoding("utf-8");//告诉服务器使用什么编码解析
       request.setCharacterEncoding("utf-8");
        ServletInputStream ss=request.getInputStream();//获取一个输入流
        int len=0;
        byte [] b=new byte[1024];
        while((len=ss.read(b))!=-1)
        {
            System.out.println(new String (b,0,len));
        }



    }

    private void test1(HttpServletRequest request) {
        try {
            student stu=new student();
            System.out.println("封装前："+stu);
            BeanUtils.populate(stu,request.getParameterMap());//该代码直接将数据封装到student 类里面
            System.out.println("封装前："+stu);
        } catch(Exception e)
        {
         e.getStackTrace();
        }
    }
}
