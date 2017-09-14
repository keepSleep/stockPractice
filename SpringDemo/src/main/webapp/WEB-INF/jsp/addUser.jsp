<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td>name :</td><td>${person.name}</td></tr>
<tr><td>age :</td><td>${person.age}</td></tr>
<tr><td>birthday :</td><td><fmt:formatDate value="${person.birthday}" pattern="yyyy/MM/dd" /></td></tr>
<tr><td><a href="${pageContext.request.contextPath}/form/add"><input type="button" value="返回"></a></td></tr>
</table>
</body>
</html>