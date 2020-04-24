<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/9
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通循环</title>
</head>
<body>
  <c:forEach var="i" begin="1" end="10" step="1">${i}<br></c:forEach><!-- 相当于for(i=1;i<=10;i++) print(i)-->

<%
    List list=new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

request.setAttribute("list",list);
%>
  <table border="1">
      <tr>
           <th>数据</th>
           <th>索引</th>
           <th>计数</th>
           <th>第一个</th>
           <th>最后一个</th>
      </tr>
      <c:forEach items="${list}" var="l" varStatus="vs"><!-- vs是一个对象-->
      <tr ${vs.count%2==0 ? "style='background-color:lime'" :""}><!--改变行的颜色 -->
          <td>${l}</td>  <!-- 获取数据-->
          <td>${vs.index}</td> <!-- 获取索引-->
          <td>${vs.count}</td><!--计算个数-->
          <td>${vs.first}</td><!-- 获取第一个元素-->
          <td>${vs.last}</td><!-- 获取最后一个元素-->
      </tr>
      </c:forEach>
  </table>

</body>
</html>
