<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">${r }</h1>	
	<form action="Menu3" method="post" enctype="multipart/form-data">
		<table id="mTbl">
			<tr>
				<td>영화 제목</td>
				<td> <input name="title"> </td>
			</tr>
			<tr>
				<td>영화 배우</td>
				<td> <input  name="actor"> </td>
			</tr>
			<tr>
				<td>영화 사진</td>
				<td> <input type="file" name="img"> </td>
			</tr>
			<tr>
				<td>영화 줄거리</td>
				<td> <textarea rows="" cols=""  name="story"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2"> <button>등록</button> </td>
			</tr>
		</table>
	</form>
	
	<!-- 영화 내용 출력 (DB 정보) -->
	<c:forEach var="m" items="${movies }">

		<table id="mTbl2">
			<tr>
				<td id="m_td2" rowspan="4"><img src="img/${m.img }" id="movieImg"></td>
			</tr>
			<tr>
				<td>제목</td>	<td class="m_td1">${m.title }</td>
			</tr>
			<tr>
				<td>배우</td><td class="m_td1">${m.actor }</td>
			</tr>
			<tr>
				<td>줄거리</td><td class="m_td1">${m.story }</td>
			</tr>
			<tr>
				<td>
					<button>수정</button>
					<button>수정</button>
					<button onclick="deleteMovie(${m.no })">삭제</button>
				</td>
			</tr>
		</table>



	</c:forEach>

</body>
</html>