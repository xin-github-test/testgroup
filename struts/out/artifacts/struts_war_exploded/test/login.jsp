<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/31
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Locale locale=request.getLocale();
    ResourceBundle rb=ResourceBundle.getBundle("test.message",locale);

%>
<html>
<head>
    <title><%=rb.getString("jsp.login.title")%></title>
</head>
<body>
<%=rb.getString("jsp.login.username")%>：<input type="text" name="username"><br/>
<%=rb.getString("jsp.login.password")%>：<input type="password" name="password"><br/>
    <input type="submit" value="<%=rb.getString("jsp.login.submit")%>"><br/>
</body>
</html>
