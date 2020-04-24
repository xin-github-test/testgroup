<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2020/4/13
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>struts2中的其它标签的使用</title>
</head>
<body>
 <br/>-------s:set--------<br/>
 <%--s:set标签
   value属性：取值是一个OGNL表达式
   var属性：一个普通的字符串，它把value属性的值作为value，把var属性的值作为key，存到ActionContext的大Map中--%>
 <s:set value="'test'" var="str"/>
 <br/>-------s:action--------<br/>
 <%--s:action标签
     name属性是指定一个动作名称，它并不会真的去执行
      executeResult属性：是否执行action,取值是true和false--%>
 <s:action name="action1" executeResult="true"/>
 <br/>-------s:if s:ifelse s:else--------<br/>
 <%-- 条件判断的标签--%>
  <s:set value="'D'" var="grade"/>
  <s:if test="#grade=='D'">差</s:if>
  <s:elseif test="#grade=='C'">中</s:elseif>
  <s:else >其它</s:else>
 <br/>-------s:url--------<br/>
  <%--s:url标签
    value属性：把值直接输出到页面上
    action属性：把动作的请求地址输出到页面上（${pageContext.request.contextPath}/action1}
    var属性：把action的取值作为value,将var的取值作为key，放入Action Context中--%>
  <s:url value="action1"/>
  <s:url action="action1" var="url">
      <%--把name作为key value作为值，绑定到请求连接上，相当于get方式拼接请求参数
        注意：value属性的值是一个OGNL表达式，而name的取值就是一个普通的字符串--%>
      <s:param name="name" value="'张三'"></s:param>
  </s:url>
  <a href="<s:property value='#url'/> ">点击</a><%--会自动变化扩展名，当动作类的扩展名.action被换了之后也可以访问到资源 --%>
3.struts2中#、$,%符号的使用（重要）
   1.#
     a.取contextMap中的key时使用，例：<s:property value="#name"/>
     b.OGNL中创建Map对象时使用,例：<s:radio list="#{'male':'男','female':'女'}"/>
   2.$
     a.在jsp中使用EL表达式时使用，例${name}
     b.在xml配置文件中编写OGNL表达式时使用，例如文件下载时，文件名编码
        例：struts.xml-->${@java.net.URLEconder.encode{filename}
   3.%
    在strtus2中，有些标签的value属性取值就是一个OGNL表达式，；例如
     <s:property value="OGNL Expression"/>
     还有一部分标签，value属性的取值就是普通的字符串，例如<s:textfield value="username"/> 如果想把一个普通的字符串强制看成OGNL，就需要使用%{}把字符串套起来
     例：<s:textfield value="%{username}"/>。当然在<s:property value="%{OGNL Experssion}"/>也可以使用，但一般不会这么用

</body>
</html>
