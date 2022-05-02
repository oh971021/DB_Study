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

	<table border="1" id="tbl_detail">
		<tr>
			<td colspan="2" align="center" class="d_td1"><h3>상세 페이지</h3></td>
		</tr>
		<tr>
			<td class="d_td1">글 번호</td>
			<td class="d_td2">${review.no }</td>
		</tr>
		<tr>
			<td class="d_td1">글 제목</td>
			<td class="d_td2">${review.title }</td>
		</tr>
		<tr>
			<td class="d_td1">내용</td>
			<td class="d_td2">${review.txt }</td>
		</tr>
		<tr>
			<td class="d_td1">등록일</td>
			<td class="d_td2"><fmt:formatDate value="${review.date }" type="both" dateStyle="short" timeStyle="short" /></td>
		</tr>
		<tr>
			<td colspan="2" class="d_td3"> <button onclick="history.back()">목록으로</button> 
			<button onclick="location.href='ReviewUpdateC?num=${review.no }'">수정</button> 
			<button onclick="deleteReview(${review.no })">삭제</button></td>
		</tr>
	</table>

</body>
</html>