<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/19
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   登陆：<input type="text" name="username"/><br>
   密码：<input type="password" name="password"/><br/>
   验证码：<input type="text" name="validateCode"/><img src="${pageContext.request.contextPath}/zi.action">
</body>
</html>

