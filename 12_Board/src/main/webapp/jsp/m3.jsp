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

	<table>
		<tr>
			<%-- 			<td align="center" style="font-size: 50pt; width: 50px;">
				<c:if test="${curPageNo != 1 }">
					<a href="MoviePageController?p=${curPageNo - 1}">&lt;</a>
				</c:if>
			</td> --%>
			<td colspan="5">
				<form action="Menu3" method="post" enctype="multipart/form-data">
					<table id="mTbl">
						<tr>
							<td>영화 제목</td>
							<td><input name="title"></td>
						</tr>
						<tr>
							<td>영화 배우</td>
							<td><input name="actor"></td>
						</tr>
						<tr>
							<td>영화 사진</td>
							<td><input type="file" name="img"></td>
						</tr>
						<tr>
							<td>영화 줄거리</td>
							<td><textarea rows="" cols="" name="story"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">
								<button>등록</button>
							</td>
						</tr>
					</table>
				</form> <!-- 영화 내용 출력 (DB 정보) --> <c:forEach var="m" items="${movies }">

					<table id="mTbl2">
						<tr>
							<td id="m_td2" rowspan="4"><img src="img/${m.img }"
								id="movieImg"></td>
						</tr>
						<tr>
							<td>제목</td>
							<td class="m_td1">${m.title }</td>
						</tr>
						<tr>
							<td>배우</td>
							<td class="m_td1">${m.actor }</td>
						</tr>
						<tr>
							<td>줄거리</td>
							<td class="m_td1">${m.story }</td>
						</tr>
						<tr>
							<td>
								<button
									onclick="location.href='MovieUpdateC?num=${m.no}&basicImg=${m.img }'">수정</button>
								<button
									onclick="updateMovie('${m.title }', '${m.actor }', '${m.story }', '${m.no }')">수정(JS)</button>
								<button onclick="deleteMovie(${m.no })">삭제</button>
							</td>
						</tr>
					</table>
				</c:forEach>
			</td>

		</tr>
		<tr>

			<td align="center" style="font-size: 50pt; width: 50px;"><c:choose>
					<c:when test="${curPageNo == 1 }">&lt;</c:when>
					<c:otherwise>
						<a href="MoviePageController?p=${curPageNo - 1}">&lt;</a>
					</c:otherwise>
				</c:choose></td>

			<td align="center">
				<c:choose>
					<c:when test="${curPageNo == 1 }">[맨앞]</c:when>
					<c:otherwise>
						<a href="MoviePageController?p=1">[맨앞]</a>
					</c:otherwise>
				</c:choose>
			</td>
			<td align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					<!-- 페이지 카운터를 누르면 해당 페이지로 이동함 -->
					<a href="MoviePageController?p=${p }">[${p }]</a>
				</c:forEach>
			</td>
			<td align="center">
				<c:choose>
					<c:when test="${curPageNo == pageCount }">[맨뒤]</c:when>
					<c:otherwise>
						<a href="MoviePageController?p=${pageCount }">[맨뒤]</a>
					</c:otherwise>
				</c:choose>
			</td>

			<td align="center" style="font-size: 50pt; width: 50px;"><c:choose>
					<c:when test="${curPageNo == pageCount }">&gt;</c:when>
					<c:otherwise>
						<a href="MoviePageController?p=${curPageNo + 1}">&gt;</a>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>


</body>
</html>