<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/1
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp基本语法</title>
</head>
<body>
   <%! int num1=10;%>  <%--定义全局变量--%>

<%
   num1++;
%><%-- 代码  --%>


<%=num1%> <%-- 输出  --%>
</body>
</html>
