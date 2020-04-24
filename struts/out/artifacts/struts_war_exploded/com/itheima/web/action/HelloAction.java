package com.itheima.web.action;

/**
 * struts2的入门案例
 */
public class HelloAction { //动作类
    /**
     * 在动作类中的指定的动作方法
     * 动作方法是有要求的
     *   1.都是public的
     *   2.返回值必须是一个String
     *   3.必须没有参数
     * @return
     */
    public String sayHello()
    {
        System.out.println("helloAction的sayHello方法执行了！");
        return "success"; //与struts配置文件中的result中的name值一样
    }

}
