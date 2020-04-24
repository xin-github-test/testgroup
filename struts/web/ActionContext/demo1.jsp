<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/7
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>取ActionContext的数据</title>
</head>
<body>
  <s:debug/>
<!-- 使用s:property 来获取ActionContext中的数据
   value属性是一个OGNL表达式
   取值的时候用#key值-->
<br/>------------------获取大Map中的数据---------------------<br/>
    <s:property value="#contextMap"/><!--这里可以不用写#号 -->
  <br/>------------------获取大Map中小Map的数据---------------------<br/>
    <s:property value="#session.sessionmap"/><!--这里必须写#号 -->

</body>
</html>
