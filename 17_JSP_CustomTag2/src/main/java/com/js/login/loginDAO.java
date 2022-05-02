package com.js.login;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.js.hc.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class loginDAO {

	public static void login(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from account where a_id = ?";
		
		// 유저 값 받기 (처음 로그인)
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		// 수정한 유저 값 받기 (회원수정 후 로그인)
		String idd = (String)request.getAttribute("idd");
		String pww = (String)request.getAttribute("pww");
		
		// 만약 수정 값이 들어온다면 기존 유저 정보에 대입시켜서 로그인 작업을 시킨다.
		if(idd != null) {
			userID = idd;
			userPW = pww;
		}
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			// 아이디가 있는지 학인한다.
			if (rs.next()) {
				// DB에 저장 된 PW와 userPw 비교하기
				String dbPW = rs.getString("a_pw");
				
				if(dbPW.equals(userPW)) {
					
					User user = new User();
					
					// 유저 정보 뽑기
					user.setName(rs.getString("a_name"));
					user.setId(rs.getString("a_id"));  
					user.setPw(rs.getString("a_pw"));  
					user.setGender(rs.getString("a_gender"));
					user.setAddr(rs.getString("a_addr"));
					user.setInterest(rs.getString("a_interest"));
					user.setIntroduce(rs.getString("a_introduce"));
					user.setImg(rs.getString("a_img"));
					
//					request.setAttribute("u", u); // 이 친구는 세션 넣으니까 필요없네			
					
					// 세션 불러오기
					HttpSession hs = request.getSession();
					// 세션에 user 정보 세팅
					hs.setAttribute("userInfo", user);
					// 세션 종료 시간 설정
					hs.setMaxInactiveInterval(60*5);
					
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
									// 로그인 성공 의미
		
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

	public static void reg(HttpServletRequest request) {

		 Connection con = null;
		 PreparedStatement pstmt = null;
		 
		 String sql = "insert into account values(?, ?, ?, ?, ?, ?, ?, ?)";
		 
		 try {
			 con = DBManager.connect();
			 pstmt = con.prepareStatement(sql);
			 
			 String path = request.getSession().getServletContext().getRealPath("file");
			 System.out.println(path);
			 MultipartRequest mr = new MultipartRequest(request, path, 31457280, "utf-8", new DefaultFileRenamePolicy()); 
			 
			 // 값 불러오기
			 String name = mr.getParameter("name");
			 String id =  mr.getParameter("id");
			 String pw =  mr.getParameter("pw");
			 String gender =  mr.getParameter("gender");
			 String addr =  mr.getParameter("addr");
			 // 셀렉트는 여러 값이 있으므로 배열로 처리
			 String[] interest =  mr.getParameterValues("interest"); // 배열
			 String introduce =  mr.getParameter("textArea");
			 String img =  mr.getFilesystemName("img");
			 
			 // 배열 넣을 빈 깡통 생성
			 String interest2 = "";
			 
			 // 관심사에 빈 값 처리하기 (배열이라서 체크안하면 null 값이 나온다)
			 if(interest != null) {
				 for (String s : interest) {
					// 돌때마다 하나씪 붙혀서 출력 
					// 나중에 값을 사용할 때는 ! 기준을 잘라쓰기
					interest2 += s + "!";
				} 
			 } else {
					interest2 = "관심사 없음";
			 }

			 // 자기소개 빈값 처리하기 (null 값이 아니라 공백 값으로 나옴)
			 // 길이가 하나도 없다면? 이거도 스페이스와 같긴한데 새로운 해결법 (문자열의 길이로 비교)
			 if(introduce.length() == 0) {
				 introduce = "...";
			 }
			 
			 // log 찍기
			 System.out.println(name);
			 System.out.println(id);
			 System.out.println(pw);
			 System.out.println(gender);
			 System.out.println(addr);
			 System.out.println(interest);
			 System.out.println(interest2);
			 System.out.println(introduce);
			 System.out.println(img);
			 
			 // 값 대입시키기
			 pstmt.setString(1, name);
			 pstmt.setString(2, id);
			 pstmt.setString(3, pw);
			 pstmt.setString(4, gender);
			 pstmt.setString(5, addr);
			 pstmt.setString(6, interest2);
			 pstmt.setString(7, introduce);
			 pstmt.setString(8, img);
			
			 // 하나의 인덱스가 잘 들어갔으면 ok
			 if (pstmt.executeUpdate() == 1) {
				 System.out.println("등록 성공!");
				 request.setAttribute("r", "등록 성공!");
			 } else {
				 System.out.println("등록 실패!");
				 request.setAttribute("r", "등록 실패!");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 오류..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void updateAccount(HttpServletRequest request) {

		Connection con = null;
		 PreparedStatement pstmt = null;
		 
		 String sql = "update account set a_name=?, a_pw=?, a_addr=?, a_interest=?, a_introduce=?, a_img=? where a_id=?";
		 
		 try {
			 con = DBManager.connect();
			 pstmt = con.prepareStatement(sql);
			 
			 String path = request.getSession().getServletContext().getRealPath("file");
			 System.out.println(path);
			 MultipartRequest mr = new MultipartRequest(request, path, 31457280, "utf-8", new DefaultFileRenamePolicy()); 
			 
			 // 값 불러오기
			 String name = mr.getParameter("name");
			 String pw =  mr.getParameter("pw");
			 String pw2 =  mr.getParameter("pw2");
			 String addr =  mr.getParameter("addr"); // 비밀, 관심과는 다르게 기존/새로운값 나누는 작업 안함.

			 String interest =  mr.getParameter("interest"); // 배열
			 String[] interest2 = mr.getParameterValues("interest2");
			 String introduce =  mr.getParameter("textArea");
			 
			 // 기존 값과 새로운 값을 둘다 셋팅 해놓는다.
			 String oldFile =  mr.getParameter("img");
			 String newFile =  mr.getFilesystemName("img2");
			 
			 // 배열 넣을 빈 깡통 생성
			 String interest3 = "";
			 
			 // 관심사에 빈 값 처리하기 (배열이라서 체크안하면 null 값이 나온다)
			 if(interest2 != null) {
				 for (String s : interest2) {
					// 돌때마다 하나씪 붙혀서 출력 
					// 나중에 값을 사용할 때는 ! 기준을 잘라쓰기
					interest3 += s + "!";
				} 
			 } else {
					interest3 = "관심사 없음";
			 }

			 // 자기소개 빈값 처리하기 (null 값이 아니라 공백 값으로 나옴)
			 // 길이가 하나도 없다면? 이거도 스페이스와 같긴한데 새로운 해결법 (문자열의 길이로 비교)
			 if(introduce.length() == 0) {
				 introduce = "...";
			 }
			 
			 // log 찍기
			 System.out.println(name);
			 System.out.println(pw);
			 System.out.println(pw2);
			 System.out.println(addr);
			 System.out.println(interest);
			 System.out.println(interest3);			 
			 System.out.println(oldFile);
			 System.out.println(newFile);
			 
			 // 값 대입시키기
			 
			 pstmt.setString(1, name);
			 String pw3 = "";
			 if (pw2.length() == 0) {
				 pw3 = pw;	// 기존 값
	 		 }else {
		 		 pw3 = pw2;	 // 변경 값
			 }
			 pstmt.setString(2, pw3);	
			 pstmt.setString(3, addr);
			 if(interest2 == null) {				 
				 pstmt.setString(4, interest); // 기존 값
			 } else {
				 pstmt.setString(4, interest3); // 변경 값				 
			 }
			 pstmt.setString(5, introduce);
			 if(newFile == null) {
				 pstmt.setString(6, oldFile);
			 } else {
				 pstmt.setString(6, newFile);
				 String delFile = path + "/" + oldFile;
				 File f = new File(delFile);
				 f.delete();
			 }
			 pstmt.setString(7, mr.getParameter("id"));
			 
			 request.setAttribute("idd", mr.getParameter("id"));
			 request.setAttribute("pww", pw3);
			 
			 // 하나의 인덱스가 잘 들어갔으면 ok
			 if (pstmt.executeUpdate() == 1) {
				 System.out.println("수정 성공!");
				 request.setAttribute("r", "수정 성공!");	
				 
				 // 여기에다가 로그인 기능을 다시 사용해서 업데이트 시켜 줘도 됨
				 
			 } else {
				 System.out.println("수정 실패!");
				 request.setAttribute("r", "수정 실패!");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 오류..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
	
	public static int makeInterest(HttpServletRequest request) {
	
		User u = (User)request.getSession().getAttribute("userInfo");
		
		// 관심사 나누기
		if(u != null) {
			String inter = u.getInterest();
			String[] inter2 = inter.split("!");
			request.setAttribute("inter", inter2);
			return 1;
		}
		return 0;
	}

	public static void deleteAccount(HttpServletRequest request) {

		Connection con = null;
		 PreparedStatement pstmt = null;
		 
		 String sql = "delete account where a_id=?";
		 
		 try {
			 con = DBManager.connect();
			 pstmt = con.prepareStatement(sql);

			 // 파라미터 값 처리
			 String id = request.getParameter("id");
			 pstmt.setString(1, id);

			 // 세션 값 불러와서 처리해도 됨
			 
			 // 하나의 인덱스가 잘 들어갔으면 ok
			 if (pstmt.executeUpdate() == 1) {
				 System.out.println("탈퇴 성공!");
				 request.setAttribute("r", "탈퇴 성공!");
			 } else {
				 System.out.println("탈퇴 실패!");
				 request.setAttribute("r", "탈퇴 실패!");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 오류..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

}
