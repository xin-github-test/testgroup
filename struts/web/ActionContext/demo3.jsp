<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/9
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式和ognl表达式</title>
</head>
<body>
 EL表达式：
 ${name} <!--这是pagecontext.findAttribute("name") -->
 <hr/>
 OGNL表达式：
 <%-- 这里的话，知道就行，自己写的话如果访问大Map中的数据的时候写上#号，
  因为如果不写的话，他会去值栈中寻找对应的属性，找不到的话，会将value的值当作key去大Map中再去找一圈，所以这里不写#可能也能访问到大Map中的数据--%>
<s:property value="name"/>
<s:debug/>
</body>
</html>
