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
	here is hello!!
	
	<h1>SpringMVC�ɮפW�ǽm��</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br> 
		<input type="submit" value="submit">
	</form>
	
	<form action="param" method="get">
		<input type="text" name="name" placeholder="name"> 
		<input type="text" name="id" placeholder="id">
		<input type="submit" value="submit"><br>
		 name: ${name} <br> 
		 id: ${id}
	</form>
	<br>
	<h1>Restful���m��</h1>
	<form action="${pageContext.request.contextPath}/rest/user/1"
		method="post">
		<input type="hidden" name="_method" value="PUT"> <input
			type="submit" value="put">
	</form>
	<form action="${pageContext.request.contextPath}/rest/user/1"
		method="post">
		<input type="submit" value="post">
	</form>
	<form action="${pageContext.request.contextPath}/rest/user/1"
		method="get">
		<input type="submit" value="get">
	</form>
	<form action="${pageContext.request.contextPath}/rest/user/1"
		method="post">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="submit" value="delete">
	</form>
	<br>

<h1>������ҽm��</h1>
<a href="${pageContext.request.contextPath}/form/add"><input type="button" value="�m�߰�"></a>

<h1>DB�s�u�q�X���</h1>
<a href="${pageContext.request.contextPath}/table/list"><input type="button" value="table�s�u"></a>

<h1>AOP���հ�</h1>
<a href="${pageContext.request.contextPath}/aop/toView"><input type="button" value="aop���հ�"></a>




</body>
</html>