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
	<table id="regTbl">
		<tr>
			<td colspan="2" id="title">회원 정보</td>
		</tr>
		<tr>
			<td class="regTd1">이름</td>
			<td class="regTd2">${sessionScope.userInfo.name }</td>
		</tr>
		<tr>
			<td class="regTd1">ID</td>
			<td class="regTd2">${sessionScope.userInfo.id }</td>
		</tr>
		<tr>
			<td class="regTd1">성별</td>
			<td class="regTd2">${sessionScope.userInfo.gender }</td>
		</tr>
		<tr>
			<td class="regTd1">주소</td>
			<td class="regTd2">${sessionScope.userInfo.addr }</td>
		</tr>
		<tr>
			<td class="regTd1">관심사</td>
			<td class="regTd2">
				<c:forEach var="i" items="${inter }">
					${i }  &nbsp;&nbsp;
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="regTd1">자기소개</td>
			<td class="regTd2">${sessionScope.userInfo.introduce }</td>
		</tr>
		<tr>
			<td class="regTd1">프사</td>
			<td class="regTd2"><img src="file/${sessionScope.userInfo.img }"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="loginBtn" onclick="location.href='UpdateAccountC'">수정</button>
				<button class="loginBtn" onclick="deleteAccount('${sessionScope.userInfo.id }')">탈퇴</button>
			</td>
		</tr>
	</table>
</body>
</html>