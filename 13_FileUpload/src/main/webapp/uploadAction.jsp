<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="file.FileDAO"%>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 파일 업로드</title>
</head>
<body>
	<%
		// application : 전체 프로젝트에 대한 자원을 관리하는 객체
		String directory = "C:/JSP/upload/";
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
		
		// for문이랑 비슷함
		Enumeration fileNames = multipartRequest.getFileNames();
		while (fileNames.hasMoreElements()) {
			
			// 파일 전부를 받아아서 파라미터로 분리함
			String parameter = (String) fileNames.nextElement();
			// 파라미터 값을 받아서 파일 네임에 넣어줌
			String fileName = multipartRequest.getOriginalFileName(parameter);
			String fileRealName = multipartRequest.getFilesystemName(parameter);
			
			// 올바르지 않은 확장자가 들어와도 다음 작업을 이어서 한다.
			if(fileName == null) continue;
			
			// 올바른 확장자가 아니면 파일 업로드를 삭제하는 방식
			if(!fileName.endsWith(".doc") && !fileName.endsWith(".hwp") && !fileName.endsWith(".pdf") && !fileName.endsWith(".xls")) {
				File file = new File(directory + fileRealName);
				System.out.println(file);
				file.delete();
				out.write("업로드할 수 없는 확장자입니다.");
			} else {
				new FileDAO().upload(fileName, fileRealName);
				out.write("파일명: " + fileName + "<br>");
				out.write("실제파일명: " + fileRealName + "<br>");			
			}
			
		}
	%>
</body>
</html>