<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/result.css">
</head>
<body>
	<table border="0" id="bmiresulttable">
		<tr>
			<td colspan="2" id="bmiresulttitle">BMI 결과</td>
		</tr>
		<!-- 제목 -->
			
		<tr>
			<td>사진</td>
			<td class="profile"> <img src="img/${br.profile }" class="image"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td class="result"> ${br.name } 님 </td>
		</tr>
		<tr>
			<td>키</td>
			<td class="result"> ${br.height } cm </td>
		</tr>
		<tr>
			<td>체중</td>
			<td class="result"> ${br.weight } kg </td>
		</tr>
		<tr>
			<td>BMI</td>
			<td class="result"> ${br.bmi }</td>
		</tr>
		<tr>
			<td>결과</td>
			<td class="result"> ${br.result }입니다 </td>
		</tr>
		<!-- 레이아웃 -->
		
		<tr>
			<td colspan="2" id="button"> 
				<button> 홈으로 </button> 
			</td>
		</tr>
		<!-- 돌아가기 -->
		
	</table>
</body>
</html>