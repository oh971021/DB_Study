<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegAccountC" onsubmit="return check();" name="myForm" method="post" enctype="multipart/form-data">
		<table id="regTbl">
			<tr>
				<td colspan="2" id="title">회원 가입</td>
			</tr>
			<tr>
				<td class="regTd1">이름</td>
				<td class="regTd2"><input name="name" required="required"></td>
			</tr>
			<tr>
				<td class="regTd1">ID</td>
				<td class="regTd2"><input name="id" placeholder="한글x, 5글자 이상"></td>
			</tr>
			<tr>
				<td class="regTd1">PW</td>
				<td class="regTd2"><input name="pw" type="password"
					placeholder="3글자 이상, 대,소,숫 1포함"></td>
			</tr>
			<tr>
				<td class="regTd1">PW 확인</td>
				<td class="regTd2"><input name="pw" type="password"></td>
			</tr>
			<tr>
				<td class="regTd1">성별</td>
				<td class="regTd2">남<input type="radio" name="gender" checked="checked"
					value="남"> 여<input type="radio" name="gender" value="여"></td>
			</tr>
			<tr>
				<td class="regTd1">주소</td>
				<td class="regTd2"><select name="addr">
						<option value="seoul">서울</option>
						<option value="kyeonggi">경기</option>
						<option value="busan">부산</option>
						<option value="etc">기타</option>
				</select></td>
			</tr>
			<tr>
				<td class="regTd1">관심사</td>

				<td class="regTd2">요리<input type="checkbox" name="interest" value="cook">
					운동<input type="checkbox" name="interest" value="excer"> 게임<input
					type="checkbox" name="interest" value="game"> 개발<input
					type="checkbox" name="interest" value="dev">
				</td>

			</tr>
			<tr>
				<td class="regTd1">자기소개</td>
				<td class="regTd2"><textarea name="textArea"></textarea></td>
			</tr>
			<tr>
				<td class="regTd1">프사</td>
				<td class="regTd2"><input type="file" placeholder="jpg, png" name="img"></td>
			</tr>
			<tr>
				<td colspan="2"><button id="regBtn">가입!</button></td>
			</tr>
		</table>
	</form>
</body>
</html>