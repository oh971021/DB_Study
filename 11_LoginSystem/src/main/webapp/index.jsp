<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width='500' height='300' border="1">
		<tr>
			<td align="right">
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
		<tr>
			<td> 
				<a href="HC">홈</a> 
				<a href="M1Controller">메뉴1</a> 
				<a href="M2Controller">메뉴2</a> 
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>

</body>
</html>