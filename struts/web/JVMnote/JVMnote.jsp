<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/15
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JVM</title>
</head>
<body>
 JVM的生命周期：
   1.虚拟机的启动：java虚拟机的启动是通过引导类加载器（bootstrap class loader）创建一个初始类（initial class)
        来完成的，这个类是由虚拟机的具体实现指定的
   2.虚拟机的执行：
       1）一个运行中的java虚拟机有着一个清晰的任务：执行java程序
       2）程序开始执行时它才运行，程序结束时他就停止
       3）执行一个所谓的java程序的时候，真真正正在执行的是一个叫做java虚拟机的的进程
   3.虚拟机的退出
       有如下的几种情况：
       1）程序正常执行结束
       2）程序在执行过程中遇到了异常或错误而异常终止
       3）由于操作系统出现错误而导致java虚拟机进程终止
       4）某线程第哦啊用Runtime类或System类的exit方法，或Runtime类的halt方法，并且java安全管理器也允许这次的exit和halt操作
       5）除此之外，JNI（Java native interface)规范描述了用JNI Invacation API来加载或卸载java虚拟机时，java虚拟机退出的情况
</body>
</html>
