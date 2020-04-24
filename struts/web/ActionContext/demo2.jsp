<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
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
    <title>取value Stack中的数据</title>
</head>
<body>
<!--使用s:property 标签，获取ValueStack的元素
  value属性的取值是一个OGNL表达式，他只获取元素中的属性-->

<!--注意：取VakueStack中的元素的时候，不使用#号
    他是从栈顶逐个对象查找指定的属性的名称，只要找到了就不再继续寻找-->

<s:debug/>

<s:property value="name"/>
<s:property value="name"/>


  <!-- 若要寻找指定位置的属性，可以用下列的方法-->
<s:property value="[1].name"/>
<s:property value="[2].name"/>
<s:debug/>
<!--取栈顶map的元素 -->
<s:property value="s1.name"/>
<s:property value="s2.name"/>
<!-- 当s:pproperty 中什么都不写
   默认取栈顶元素-->
<s:property/>
<%
    //valuestack取值的原理：模拟原理和el类似
     //取值的方法都是findValue 和findString
    ValueStack vs=ActionContext.getContext().getValueStack();
    Object obj = vs.findValue("name");
    out.print("<br/>----------------<br/>");
    out.print(obj);

%>
</body>
</html>
