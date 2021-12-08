<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ReviewRegC" method="post">
		<table border="1" id="tbl_reg">
			<tr>
				<td>글 제목</td>
				<td><input id="title" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="txt" name="txt"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" id="r_td3"><button>등록</button></td>
			</tr>
		</table>
	</form>

</body>
</html>