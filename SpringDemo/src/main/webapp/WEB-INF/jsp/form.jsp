<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>表單驗證練習</h1>
	
	<form:form action="${pageContext.request.contextPath}/form/add" method="post" modelAttribute="person">
	<table>
	 <tr><td >name:</td><td><form:input path="name" /></td><td style="weith:100px"><span style="color:red"><form:errors path="name" /></span></td></tr>
	 <tr><td >age:</td><td><form:input path="age" /></td><td style="weith:100px"><span style="color:red"><form:errors path="age" /></span></td></tr>
	 <tr><td >birthday:</td><td><form:input path="birthday" placeholder="yyyy-MM-dd"/></td><td style="weith:100px"><span style="color:red"><form:errors path="birthday" /></span></td></tr>
	 <tr><td style="weith:50px"><input type="submit" value="submit"></td><td><a href="${pageContext.request.contextPath}/mvc/hello"><input type="button" value="回上一頁"></a></td></tr>
	</table>
	</form:form>


</body>
</html>