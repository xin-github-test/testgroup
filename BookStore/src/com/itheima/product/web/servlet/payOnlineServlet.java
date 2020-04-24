package com.itheima.product.web.servlet;

import com.itheima.product.utils.PaymentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//提交信息给第三方支付平台
@WebServlet(name = "payOnlineServlet",urlPatterns = {"/payOnlineServlet"})
public class payOnlineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //获取用户提交的数据
        String orderid=request.getParameter("orderid");
        String money=request.getParameter("money");
       //第三方支付必须传的参数
        String p0_Cmd="Buy";
        String p1_MerId="10001126856";  //商户编号
        String p2_Order=orderid;
        String p3_Amt=money;
        String p4_Cur="CNY";
        String p5_Pid="unknow";
        String p6_Pcat="unknow";
        String p7_Pdesc="unknow";
        String p8_Url="http://localhost:8080/product/callBackServlet";
        String p9_SAF="1";
        String pa_MP="unknow";
        String pd_FrpId=request.getParameter("yh");
        String pr_NeedResponse="1";

        String hmac=PaymentUtil.buildHmac(p0_Cmd,p1_MerId,p2_Order,p3_Amt,p4_Cur,p5_Pid,p6_Pcat,p7_Pdesc,p8_Url,p9_SAF,pa_MP,pd_FrpId,pr_NeedResponse,"69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");

         //response.sendRedirect("https://www.yeepay.com/app-merchant-proxy/node");
      request.setAttribute("p0_Cmd",p0_Cmd);
      request.setAttribute("p1_MerId",p1_MerId);
      request.setAttribute("p2_Order",p2_Order);
      request.setAttribute("p3_Amt",p3_Amt);
      request.setAttribute("p4_Cur",p4_Cur);
      request.setAttribute("p5_Pid",p5_Pid);
      request.setAttribute("p6_Pcat",p6_Pcat);
      request.setAttribute("p7_Pdesc",p7_Pdesc);
      request.setAttribute("p8_Url",p8_Url);
      request.setAttribute("p9_SAF",p9_SAF);
      request.setAttribute("pa_MP",pa_MP);
      request.setAttribute("pd_FrpId",pd_FrpId);
      request.setAttribute("pr_NeedResponse",pr_NeedResponse);
      request.setAttribute("hmac",hmac);
      request.getRequestDispatcher("/comfirm.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request,response);
    }
}
