<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/8
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>jstl通用标签set,out,remove</title>

</head>
<body>
<!-- 声明一个num变量 作用域为session默认为本页面-->
<c:set var="num" value="10" scope="session"></c:set>
<c:out value="${num}"></c:out><!-- 输出-->
${num} <!-- 直接这样写效果一样 -->
<c:remove var="num" scope="session"/><!-- 移除变量-->
输入<c:out value="${num}" default="aaa"></c:out><!-- 输出,若无值则输出default里面的值-->

</body>
</html>
