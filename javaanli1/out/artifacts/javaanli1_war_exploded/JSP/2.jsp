<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/4
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String  p = (String )pageContext.getAttribute("p");//pageContext只能取到本页面的值，并不能取到别的页面的值

    out.print(p);
%>
</body>
</html>
