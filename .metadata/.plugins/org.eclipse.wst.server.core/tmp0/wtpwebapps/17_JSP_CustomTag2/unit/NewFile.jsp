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
	<div id="wrap">
		<table id="resultTable" border="0"> 
			<tr>
				<td style="background-color: ${re.color}; color: white;"><h1>변환 결과</h1></td>
			</tr>
			<tr>
				<td><h1>
				${re.value }
				<span class="${re.cn }"> ${re.unit1 } </span>
				</h1></td>
			</tr>
			<tr>
				<td><h1>↓</h1></td>
			</tr>
			<tr>
				<td><h1>
				${re.result }
				<span class="${re.cn }"> ${re.unit2 } </span>
				</h1></td>
			</tr>
		</table>
	</div>
</body>
</html>