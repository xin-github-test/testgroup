<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="org.apache.commons.beanutils.ConvertUtils" %>
<%@ page import="javax.sql.DataSource" %><%--
  Created by IntelliJ IDEA.
  User: 小新、
  Date: 2019/12/19
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%
  Context initContext = new InitialContext();
  Context envContext  = (Context)initContext.lookup("java:/comp/env");
  DataSource ds = (DataSource)envContext.lookup("jdbc/student");
  Connection conn = ds.getConnection();//注意：mysql的数据库连接版本太低会导致错误

 out.print(conn);

%>
  </body>
</html>
