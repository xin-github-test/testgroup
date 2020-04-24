package download;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.InputStream;

public class DownloadAction extends ActionSupport {

    //注意：此处取名的时候不能用in,这是该框架的一个bug
    private InputStream inputStream;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String download ()throws Exception
    {
        //1.找到文件的存储路径
        String filePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/0.webp");
        //2.把文件读到一个inputStream中
         inputStream=new FileInputStream(filePath);

         filename="照片.jpg";
         //3.返回一个成功
        return SUCCESS;
    }

}
