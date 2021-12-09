<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<form action="UnitC" onsubmit="return call();" method="post">
			<table border="0" id="unitTable">
				<tr class="header">
					<td class="unitTd"><h1>단위 변환</h1></td>
				</tr>
				<tr>
					<td class="unitTd"><h2>변환할 값 : </h2></td>
				</tr>
				<tr>
					<td class="unitInput"> <input name="value" id="i1" placeholder="숫자를 입력하세요!"> </td>
				</tr>
				<tr>
					<td class="unitTd"><h2>단위 : </h2></td>
				</tr>
				<tr>
					<td>
						<select name="calc" class="unitSelect">
							<option value="1"> cm -> inch </option>
							<option value="2"> ㎡ -> 평 </option>
							<option value="3"> ℃ -> ℉ </option>
							<option value="4"> km/h -> ml/h </option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
					<button id="unitButton"><h2>변환</h2></button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>