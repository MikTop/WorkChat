<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile info</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<span>Profile info</span>
	
		<c:if test="${not empty sessionScope.user}">
			<span>First name: ${sessionScope.user.firstName}</span><br>
			<span>Second Name: ${sessionScope.user.secondName}</span><br>
			<span>Email: ${sessionScope.user.email}</span><br>
			<span>Image: ${sessionScope.user.image}</span><br>
			<span>Birthday: ${sessionScope.user.birthday}</span><br>
			<span>Role: ${sessionScope.user.role}</span><br>
			
		</c:if> 
	
	

</body>
</html>