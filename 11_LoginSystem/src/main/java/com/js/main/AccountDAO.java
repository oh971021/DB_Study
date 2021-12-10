package com.js.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccountDAO {

	public static void loginCheck(HttpServletRequest request) {
		
		HttpSession hs = request.getSession();
		// attribute로 넘거볃으면 Object Type 으로 넘어오기때문에 형변환 필수!
		Account a = (Account)hs.getAttribute("accountInfo");
		
		if (a == null) {
			// 로그인 실패
			request.setAttribute("loginPage", "login.jsp");
		} else {
			// 로그인 성공
			request.setAttribute("loginPage", "loginOK.jsp");			
		}
		
		
	}	
	
	public static void login(HttpServletRequest request) {
		
		/* 로그인 방법
			1. 사용자가 id, pw 입력
			2. DB의 정보와 일치하는지 확인 (DB값 비교)
			3. 다 맞으면 로그인 성공! / 하나라도 틀리면 로그인 실패!	*/
		
		// 1. 값 받기
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		// 2. DB와 비교 ( 아직 개발 안됨 ) - 가데이터 처리
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
				// id 가 맞으면 pw 검사를 하자
				// id 가 primary key 라서 따로 비교할 건 없다.
				String dbPW = rs.getString("l_pw");
				
				if(userPw.equals(dbPW)) {
					
					// 값이 여러개니까 뭉쳐서 : Account
					Account a = new Account();
					
					// Setter를 쓰든 생성자를 쓰든 상관없음
					a.setId(rs.getString("l_id"));
					a.setPw(rs.getString("l_pw"));
					a.setName(rs.getString("l_name"));
					
					// 세션 객체에 리퀘스트 세션을 읽어서 넣어준다.
					HttpSession hs = request.getSession();
					// 세션에 어트리뷰트 정보를 넣어준다.
					hs.setAttribute("accountInfo", a);
					// 세션 만료 시간을 정해 줌
					hs.setMaxInactiveInterval(5);					
					
//					request.setAttribute("a", a);
					
					request.setAttribute("r", "로그인 성공!");
				} else {
					request.setAttribute("r", "비밀번호 오류입니다.");
				}
				
			} else {
				request.setAttribute("r", "존재하지 않는 회원입니다.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void logout(HttpServletRequest request) {

		// 세션을 죽이기
			// 1. 애초에 만든 적이 없을 때
			// 2. 시간 만료되었을 때
		HttpSession hs = request.getSession();
		hs.setAttribute("accountInfo", null);
		
		
	}

}
