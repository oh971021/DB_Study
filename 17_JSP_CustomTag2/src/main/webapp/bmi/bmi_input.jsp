<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BmiC" onsubmit="return block();" method="post" enctype="multipart/form-data" >
		<table id="bmitable" border="0">
			<tr>
				<td colspan="2" id="bmititle">BMI 검사</td>
			</tr>
			<!-- 제목 -->
			
			<tr>
				<td>이름</td>
				<td> <input type="text" id="name" name="name" placeholder="이름, 필수, 2글자 이상" maxlength="20" > </td>
			</tr>
			<tr>
				<td>키</td>
				<td> <input type="text" id="height" name="height" placeholder="키, 3자리 이상, 숫자만" maxlength="3" > </td>
			</tr>
			<tr>
				<td>체중</td>
				<td> <input type="text" id="weight" name="weight" placeholder="몸무게, 숫자만" maxlength="3" > </td>
			</tr>
			<tr>
				<td>사진</td>
				<td> <input type="file" name="profile" > </td>
			</tr>
			<!-- 레이아웃 -->
			
			<tr>
				<td colspan="2" id="button"><button>계산</button></td>
			</tr>
			<!-- 결과보기 -->
			
		</table>
	</form>
</body>
</html>