package com.js.m3;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class DeleteFile {

	public void deletefile(HttpServletRequest request) {
		String file = request.getParameter("");
		String path = "C:\\Users\\oh971\\DBworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\12_Board\\img\\" + file;
		
		File del = new File(path);
		
		// ������ �ִ��� Ȯ��
		if (del.exists()) {
			del.delete();
			request.setAttribute("d", "���� ����");
		} else {
			request.setAttribute("d", "���� ����");
		}
	}
}
