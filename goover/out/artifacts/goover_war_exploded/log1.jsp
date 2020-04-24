<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/2/7
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <form action="${pageContext.request.contextPath}/logServlet" method="post">

      username:<input type="text" name="username"><br>

      <input type="submit" value="登陆"><br>

  </form>
</body>
</html>
