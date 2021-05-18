<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
	
		<label for="email">Email:
			<input name="email" type="text" required="required">
		</label>
		<br>
		<label for="password">Password:
			<input name="password" type="password" required="required">
		</label>
		<br>
		<button type="submit">Login</button>
		<a href="${pageContext.request.contextPath}/registration">
			<button type="button">Register</button>
		</a>
	</form>
</body>
</html>