<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/6
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>contextmap</title>
</head>
<body>
<%--借助struts2中的debug标签查看里面的内容 --%>
<s:debug/>
<%
    session.setAttribute("user","test");
%>

</body>
</html>
