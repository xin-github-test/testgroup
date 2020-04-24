<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/2/1
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/myJS.js"></script>
    <title>Title</title>
    <script>
        //光标离开触发该代码
        // function ckName() {
        //     //获取用户名
        //     var name=document.getElementsByTagName("input")[0];
        //     //创建XMLHttpRequest对象
        //     var xhr=getXMLHttpRequest();
        //        //处理结果
        //       xhr.onreadystatechange=function()
        //       {
        //           if(xhr.readyState==4)    //请求一切正常
        //           {
        //               if(xhr.status==200) //服务器响应一切正常
        //               {
        //                   var msg=document.getElementById("msg");
        //                     //alert(xhr.responseText);
        //                   if(xhr.responseText=="true")
        //                   {
        //                     msg.innerHTML="<font color='red'>用户名已存在！</font>"; //此处能加样式，下面的不可以
        //                       //msg.innerText="<font color='red'>用户名已存在！</font>"
        //                   }else
        //                   {
        //                       msg.innerHTML="用户名可以使用！";
        //                   }
        //               }
        //           }
        //       }
            //创建连接
              <%--xhr.open("get","${pageContext.request.contextPath}/ckNameServlet?name="+name.value);--%>
            <%--//发送请求--%>
            <%--xhr.send(null);--%>
        <%--}--%>
        window.onload=function () {//简化input的输入框，很实用的一种触发事件的写代码的方法
            var nameElement=document.getElementsByName("username")[0];
            nameElement.onblur=function () {
                var name=this.value;
                var xhr=getXMLHttpRequest();
                //处理结果
                xhr.onreadystatechange=function()
                {
                    if(xhr.readyState==4)    //请求一切正常
                    {
                        if(xhr.status==200) //服务器响应一切正常
                        {
                            var msg=document.getElementById("msg");
                            //alert(xhr.responseText);
                            if(xhr.responseText=="true")
                            {
                                msg.innerHTML="<font color='red'>用户名已存在！</font>"; //此处能加样式，下面的不可以
                                //msg.innerText="<font color='red'>用户名已存在！</font>"
                            }else
                            {
                                msg.innerHTML="用户名可以使用！";
                            }
                        }
                    }
                }
                //创建连接
                xhr.open("get","${pageContext.request.contextPath}/ckNameServlet?name="+name);
                //发送请求
                xhr.send(null);

            }


        }
    </script>
</head>
<body>
 用户名：<input type="text" name="username" ><span id="msg"></span><br>
 密码：<input type="password" name="password"><br>

</body>
</html>
