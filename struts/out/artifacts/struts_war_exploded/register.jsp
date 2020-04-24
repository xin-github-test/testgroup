<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/23
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/register.action" method="post">
       用户名:<input type="text" name="username"><br/>
       密码：<input type="password" name="password"><br/>
         生日：<input type="text" name="birthday"><br>
       爱好：
      <input type="checkbox" name="hobby" value="篮球">篮球
      <input type="checkbox" name="hobby" value="游戏">游戏
      <input type="checkbox" name="hobby" value="看书">看书<br>
       已婚：
      <input type="checkbox" name="married" value="true"><br/>


         <input type="submit" value="注册">



  </form>
</body>
</html>
