<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/11/29
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  欢迎你:<%
      String userName = request.getParameter("userName");
      out.print(userName);

  %>
hi
</body>
</html>
