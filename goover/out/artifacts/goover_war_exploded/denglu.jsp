
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
<c:if test="${empty u}">
<a href="login.jsp">登陆</a><br>
 <a href="reg.jsp">注册</a>
</c:if>
<c:if test="${not empty u}">
   欢迎你：${u.username} <a href="${pageContext.request.contextPath}/loginOutServlet">注销</a><br>

</c:if>
</body>
</html>