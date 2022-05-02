<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${sessionScope.accountInfo.name }님 반갑습니다
	<button onclick="location.href='LoginController'">로그아웃</button>
	
</body>
</html>