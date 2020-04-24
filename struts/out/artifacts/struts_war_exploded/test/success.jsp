<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/3/31
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>struts2中的国际化</title>
</head>
<body>
struts2中的国际化，在jsp页面访问消息资源包必须使用struts2的标签
<s:text name="key"/>
<%--注意：当只访问jsp页面的时候就只会访问全局的消息资源包，如果通过动作类访问的话，就是就近原则--%>
<s:text name="abc"/><%-- 当资源文件中没有这个key的话，就将name属性中的值直接输出--%>
<%-- i18n标签，读取指定的资源包--%>
<s:i18n name="test.message"/>
<s:text name="key"/>
<%-- 当自由访问的资源不存在时，按照资源包的所搜顺序查找
  其搜索顺序：1.动作类信息资源 2.interface.properties 3.BaseClass.properties 4.ModelDriven's model 5.package.properties
  6.search up the i18n message key hierarchy itself
  7.global resource properties 详见官方文档
--%>
</body>
</html>
