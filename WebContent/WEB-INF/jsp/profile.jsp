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
	<span>Profile info</span>
	
		<c:if test="${not empty sessionScope.user}">
			<p>${sessionScope.user }</p>
			
		
		</c:if> 
	
	

</body>
</html>