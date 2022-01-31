<%@page import="java.util.ArrayList"%>
<%@page import="file.FileDAO"%>
<%@page import="file.FileDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 파일 업로드</title>
</head>
<body>
	<%
		ArrayList<FileDTO> filelist = new FileDAO().getList();
	
		for (FileDTO file : filelist) {
			out.write("<a href=\"" + request.getContextPath() + "/downloadAction?file=" + java.net.URLEncoder.encode(file.getFileRealName(), "UTF-8") + "\">" + file.getFileName() + "(다운로드 횟수: " + file.getDownloadCount() + ")</a><br>");
		}
	%>
</body>
</html>