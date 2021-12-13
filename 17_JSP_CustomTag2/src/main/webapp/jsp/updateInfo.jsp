<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateAccountC" method="post"
		enctype="multipart/form-data">
		<table id="regTbl">
			<tr>
				<td colspan="2" id="title">회원 수정</td>
			</tr>
			<tr>
				<td class="regTd1">이름</td>
				<td class="regTd2"><input name="name"
					value="${sessionScope.userInfo.name }"></td>
			</tr>
			<tr>
				<td class="regTd1">ID</td>
				<td class="regTd2">${sessionScope.userInfo.id }</td>
			</tr>
			<tr>
				<td class="regTd1">PW</td>
				<td class="regTd2"><input name="pw2"><input name="pw" value="${sessionScope.userInfo.pw }" type="hidden"></td>
			</tr>
			<tr>
				<td class="regTd1">성별</td>
				<td class="regTd2">${sessionScope.userInfo.gender }</td>
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
				<td class="regTd2">요리<input type="checkbox" name="interest2"
					value="cook"> 운동<input type="checkbox" name="interest2"
					value="excer"> 게임<input type="checkbox" name="interest2"
					value="game"> 개발<input type="checkbox" name="interest2"
					value="dev"> <input
					value="${sessionScope.userInfo.interest }" name="interest"
					type="hidden">
				</td>

			</tr>
			<tr>
				<td class="regTd1">자기소개</td>
				<td class="regTd2"><textarea name="textArea">${sessionScope.userInfo.introduce }</textarea></td>
			</tr>
			<tr>
				<td class="regTd1">프사</td>
				<td class="regTd2"><input name="img"
					value="${sessionScope.userInfo.img }" type="hidden"> <input
					type="file" name="img2"> <img
					src="file/${sessionScope.userInfo.img }"></td>
			</tr>
			<tr>
				<td colspan="2"><button
						onclick="location.href='UpdateAccountC'"
						value="${sessionScope.userInfo.id }" name="id">수정</button></td>
			</tr>
		</table>
	</form>
</body>
</html>