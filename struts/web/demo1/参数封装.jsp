<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/21
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态的参数封装</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/action4.action" method="post">
      <%-- 表单中的name属性取值必须和动作类中的数据模型的set方法后面的名称一致
      但是第二种动态参数封装需要改变一下，改成user.username和 user.age,表示是user里面的username和age--%>
      用户名:<input type="text" name="username"><br/><%--需要注意的是name属性的取值，已经不是一个普通的字符串了 --%>
      年龄:<input type="text" name="age" ><br/>   <%-- 这样提交算是动态提交--%>

          <input type="submit" value="提交"/>

  </form>
</body>
</html>
