<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/6
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>OGNL表达式</title>
</head>
<body>
  <%--EL表达式：只能调用静态方法 --%>
  <%--OGNL表达式：可以访问普通方法
      OGNL表达式必须写在struts2的标签中
      s:property他就类似于jsp的表达式，把值输出到浏览器上--%>
<!--下面的内容直接输出的话是一个0（不再是我们所看到的字符串），因为虽然看起来是一个字符串，实际上是一个OGNL表达式
     如果想要其变成普通的字符串，就需要在值的外面再加上一个单引号-->
<s:property value="'OGNL'"/>
  <hr/>
<!--OGNL访问静态属性：
   访问静态属性的方式：@全类名@静态属性名称-->
<s:property value="@java.lang.Integer@MAX_VALUE"/>
<!--OGNL访问静态方法
    访问方式：@全类名@静态方法
     struts2的框架默认是禁用静态方法的调用的，我们可以通过配置的方式开启（defult.properties文件中，找到allowStaticMethodAccess,将其设置为true-->
 <s:property value="@java.lang.Math@random()"/>
<!-- OGNL操作Map和List
     1.创建list集合，使用的是radio标签,其中的list 属性就相当于创建了一个list集合
     list属性中的取值相当于OGNL表达式-->
<s:radio name="gender" list="{'男','女'}"></s:radio>
<%-- 使用s:radio创建一个Map集合
   {}表示创建一个list集合
   #{}表示创建一个Map集合
    其中1和0作为radio的vluue属性值，男和女作为key显示到页面--%>
<s:radio name="gender" list="#{'1':'男','0':'女'}"></s:radio>
</body>
</html>
