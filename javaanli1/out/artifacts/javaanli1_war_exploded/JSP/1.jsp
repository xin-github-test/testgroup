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
    //pageContext.setAttribute("p","pp");//在本页面创建一个变量
    pageContext.setAttribute("p","pp",PageContext.PAGE_SCOPE);//与上面等价
    //pageContext.setAttribute("p","pp",PageContext.REQUEST_SCOPE);//将该变量加到request里面
    request.setAttribute("p","request");//与上面的一句等价

    request.getRequestDispatcher("2.jsp").forward(request,response);
%>
</body>
</html>
