<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<form action="${pageContext.request.contextPath}/createChat" method="get">
	<input type="hidden" name="newChat" value="true">
	<button type="submit">Create new chat</button>
	</form>
	
</body>
</html>