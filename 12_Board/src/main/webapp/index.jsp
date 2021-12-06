<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/movie.css">
<script type="text/javascript" src="js/movie.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td class="siteMenu" align="center"><a href="HC">HOME</a></td>
			<td class="siteMenu" align="center"><a href="Menu2">[MENU]</a></td>
			<td class="siteMenu" align="center"><a href="Menu3">[영화정보]</a></td>
			<td class="siteMenu" align="center"><a href="#">[후기 게시판]</a></td>
		</tr>
		<tr>
			<td colspan="5">
				<table id="site">
					<tr>
						<td><jsp:include page="${contentPage }"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>