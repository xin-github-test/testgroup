<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>jstl 条件标签 if choose</title>
</head>
<body>
 <c:if test="${5>3}">aaaa</c:if><!-- 若条件为真则输出中间的值,没有否则-->
 <c:if test="${5<3}">bbb</c:if><!-- 否则只能用这种方式表达-->

 <c:set value="${3}" var="num" scope="session"></c:set>
<c:choose>  <!-- 相当于switch 语句-->
  <c:when test="${num==3}">aa</c:when>
  <c:when test="${num==4}">bb</c:when>
  <c:when test="${num==5}">cc</c:when>
    <c:otherwise>dd</c:otherwise>

</c:choose>
</body>
</html>
