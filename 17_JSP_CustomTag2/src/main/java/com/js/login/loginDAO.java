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
		
		// 유저 값 받기
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			// 아이디가 있는지 학인한다.
			if (rs.next()) {
				// DB에 저장 된 PW와 userPw 비교하기
				String dbPW = rs.getString("l_pw");
				
				if(dbPW.equals(userPW)) {
					
					// 유저 정보 뽑기
					String dbID = rs.getString("l_id");  
					String dbName = rs.getString("l_name");
					
					// 유저 정보 URL로 보내기 ( 값 3개 : 객체 필요 )
					User u = new User(dbID, dbPW, dbName);
//					request.setAttribute("u", u); // 이 친구는 세션 넣으니까 필요없네			
					
					// 세션 불러오기
					HttpSession hs = request.getSession();
					// 세션에 user 정보 세팅
					hs.setAttribute("userInfo", u);
					// 세션 종료 시간 설정
					hs.setMaxInactiveInterval(12);
					
					request.setAttribute("r", "로그인 성공!");
				} else {
					request.setAttribute("r", "비번 오류");
				}
			} else {
				request.setAttribute("r", "아이디 오류");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 오류");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void loginCheck(HttpServletRequest request) {
		
		// 유저 정보 받기 (세션을 받기)
		HttpSession hs = request.getSession();
		User u = (User)hs.getAttribute("userInfo");
		
		if(u != null) {
			request.setAttribute("loginPage", "jsp/loginOK.jsp");
		} else {
			request.setAttribute("loginPage", "jsp/login.jsp");
		}
	}

	public static void logout(HttpServletRequest request) {

		// 세션 가져와서 죽이기
		HttpSession hs = request.getSession();
		hs.setAttribute("userInfo", null);
		
	}

}
