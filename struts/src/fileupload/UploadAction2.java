package fileupload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;

/**
 *
 *struts2文件的上传案例
 */
public class UploadAction2 extends ActionSupport {
      private String username;
      private File[] photo;
      //struts2在文件上传时提供的属性
      private String[] photoFileName;//上传的文件名，上传字段名称加FileName 注意大小写
      private String[] photoContentType;//上传文件的MIME类型，上传字段名称加上ContentType 注意大小写

    public File[] getPhoto() {
        return photo;
    }

    public void setPhoto(File[] photo) {
        this.photo = photo;
    }

    public String[] getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String[] photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String[] getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String[] photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String upload()
      {
          //1.拿到servletContext对象
          ServletContext application=ServletActionContext.getServletContext();
           //2.调用realpath方法
          String filePath=application.getRealPath("/WEB-INF/files");
          File file=new File(filePath);
           if(!file.exists())
           {
               file.mkdirs();
           }
           //3.把photo存过去
            //拷贝:(把临时文件复制到指定的目录下，仍然保留临时文件）
          //FileUtils.copyFile(photo,new File(file,photoFileName));
            //剪切 （把临时文件剪切到指定的目录,并且重命名：临时文件没有了）
          for (int i = 0; i < photo.length; i++) {
              photo[i].renameTo(new File(file,photoFileName[i]));
          }

          return null;
      }
}
