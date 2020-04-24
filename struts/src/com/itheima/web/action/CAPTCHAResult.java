package com.itheima.web.action;

import cn.dsna.util.images.ValidateCode;
import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import javax.servlet.http.HttpServletResponse;

/**
 * 自定义结果视图的类型
 *
 *
 */
public class CAPTCHAResult extends StrutsResultSupport {
    //通过修改配置文件设置验证码的大小
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    protected void doExecute(String s, ActionInvocation actionInvocation) throws Exception {
        ValidateCode vc =new ValidateCode(width,height,4,10);
        HttpServletResponse response=ServletActionContext.getResponse();
        vc.write( response.getOutputStream());
    }
}
