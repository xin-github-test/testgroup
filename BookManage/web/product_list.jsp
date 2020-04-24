<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="images/productlist.gif" width="100%" height="38" />
								</div>

								<table cellspacing="0" class="booklist">
									<tr>
										<c:forEach items="${pb.books}" var="b">
										<td>

											<div class="divbookpic">
												<p>
													<a target="_blank" href="${pageContext.request.contextPath}/findBookInfoServlet?id=${b.id}"><img src="" width="115" height="129"
														border="0" /> </a>
												</p>
											</div>

											<div class="divlisttitle">
												<a target="_blank" href="${pageContext.request.contextPath}/findBookInfoServlet?id=${b.id}">书名:${b.name}<br />售价:${b.price} </a>
											</div></td>
										</c:forEach>

									</tr>
								</table>

















								<div class="pagination">
									<ul>


										<li class="disablepage"><a href="${pageContext.request.contextPath}/pageServlet?currentPage=${pb.currentPage==1?pb.currentPage:pb.currentPage-1}">&lt;&lt;上一页</a></li>
										
										
										<li>第${pb.currentPage}页/共${pb.totalPage}页</li>  <%-- 分页需要用的sql语句，limit 0,3  第一个参数是指定从第几个开始查，后面的一个参数是查几条数据，以此来实现分页 --%>

										<li class="nextPage"><a href="${pageContext.request.contextPath}/pageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.currentPage:pb.currentPage+1}">&lt;&lt;下一页</a></li>


									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
