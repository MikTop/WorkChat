<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	
		<ul>
			<c:forEach var="message" items="${requestScope.messages}">
				<li>
					<p>
						<span>Sender:${message.senderId} Date:${message.sendDate}</span><br>
						<span>${message.message} </span><br>
					</p>
				</li>
			</c:forEach>
		</ul>
	
	<form action="${pageContext.request.contextPath}/chat" method="post">
		<label for="newMessage">New message:
			<input name="newMessage" type="text" id="messageId" required>
			<input name="chatId" type="hidden" value="${requestScope.chatId}">
		</label><br>
		<button type="submit">Send</button>
	</form>
	
</body>
</html>