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
	<h1>${r}</h1>
	
	<table border="1">
<c:forEach var="i" items="${p }">
		<tr>
			<td>${i.name }</td>
			<td>${i.age }</td>
		</tr>
</c:forEach>
	</table>
	
</body>
</html>