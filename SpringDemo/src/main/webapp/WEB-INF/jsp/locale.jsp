<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="zh_CN"/>
	<fmt:setBundle basename="locale" var="formBundle" />
	<fmt:message key="username" bundle="${formBundle}"></fmt:message><br>
	<fmt:message key="password" bundle="${formBundle}"></fmt:message>
</body>
</html>