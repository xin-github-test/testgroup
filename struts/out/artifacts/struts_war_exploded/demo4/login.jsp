<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/1
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
 <form action="${pageContext.request.contextPath}/login.action" method="post">
      用户名：<input type="text" name="username"/><br/>
      密码：<input type="password" name="password"/><br/>
     <input type="submit" value="登陆"/>
 </form>
</body>
</html>
