<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/13
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>s:iterstor的使用</title>
</head>
<body>
<table width="500px" border="1" align="center">
     <tr>
         <th>序号</th>
         <th>姓名</th>
         <th>年龄</th>
     </tr>
    <%--iterator迭代
     属性详解：
       begin,end,step和jstl的forEach表签市一样的
       value属性：要遍历的集合，是OGNL表达式
       var属性：取值就是一个字符串
          如果写了该属性：把var的值当作key,把当前遍历的元素作为value存到ActionContext的大Map中
          如果没写该属性：把当前遍历的元素压入栈顶
       status属性：遍历时的一些计数信息
                 int getIndex() 从0开始
                 int getCount() 从1开始
                 boolean isFirst()
                 boolean isLast()
                 boolean isOdd()
                 boolean isEven()
                 --%>
    <s:iterator value="students" var="s" status="vs" >
        <tr>
            <td><s:property value="#vs.index"/> </td>
            <td><s:property value="#s.name"/></td>
            <td><s:property value="#s.age"/></td>
        </tr>
    </s:iterator>
</table>
<hr/>
<table width="500px" border="1" align="center">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>

    <s:iterator value="students" status="vs" >
        <tr>
            <td><s:property value="#vs.index"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="age"/></td>
        </tr>
    </s:iterator>
</table>
<hr/>
<%-- OGNL的投影，添加过滤条件(以下内容了解即可）
     a."?#":过滤所有符合条件的集合，如users.{?#this.age>19}
     a."^#":过滤第一个符合条件的元素，如users.{^#this.age>19}
     a."$#":过滤最后一个符合条件的元素，如users.{$#this.age>19}
     --%>
<table width="500px" border="1" align="center">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>

    <s:iterator value="students.{?#this.age>18}" status="vs" >
        <tr>
            <td><s:property value="#vs.count"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="age"/></td>
        </tr>
    </s:iterator>
</table>
<hr/>
<%--OGNL投影：指定输出内容 --%>
<table width="500px" border="1" align="center">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>

    <s:iterator value="students.{name}" status="vs" >
        <tr>
            <td><s:property value="#vs.count"/></td>
            <td><s:property /></td>
            <td><s:property /></td>
        </tr>
    </s:iterator>
</table>
 <s:debug/>
</body>
</html>
