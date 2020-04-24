<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/13
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkboxlist标签的使用</title>
</head>
<body>
<s:form action="save">
    <%-- checkboxlist是在表单中生成一些复选框，list的取值是一个OGNL表达式--%>
<s:checkboxlist name="hobby" list="hobbyarr">

</s:checkboxlist>
    <s:submit value="提交"/>
</s:form>
<s:debug/>
</body>
</html>
