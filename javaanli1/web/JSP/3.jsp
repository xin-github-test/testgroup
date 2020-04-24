<%@ page import="com.itheima.entity.student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/8
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
       student stu=(student)request.getAttribute("s");
       out.print(stu);
       List list=new ArrayList();
       list.add("aaa");
       list.add("bbb");
       list.add("ccc");
       request.setAttribute("l",list);//要想取到值必须先将其封装到域中
       Map map=new HashMap();
       map.put("1","aaa");
       map.put("2","bbb");
       map.put("3","ccc");
       request.setAttribute("m",map);
   %>
   <!-- 获取数据-->
${s.name}   <%-- el表达式,直接获取request，session中s存的对象 ,底层代码为pageContext.findAttribute() ，若是没有值则为字符的空--%>
   ${s['name']}<!--具有上面一样的功能但多了一些上面没有的功能 -->
${l[1]}  <!--取出list中的第二个值 -->
${m["3"]}<!--取出Map中键为3的值或者m.b而list则无法直接点 -->
</body>
</html>
