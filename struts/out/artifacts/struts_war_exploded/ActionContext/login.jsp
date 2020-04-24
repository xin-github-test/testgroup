<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/14
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>struts2中的表单重复提交</title>
</head>
<body>
<%-- 使用struts2的内置标签 s:token防止重复提交--%>
  <s:form action="login1">
      <s:token></s:token>
      <s:textfield name="name" label="用户名"/>
      <s:submit value="提交"/>


  </s:form>
</body>
</html>
