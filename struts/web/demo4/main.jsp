<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/1
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页：检查登陆的拦截器</title>
</head>
<body>
<%-- 想要来到本页面必须先登陆--%>
 主页<hr/>
 <a href="${pageContext.request.contextPath}/showOther.action">访问另一个页面</a>
</body>
</html>
