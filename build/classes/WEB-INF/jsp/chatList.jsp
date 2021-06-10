<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<h1>Your chats</h1>
	
	<ul>
		<c:forEach var = "chat" items="${requestScope.chats }">
					<li>
						<form action="${pageContext.request.contextPath}/chat" method="get">
						<input value="${chat.chatId}" name="chatId" hidden="true">
						<button type="submit">${chat.chatId}</button>					
						</form>
					</li>
		</c:forEach>
	
	
	</ul>
</body>
</html>