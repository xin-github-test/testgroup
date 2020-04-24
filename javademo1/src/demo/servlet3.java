package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet3 extends HttpServlet {
    //不重写的化默认执行该类自己的方法
    @Override
protected  void doGet( HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
  int num=1;
  num++;
System.out.println("do post"+num);
}
    @Override
    protected  void doPost( HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        System.out.println("do post");

    }
}
