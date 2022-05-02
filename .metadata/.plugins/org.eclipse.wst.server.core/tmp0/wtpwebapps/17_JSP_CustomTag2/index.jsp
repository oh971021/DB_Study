<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/unitMain.css">
<link rel="stylesheet" href="css/bmiMain.css">
<link rel="stylesheet" href="css/bmiResult.css">
<link rel="stylesheet" href="css/reg.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/unitCheck.js"></script>
<script type="text/javascript" src="js/bmiCheck.js"></script>
<script type="text/javascript" src="js/go.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table id="site">
		<tr>
			<td id="title">
				<a href="HC"> JS's WebSite </a>
			</td>
			<td align="right">
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
		<tr>
			<td id="menu" colspan="2">
				<a href="AC">A</a> <a href="BC">B</a> 
				<a href="UnitC">Unit</a> <a href="BmiC">BMI</a>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
	</table>
</body>
</html>