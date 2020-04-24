package servlet;

import cn.dsna.util.images.ValidateCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.validation.Validator;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "captcha" ,urlPatterns = {"/yzm"})
public class captcha extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //告诉浏览器不缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setIntHeader("expires",0);
        //使用工具类实现验证码
  ValidateCode vc=new ValidateCode(110,25,4,9);
        vc.write(response.getOutputStream());

    }

    private void test12(HttpServletResponse response) throws IOException {
        int  w=110;
        int h=25;

        Random a=new Random();


        BufferedImage img=new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB);//创建图片对象
        Graphics g=img.getGraphics();
        g.setColor(Color.CYAN);
        g.fillRect(1,1,w-2,h-2);

        //生成四个随机数
        g.setColor(Color.RED);
        g.drawRect(0,0,w-1,h-1);
        g.drawString(a.nextInt(11)+"",20,20);
        g.drawString(a.nextInt(11)+"",40,20);
        g.drawString(a.nextInt(11)+"",60,20);
        g.drawString(a.nextInt(11)+"",80,20);

        //生成四条干扰线
        g.setColor(Color.black);
        for (int i = 0; i < 4; i++)
        {
            g.drawLine(a.nextInt(w),a.nextInt(h),a.nextInt(w),a.nextInt(h));
        }


        g.setColor(Color.black);
        g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));

        ImageIO.write(img,"jpg",response.getOutputStream());
    }
}
