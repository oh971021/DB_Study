<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ReviewUpdateC" method="post">
		<table border="1" id="tbl_detail">
			<tr>
				<td colspan="2" align="center" class="d_td1"><h3>수정 페이지</h3></td>
			</tr>
			<tr>
				<td class="d_td1">글 번호</td>
				<td class="d_td2">${review.no }</td>
			</tr>
			<tr>
				<td class="d_td1">글 제목</td>
				<td class="d_td2"><input name="title" value="${review.title }"></td>
			</tr>
			<tr>
				<td class="d_td1">내용</td>
				<td class="d_td2"><input name="txt" value="${review.txt }"></td>
			</tr>
			<tr>
				<td class="d_td1">등록일</td>
				<td class="d_td2">${review.date }</td>
			</tr>
			<tr>
				<td colspan="2" class="d_td3">
					<button onclick="history.go(-2)">목록으로</button>
					<button name="no" value="${param.num }">수정확인</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>