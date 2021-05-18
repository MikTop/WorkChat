<%@page import="jakarta.servlet.jsp.PageContext"%>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath}/registration" method="post" >
	
		<label for="firstName">First Name:
			<input name="firstName" type="text" id="firstNameId" required>
		</label><br>
		
		<label for="secondName">Second Name:
			<input name="secondName" type="text" id="secondNameId" required>
		</label><br>
		
		<label for="email">Email:
			<input name="email" type="text" id="emailId" required>
		</label><br>
		
		<label for="password">Password:
			<input name="password" type="text" id="passwordId" required>
		</label><br>
		
		<label for="birthday">Birthday Date:
			<input name="birthday" type="date" id="birthdayId" required>
		</label><br>
		
		<label for="role">Role:
			<br>
			<c:forEach var="role" items="${requestScope.roles}">
			<input name="role" type="radio" value="${role}"> ${role}<br>
			</c:forEach>
		</label><br>
		<button type="submit" >Send</button>
		
		
		
	
	</form>
</body>
</html>