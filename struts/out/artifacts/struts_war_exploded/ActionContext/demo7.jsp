<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/13
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一个表单的小例子</title>
</head>
<body>
 <s:form action="saveCustomer">
     <s:textfield name="name" label="用户名"/>
     <s:password name="password" label="密码"/>
     <s:checkbox name="married" label="已婚" value="true"/>
     <s:checkboxlist name="hobby" list="{'摄影','旅行','足球'}" label="爱好"/>
     <s:select name="city" list="#{'BJ':'北京','SH':'上海','SZ':'苏州'}" label="故乡" headerKey="" headerValue="---请选择---"></s:select>
     <s:textarea name="description" label="个人介绍" rows="5" cols="25"/>
     <s:radio list="#{'femal':'女','male':'男'}" name="gender" value="'male'" label="性别"/> <%--此处的value是一个OGNL表达式 --%>
      <s:submit value="提交"/> <s:reset value="重置"/>

 </s:form>
</body>
</html>
