<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create chat</title>
</head>
<body>
<%@ include file="header.jsp" %>


	<form action="${pageContext.request.contextPath}/createChat" method="post">
	
		<c:forEach var="user" items="${requestScope.users}">
			<c:if test="${user.id != sessionScope.user.id}">
				<p><input type="checkbox" name="chatMembers" value="${user.id}"> ${user.firstName} ${user.secondName}</p>
			</c:if>
				
		</c:forEach>
	
		<button type="submit">Create chat</button>
	
	</form>
	
		
	
	
	
	

</body>
</html>