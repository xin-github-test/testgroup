<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/1/9
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
   <form action="${pageContext.request.contextPath}/loginServlet" method="post">
       用户名:<input type="text" name="username"><br>
       密码:<input type="password" name="password"><br>
       <input type="submit" value="登陆"><br>
   </form>
</body>
</html>
