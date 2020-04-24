<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/1
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" --%>
<%--@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>include</title>
</head>
<body>
bbbbbbbbb<br>
<%--@include file="jsp_demo4.jsp"--%><%-- 静态包含 只生成一个java文件--%>
<jsp:include page="jsp_demo4.jsp"></jsp:include><%-- 动态包含 生成俩个java文件 --%>
  <%-- 能用静态包含就不要使用动态包含，静态包含的编译时间短--%>
</body>
</html>
