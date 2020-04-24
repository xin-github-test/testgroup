<%@ page import="com.itheima.entity.student" %><%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/2
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%
     student stu=new student();
     stu.setName("tom");
     out.print(stu.getName());
 %>
<jsp:useBean id="stu1" class="com.itheima.entity.student"></jsp:useBean> <%-- new一个类--%>
<jsp:setProperty name="stu" property="name" value="cat"></jsp:setProperty><%-- 调用set方法--%>
<jsp:getProperty name="stu" property="name" ></jsp:getProperty><%-- 调用get方法--%>
<jsp:forward page="jsp_demo2.jsp"></jsp:forward><%-- 转发，其中中间可以传值 <jsp:<param name="name" value="123"/>--%>
</body>
</html>
