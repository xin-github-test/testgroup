<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/2
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>struts2的文件上传</title>
</head>
<body>
 <%--文件上传的必要前提
     1.请求方式必须是post
     2.enctype属性的值必须是multipart/form-date
     3.提供一个文件选择域--%>
  <s:form action="upload.action" method="POST" enctype="multipart/form-data">
        <s:textfield name="username" label="用户名"/>

        <s:file  name="photo" label="照片"/>
        <s:file  name="photo" label="照片"/>
        <s:submit value="上传"/>
  </s:form>
 </body>
</html>
