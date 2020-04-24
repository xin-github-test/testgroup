<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/2/1
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/myJS.js"></script><!--导入外部js代码的标签中间不能用来写js代码 -->
    <title>Ajax</title>
</head>
<body>
<script type="text/javascript">
     window.onload=function () {
         //1.获取XMLHttpRequest对象
         var req=getXMLHttpRequest();
         //4.处理响应结果（一般写在open()之前）
         req.onreadystatechange=function()
         {
             //alert(req.readyState);//不一定从0开始，因为可能执行太快，没有触发事件
           if(req.readyState==4)
           {
               //alert(req.status);//查看服务器响应状态
               if(req.status==200)
               {
                  alert(req.responseText);
               }
           }

         }
         //2.建立一个连接
         req.open("get","${pageContext.request.contextPath}/servletDemo1");
          //3.发送请求
         req.send(null);

    alert(xmlhttp);
     }
</script>
</body>
</html>
