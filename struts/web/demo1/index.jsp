<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/13
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Struts2的入门案例</title>
  </head>
  <body>
    <%-- 在struts2中，控制器会默认拦截扩展名为.action的请求（以.action为后缀的url).除此之外，什么都不写也可以 --%>
   <a href="${pageContext.request.contextPath}/action3.action">访问struts2的第一个入门案例</a>
   <a href="${pageContext.request.contextPath}/action3">访问struts2的第一个入门案例</a>

    <a href="${pageContext.request.contextPath}/action66">demo4</a>
   <%-- 动态方法调用(不安全）(使用动态调用需要先开启服务，在struts2中将struts.enable.DynamicMethodInvocation的值设置为true,默认为false)
    动作名称！动作方法名称.action
    动作名称!动作方法名称
    <a href="/user!addUser.action">添加用户</a>
    --%>
  </body>
</html>
