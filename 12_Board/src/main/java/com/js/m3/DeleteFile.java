package com.js.m3;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class DeleteFile {

	public void deletefile(HttpServletRequest request) {
		String file = request.getParameter("");
		String path = "C:\\Users\\oh971\\DBworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\12_Board\\img\\" + file;
		
		File del = new File(path);
		
		// 파일이 있는지 확인
		if (del.exists()) {
			del.delete();
			request.setAttribute("d", "삭제 성공");
		} else {
			request.setAttribute("d", "삭제 실패");
		}
	}
}
