<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/30
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:actionerror/>
 <s:form action="addStudent.action">
     <s:textfield name="username" label="用户名"/>
     <s:textfield name="age" label="年龄"/>
     <s:textfield name="email" label="邮箱"/>
     <s:textfield name="password" label="密码"/>
     <s:password name="repassword" label="再输入一次密码"/>
     <s:textfield name="score" label="成绩"/>
     <s:textfield name="url" label="个人主页"/>
     <%-- list中的取值是生成一个list集合，并往集合中放入元素--%>
     <s:radio list="{'男','女'}" name="gender" label="性别"/>
     <s:submit value="注册"/>

     
 </s:form>
</body>
</html>
