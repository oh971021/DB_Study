package com.js.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.js.hc.DBManager;

public class loginDAO {

	public static void login(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from login_jw where l_id = ?";
		
		// ���� �� �ޱ�
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			// ���̵� �ִ��� �����Ѵ�.
			if (rs.next()) {
				// DB�� ���� �� PW�� userPw ���ϱ�
				String dbPW = rs.getString("l_pw");
				
				if(dbPW.equals(userPW)) {
					
					// ���� ���� �̱�
					String dbID = rs.getString("l_id");  
					String dbName = rs.getString("l_name");
					
					// ���� ���� URL�� ������ ( �� 3�� : ��ü �ʿ� )
					User u = new User(dbID, dbPW, dbName);
//					request.setAttribute("u", u); // �� ģ���� ���� �����ϱ� �ʿ����			
					
					// ���� �ҷ�����
					HttpSession hs = request.getSession();
					// ���ǿ� user ���� ����
					hs.setAttribute("userInfo", u);
					// ���� ���� �ð� ����
					hs.setMaxInactiveInterval(12);
					
					request.setAttribute("r", "�α��� ����!");
				} else {
					request.setAttribute("r", "��� ����");
				}
			} else {
				request.setAttribute("r", "���̵� ����");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void loginCheck(HttpServletRequest request) {
		
		// ���� ���� �ޱ� (������ �ޱ�)
		HttpSession hs = request.getSession();
		User u = (User)hs.getAttribute("userInfo");
		
		if(u != null) {
			request.setAttribute("loginPage", "jsp/loginOK.jsp");
		} else {
			request.setAttribute("loginPage", "jsp/login.jsp");
		}
	}

	public static void logout(HttpServletRequest request) {

		// ���� �����ͼ� ���̱�
		HttpSession hs = request.getSession();
		hs.setAttribute("userInfo", null);
		
	}

}
