<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/1
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  errorPage="/JSP/error.jsp" %> <%-- 指定出现异常后所需要跳转的页面--%>
<html>
<head>
    <title>error</title>
</head>
<body>
  <%
      int i=10/0;//出现异常的话，因为在page 指令里面已经设置好了出现异常所跳转的页面，所以直接显示error.jsp页面
  %>
</body>
</html>
