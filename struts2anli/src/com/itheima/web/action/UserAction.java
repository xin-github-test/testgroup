package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private IUserService service=new UserServiceImpl();

    private User user=new User();
    //保存的文件
    private File upload;
    //保存的文件名
    private String uploadFileName;
    //按条件查询用户, 此时的特殊的条件是isUpload，因为他有三种情况，第一种是：请选择，代表忽略此条件
     //第二种是：有简历：只需查询有简历的用户，第三种是：无简历：寻找无简历的用户
    private String isUpload;
    public String findUserByCondition()
    {
        users=service.findUserByCondition(user.getUserName(),user.getGender(),user.getEducation(),isUpload);
        return SUCCESS;
    }
    //--------------编辑用户信息----------------------
    public String edit()
    {
       //1.判断用户是否重新上传了文件
        if(upload==null)
        {//用户没有上传新的文件,所以数据模型中的数据没有path和文件名，所以需要先从数据库中查到之前的数据，然后set进去
            User user=service.findUserById(this.user.getUserID());
            //将之前的数据放入数据模型中
            this.user.setPath(user.getPath());
            this.user.setFilename(user.getFilename());
            int res = service.modifyUser(this.user);
             if(res > 0) {
                 return SUCCESS;
             }
        }else{
          //用户上传了新的文件
            //设置文件保存路径
            String filePath =ServletActionContext.getServletContext().getRealPath("/files");
            String dir=generateChildPath(filePath);
            //生成带有随机性的文件名
            String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;

            //设置一些user中没有的属性
            user.setPath(dir);
            user.setFilename(fileName);//需要上传带有随机码的文件名，后面下载需要用

            //将文件进行上传
            upload.renameTo(new File(filePath+File.separator+dir,fileName));

            //保存用户
            int res = service.modifyUser(user);
            if(res>0)
            {
                //只有修改成功才跳转
                return SUCCESS;
            }
        }

        return null;
    }
    //--------------显示编辑页面的动作方法-------------
    public String editUI()
    {
        User user = service.findUserById(this.user.getUserID());
        ValueStack vs=ActionContext.getContext().getValueStack();
        //将获取到的用户的完整信息压入栈顶
        vs.push(user);
        return SUCCESS;
    }
    //------------删除用户-----------------
    public String delete()
    {
        int res = service.removeUser(user.getUserID());
        if(res>0) {
            //执行成功才返回到页面
            return SUCCESS;
        }
        return null;
    }

    //------------文件下载-----------------
    private InputStream inputStream;
    private String oldFileName;
    public String download() throws Exception
    {
        //1.获取用户信息
        User userdb=service.findUserById(user.getUserID());
        //2.获取文件路径
        String filePath =ServletActionContext.getServletContext().getRealPath("/files");
        //获取原文件的名称
        oldFileName=userdb.getFilename().substring(userdb.getFilename().indexOf("_")+1);
        //3.给字节输入流赋值
        inputStream = new FileInputStream(filePath+File.separator+userdb.getPath()+File.separator+userdb.getFilename());
        //4.返回成功
        return SUCCESS;
    }

    //------------查看用户详细信息-----------
    public String findUserById()
    {
        //这样直接赋值是不可取的，因为在动作方法执行之前，模型驱动user就已经被压入栈顶，此时对user赋值，并不是对栈顶的user赋值，而是对动作类中的变量user赋值
       user = service.findUserById(user.getUserID());
       //将该user压入栈中
        ValueStack vs=ActionContext.getContext().getValueStack();
        vs.push(user);
        return SUCCESS;
    }
    //------------查找所有的用户-----------------
    //用于存放查找出来的所有用户
    private List<User> users;
    public String findAll()
    {
        users = service.findAllUser();
        return SUCCESS;
    }
    //------------用户添加的方法------------------
    public String add()
    {
        //设置文件保存路径
        String filePath =ServletActionContext.getServletContext().getRealPath("/files");
        String dir=generateChildPath(filePath);
        //生成带有随机性的文件名
        String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;

        //设置一些user中没有的属性
        user.setPath(dir);
        user.setFilename(fileName);//需要上传带有随机码的文件名，后面下载需要用

        //将文件进行上传
        upload.renameTo(new File(filePath+File.separator+dir,fileName));

        //保存用户
        int res = service.saveUser(user);
        if(res>0)
        {
            //只有修改成功才跳转
            return SUCCESS;
        }
       return null;
    }
//----------------用户登陆的方法------------------
    public String login() throws Exception
    {
        User dbuser=service.login(user.getLogonName(),user.getLogonPwd());
        //判断查到了用户没有
        if(dbuser==null)
        {
            addActionError("用户不存在，或者用户名和密码不匹配！");
            return "input";
        }
        //登陆成功
        HttpSession session=ServletActionContext.getRequest().getSession();
        session.setAttribute("user",dbuser);
        return SUCCESS;
    }
    //生成文件夹
    private String generateChildPath(String filePath)
    {
        Date date=new Date();
        DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
        String dir = df.format(date);
        File file=new File(filePath,dir);
        if(!file.exists())
        {
            file.mkdirs();
        }
        return dir;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName;
    }

    public String getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }

    @Override
    public User getModel() {
        return user;
    }
}
