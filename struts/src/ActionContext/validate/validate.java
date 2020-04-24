package ActionContext.validate;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "validate",urlPatterns ={"/validate"})
public class validate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=200;
        int height=35;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g=image.getGraphics();

        g.setColor(Color.gray);
        g.fillRect(1,1,width,height);

        g.setColor(Color.white);
        g.drawRect(1,1,width,height);

        g.setColor(Color.black);
        Random random=new Random();
        for(int i = 0;i<10 ;i++) {
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }
        Font f=new Font("宋体",Font.BOLD,30);
        g.setFont(f);
        g.setColor(Color.RED);
        int x=30;
        for(int i=0;i<4;i++) {
            g.drawString(String.valueOf(random.nextInt(10)),x,25);
            x+=30;
        }
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
