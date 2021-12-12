package com.js.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccountDAO {

	public static void loginCheck(HttpServletRequest request) {
		
		HttpSession hs = request.getSession();
		// attribute�� �Ѱœ����� Object Type ���� �Ѿ���⶧���� ����ȯ �ʼ�!
		Account a = (Account)hs.getAttribute("accountInfo");
		
		if (a == null) {
			// �α��� ����
			request.setAttribute("loginPage", "login.jsp");
		} else {
			// �α��� ����
			request.setAttribute("loginPage", "loginOK.jsp");			
		}
		
		
	}	
	
	public static void login(HttpServletRequest request) {
		
		/* �α��� ���
			1. ����ڰ� id, pw �Է�
			2. DB�� ������ ��ġ�ϴ��� Ȯ�� (DB�� ��)
			3. �� ������ �α��� ����! / �ϳ��� Ʋ���� �α��� ����!	*/
		
		// 1. �� �ޱ�
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		// 2. DB�� �� ( ���� ���� �ȵ� ) - �������� ó��
			// crud - r (select)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from login_test2 where l_id = ?";

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// id �� ������ pw �˻縦 ����
				// id �� primary key �� ���� ���� �� ����.
				String dbPW = rs.getString("l_pw");
				
				if(userPw.equals(dbPW)) {
					
					// ���� �������ϱ� ���ļ� : Account
					Account a = new Account();
					
					// Setter�� ���� �����ڸ� ���� �������
					a.setId(rs.getString("l_id"));
					a.setPw(rs.getString("l_pw"));
					a.setName(rs.getString("l_name"));
					
					// ���� ��ü�� ������Ʈ ������ �о �־��ش�.
					HttpSession hs = request.getSession();
					// ���ǿ� ��Ʈ����Ʈ ������ �־��ش�.
					hs.setAttribute("accountInfo", a);
					// ���� ���� �ð��� ���� ��
					hs.setMaxInactiveInterval(5);					
					
//					request.setAttribute("a", a);
					
					request.setAttribute("r", "�α��� ����!");
				} else {
					request.setAttribute("r", "��й�ȣ �����Դϴ�.");
				}
				
			} else {
				request.setAttribute("r", "�������� �ʴ� ȸ���Դϴ�.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void logout(HttpServletRequest request) {

		// ������ ���̱�
			// 1. ���ʿ� ���� ���� ���� ��
			// 2. �ð� ����Ǿ��� ��
		HttpSession hs = request.getSession();
		hs.setAttribute("accountInfo", null);
		
		
	}

}
