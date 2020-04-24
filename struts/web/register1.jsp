<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/23
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--   导包    --%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>用户注册,使用的是struts2的标签</title>

</head>
<body>
<%--<s:actionerror/>&lt;%&ndash;动作错误&ndash;%&gt;--%>
<%--<s:fielderror/> &lt;%&ndash; 字段错误&ndash;%&gt;--%>
<%--
struts的form标签，他提供了几乎和原始html表单标签一致的属性
action:请求的地址，可以直接写动作名称，不用写contextpath
method:请求的方式，在这里不用写，struts默认的就是post
enctype:表单编码的MIME类型
--%>
<s:form action="register.action">
  <s:textfield name="username" label="用户名"/>
    <s:password name="password" label="密码"/>
    <s:textfield name="birthday" label="生日"/>
    <s:submit value="注册"/>
</s:form>
  <%--<form action="${pageContext.request.contextPath}/register.action" method="post">
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



  </form>--%>
</body>
</html>
