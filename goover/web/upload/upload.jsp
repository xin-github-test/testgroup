<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/2/9
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadServlet1" method="post">
    <input type="text" name="name"><br>
 <input type="file" name="photo"><br>
    <input type="submit" value="上传"><br>
</form>
</body>
</html>
