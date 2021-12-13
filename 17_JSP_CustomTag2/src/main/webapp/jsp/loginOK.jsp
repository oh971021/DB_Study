<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${r }
	<h4 style="color: white;"> ${sessionScope.userInfo.name }님 반갑습니다. </h4>
	<button onclick="location.href='InfoAccountC'">회원정보</button>
	<button onclick="location.href='LoginController'">로그아웃</button>
</body>
</html>