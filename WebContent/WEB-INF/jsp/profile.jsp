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
	<span>Profile info</span><br>
	
		<c:if test="${not empty sessionScope.user}">
			<img alt="Profile image" src="${pageContext.request.contextPath}/images/${sessionScope.user.image}" width="250" height="250"><br>
			<span>First name: ${sessionScope.user.firstName}</span><br>
			<span>Second Name: ${sessionScope.user.secondName}</span><br>
			<span>Email: ${sessionScope.user.email}</span><br>
			<span>Image: ${sessionScope.user.image}</span><br>
			<span>Role: ${sessionScope.user.role}</span><br>
			<a href="${pageContext.request.contextPath}/chat">
				<button type="button">Chat page</button>
			</a>
			
		</c:if> 
	
	

</body>
</html>