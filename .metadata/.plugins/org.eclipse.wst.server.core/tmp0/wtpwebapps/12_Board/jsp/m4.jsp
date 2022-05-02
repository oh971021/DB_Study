<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- DB자료를 여기에 뿌려주는 작업을 한다 -->

	<table id="tbl_review">
		<tr>
			<td class="r_td_title">후기 페이지 &nbsp;&nbsp;&nbsp; ${r }</td>
			<td class="r_td_title"><a href="ReviewRegC">글쓰기</a></td>
		</tr>
	</table>

	<table id="tbl_review2">
		<c:forEach var="r" items="${reviews }">
			<tr class="r_tr1">
				<td class="r_td1"
					onclick="location.href='ReviewDetailC?num=${r.no }'">${r.title }</td>
				<td class="r_td1"><fmt:formatDate value="${r.date }"
						type="both" dateStyle="short" timeStyle="short" /></td>
			</tr>
		</c:forEach>
	</table>

	<table id="tbl_review3">
		<tr>
			<td id="r_pageTd" align="center">
				<c:choose>
					<c:when test="${curPageNo == 1 }">[맨앞]</c:when>
					<c:otherwise>
						<a href="ReviewPageController?p=1">[맨앞]</a>
					</c:otherwise>
				</c:choose>
			</td>
			<td id="r_pageTd" align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					<!-- 페이지 카운터를 누르면 해당 페이지로 이동함 -->
					<a href="ReviewPageController?p=${p }">[${p }]</a>
				</c:forEach>
			</td>
			<td id="r_pageTd" align="center">
				<c:choose>
					<c:when test="${curPageNo == pageCount }">[맨뒤]</c:when>
					<c:otherwise>
						<a href="ReviewPageController?p=${pageCount }">[맨뒤]</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>

	<form action="SearchReviewC">
		<table style="width: 300px; height: 60px;">
			<tr>
				<td><input style="width: 200px; height: 30px;" id="search" name="search"></td>
				<td>
					<button>검색</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>