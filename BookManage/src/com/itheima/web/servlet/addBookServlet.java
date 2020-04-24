package com.itheima.web.servlet;

import com.itheima.Service.BookServiceImpl;
import com.itheima.domain.Book;
import com.itheima.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "addBookServlet",urlPatterns = {"/addBookServlet"})
public class addBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //当有上传文件型的表单时，下面的获取数据的方法就不行了
        /*request.setCharacterEncoding("UTF-8");
   response.setContentType("text/html;charset=UTF-8");
        //获取表单数据
   Book book=new Book();
        try {
            BeanUtils.populate(book,request.getParameterMap());//注意不要导错包（此处是apache的，不是sun的）
            book.setId(UUIDUtils.getUUID());//手动生成一个id
        } catch (Exception e) {

            e.printStackTrace();
        }
        //调用业务逻辑
        BookServiceImpl bs=new BookServiceImpl();
        bs.addBook(book);
        //分发转向
        request.getRequestDispatcher("bookListServlet").forward(request,response);//向查询的servlet跳转，相当于刷新的效果*/
    //当有上传文件的表单项的时候就需要用另一种方式来获取表单数据
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //核心对象，解析request
        ServletFileUpload sfu=new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");//解决上传文件的乱码
        List<FileItem> fileItems=new ArrayList<>();
        Map<String,String[]> map=new HashMap<>();
        try {
            fileItems = sfu.parseRequest(request);
            //迭代
            for (FileItem fileitem:fileItems
                 ) {
                if(fileitem.isFormField()) //普通表单项
                {
                    String name=fileitem.getFieldName();//得到字段的名
                    String value=fileitem.getString("UTF-8");//得到字段的值
                    map.put(name,new String[]{value});//将普通表单项加入map中


                }else  //文件上传表单项
                {
                    InputStream is =fileitem.getInputStream();
                    String filename=fileitem.getName();
                    String extension = FilenameUtils.getExtension(filename);
                    if(!("jsp".equals(extension)||"exe".equals(extension)))//上传的文件不能是jsp或exe
                    {
                        File storeDirectory=new File(this.getServletContext().getRealPath("/upload"));
                        System.out.println(storeDirectory);
                        if(!storeDirectory.exists())
                        {
                            storeDirectory.mkdir();
                        }
                        //目录打散（按时间）
                        String childDirectory=makeChildDirectory( storeDirectory,filename);
                        if(filename!=null)
                        {
                            //处理一下文件名
                            filename=FilenameUtils.getName(filename);
                        }
                        filename= childDirectory+File.separator+filename;

                        fileitem.write(new File(storeDirectory,filename));
                        fileitem.delete();//删除缓存文件
                    }
                    map.put(fileitem.getFieldName(),new String []{filename});//将图片表单加入map集合中

                }
            }
            Book book=new Book();
            BeanUtils.populate(book,map);
            book.setId(UUIDUtils.getUUID());
            //调用业务逻辑
            BookServiceImpl bs=new BookServiceImpl();
            bs.addBook(book);

            //分发转向
            request.getRequestDispatcher("bookListServlet").forward(request,response);//向查询的servlet跳转，相当于刷新的效果
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private String makeChildDirectory(File storeDirectory,String filename)
    {
        int hashcode=filename.hashCode(); //返回字符转换称的32位hashcode码
        System.out.println(hashcode);
        String code=Integer.toHexString(hashcode);//把hashcode转换为16进制的字符
        System.out.println(code);
        String childDirectory=code.charAt(0)+File.separator+code.charAt(1);
        //创建指定的目录
        File file=new File(storeDirectory,childDirectory);
        if(!file.exists())
        {
            file.mkdirs();
        }
        return childDirectory;
    }
}
