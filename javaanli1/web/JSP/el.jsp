<%@ page import="com.itheima.entity.student" %><%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/8
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- 引入标签库 -->
<html>
<head>
    <title>el</title>
</head>
<body>
 <%
     student stu=new student();
     stu.setName("tom");
     request.setAttribute("s",stu);
     request.getRequestDispatcher("3.jsp").forward(request,response );
 %>
</body>
</html>
