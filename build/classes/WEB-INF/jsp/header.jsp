<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:if test="${not empty sessionScope.user }">
 	<form action="${pageContext.request.contextPath}/logout" method="post">
		<button type="submit">Logout</button>
	</form>
 </c:if>
	
</body>
</html>