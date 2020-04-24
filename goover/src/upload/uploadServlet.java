package upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "uploadServlet",urlPatterns = {"/uploadServlet"})
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** 一旦enctype改了之后，用下面的方法就提取不出来表单中的数据了
         * String name = request.getParameter("name");
         *         String photo = request.getParameter("photo");
         *         System.out.println(name);
         *         System.out.println(photo);
         */
        //此时就需要用io流来获取数据了
        InputStream is=request.getInputStream();
        int len=0;
        byte[] b=new byte[1024];
        while((len=is.read(b))!=-1)
        {
            System.out.println(new String(b,0,len));
        }
        is.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
