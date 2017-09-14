<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css"
	rel="stylesheet">
<link
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
* {
	font-family: 微軟正黑體;
}
</style>
<title><sitemesh:write property='title' /></title>
</head>
<body>

	<div class="container">
		<div class="col-md-12">
			<c:import url="/WEB-INF/jsp/build/head.jsp" />
<!-- 			<div class="col-md-2"> -->
<%-- 				<c:import url="/WEB-INF/jsp/build/menu.jsp" /> --%>
<!-- 			</div> -->
			<div class="col-md-12">
				<sitemesh:write property='body'/>
			</div>
			<c:import url="/WEB-INF/jsp/build/footer.jsp" />
		</div>
	</div>
</body>
</html>