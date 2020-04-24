package com.itheima.web.action;

import com.opensymphony.xwork2.Action;

/**
 * 创建动作类的第二种方式:实现xwork2的action接口
 *
 */
public class Demo2Action implements Action {
    /**
     * Action中的常量:
     *  SUCCESS  "success"   当执行成功后，前往指定的位置
     *  NONE     "none"      不返回任何结果视图，和return null一样
     *  ERROR    "error"     当执行动作方法，出现异常后，前往指定的位置
     *  INPUT    "input"     数据回显
     *  LOGIN    "login"     一般用于返回登陆页面
     * @return
     * @throws Exception
     */

    @Override//默认访问该方法
    public String execute() throws Exception {
        return null;
    }
}
