package upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "uploadServlet1",urlPatterns = {"/uploadServlet1"})
public class uploadServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //解决上传表单乱码的第一种方法,但这种方法的优先级不高，所以一般不用
        //request.setCharacterEncoding("UTF-8");

     //判断表单是否支持文件上传 即是否有：enctype="multipart/form-data"
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
     if(!multipartContent)
     {
         throw new RuntimeException("your form is not multipart/form-data!");
     }
     //创建一个DiskFileItemFactory
        DiskFileItemFactory factory=new DiskFileItemFactory();//有一个上传文件的限制（10kb)，但是不会影响上传，只是大于这个大小时，会产生一个与上传文件同样大小的临时文件
      factory.setRepository(new File("F:\\"));//设置临时文件的存储目录
        //创建一个ServletFileUpload核心对象
       ServletFileUpload sfu=new ServletFileUpload(factory);

       //解决上传表单项（不能解决普通表单项）乱码的第二种方法，ServletFileUpload自带的方法
        sfu.setHeaderEncoding("UTF-8");


       //解析request对象，并得到一个表单项的集合
        try {
            //限制上传文件的大小
            sfu.setFileSizeMax(1024*1024*3);//大小为3M
            sfu.setSizeMax(1024*1024*6);//总上传文件的大小不能超过3M
            List<FileItem> fileItems = sfu.parseRequest(request);
        //遍历表单项的数据
            for (FileItem fileItem:
                 fileItems) {
                if(fileItem.isFormField())
                {
                    //普通表单项
                    processFormField(fileItem);
                }else
                {
                    //上传表单项
                    processUploadField(fileItem);
                }

            }


        } catch (FileUploadBase.FileSizeLimitExceededException e)
        {
          //throw new RuntimeException("上传文件大小超过限制！");
            System.out.println("上传文件大小超过限制！");
        }catch (FileUploadBase.SizeLimitExceededException e)
        {
            System.out.println("上传文件大小超过限制！");
        }
        catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    private void processUploadField(FileItem fileItem) {
          //得到上传的文件名字
        String filename=fileItem.getName();//得到的是上传文件的名称 此处可能会有错误，可能得到文件的正确名称（a.txt)，也可能得到自己的磁盘路径加上文件的名称(E:\a.txt

        try {
            //得到文件的输入流
            InputStream is=fileItem.getInputStream();
           //创建一个文件存盘的目录
            String directoryRealPath=this.getServletContext().getRealPath("/WEB-INF/load");//加上/WEB-INF,可以防止恶意访问

            File storeDirectory =new File(directoryRealPath);//既代表文件又代表目录
            if(!storeDirectory.exists())
            {
                storeDirectory.mkdir();//创建一个指定的目录（当该目录不存在时）
            }
          //第一种方法 filename=filename.substring(filename.lastIndexOf(File.separator)+1);//防止名称出错
            //第二种方法
            if(filename!=null)
            {
                filename=FilenameUtils.getName(filename);
            }
            //防止文件重名
            filename=UUID.randomUUID()+"_"+filename;
            //目录打散（按时间）
            String childDirectory=makeChildDirectory( storeDirectory,filename);

            //在storeDirectory下，创建完整目录下的文件
            File file=new File(storeDirectory,childDirectory+File.separator+filename);
            //通过文件输出流将上传的文件保存到磁盘
            //此处有一个更简单的方法(fileItem提供了write的方法，可以将内容写入文件中,且会自动删除临时文件（可能有时候会删除不了）
            //fileItem.write(file);
            FileOutputStream fos=new FileOutputStream(file);

            int len=0;
            byte[] b=new byte[1024];
            while((len=is.read(b))!=-1)
            {
               fos.write(b,0,len);
            }
            fos.close();
            is.close();

             fileItem.delete();//删除临时文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//该方法还是不完善
   /* private String makeChildDirectory(File storeDirectory) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateDirectory = sdf.format(new Date());
       File file=new File(storeDirectory,dateDirectory);
       if(!file.exists())
       {
           file.mkdirs();
       }
        return dateDirectory;
    }*/
//另一种方法
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
    private void processFormField(FileItem fileItem) {
       String fieldname=fileItem.getFieldName();//字段名
        String fieldvalue= null;//字段值
        try {
            fieldvalue = fileItem.getString("utf-8");//解决乱码问题
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(fieldname+"="+fieldvalue);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doPost(request,response);
    }
}
