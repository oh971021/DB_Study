package com.js.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class M2 {

	// �α��� ���
	public static void login(HttpServletRequest request) {

		/*
		 * �α��� ��� 1. ����ڰ� id, pw �Է� 2. DB�� ������ ��ġ�ϴ��� Ȯ�� (DB�� ��) 3. �� ������ �α��� ����! / �ϳ���
		 * Ʋ���� �α��� ����!
		 */

		// 1. �� �ޱ�
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		// 2. DB�� �� ( ���� ���� �ȵ� ) - �������� ó��

		String dbID = "js";
		String dbPW = "1004";

		if (userId.equals(dbID)) {
			// id �� ������ pw �˻縦 ����
			if (userPw.equals(dbPW)) {
				request.setAttribute("r", "�α��� ����!");
			} else {
				request.setAttribute("r", "��й�ȣ �����Դϴ�.");
			}
		} else {
			request.setAttribute("r", "�������� �ʴ� ȸ���Դϴ�.");
		}

	}

}
