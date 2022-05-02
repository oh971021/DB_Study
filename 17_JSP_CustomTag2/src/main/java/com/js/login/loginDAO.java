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
		
		// ���� �� �ޱ� (ó�� �α���)
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		// ������ ���� �� �ޱ� (ȸ������ �� �α���)
		String idd = (String)request.getAttribute("idd");
		String pww = (String)request.getAttribute("pww");
		
		// ���� ���� ���� ���´ٸ� ���� ���� ������ ���Խ��Ѽ� �α��� �۾��� ��Ų��.
		if(idd != null) {
			userID = idd;
			userPW = pww;
		}
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			// ���̵� �ִ��� �����Ѵ�.
			if (rs.next()) {
				// DB�� ���� �� PW�� userPw ���ϱ�
				String dbPW = rs.getString("a_pw");
				
				if(dbPW.equals(userPW)) {
					
					User user = new User();
					
					// ���� ���� �̱�
					user.setName(rs.getString("a_name"));
					user.setId(rs.getString("a_id"));  
					user.setPw(rs.getString("a_pw"));  
					user.setGender(rs.getString("a_gender"));
					user.setAddr(rs.getString("a_addr"));
					user.setInterest(rs.getString("a_interest"));
					user.setIntroduce(rs.getString("a_introduce"));
					user.setImg(rs.getString("a_img"));
					
//					request.setAttribute("u", u); // �� ģ���� ���� �����ϱ� �ʿ����			
					
					// ���� �ҷ�����
					HttpSession hs = request.getSession();
					// ���ǿ� user ���� ����
					hs.setAttribute("userInfo", user);
					// ���� ���� �ð� ����
					hs.setMaxInactiveInterval(60*5);
					
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
									// �α��� ���� �ǹ�
		
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
			 
			 // �� �ҷ�����
			 String name = mr.getParameter("name");
			 String id =  mr.getParameter("id");
			 String pw =  mr.getParameter("pw");
			 String gender =  mr.getParameter("gender");
			 String addr =  mr.getParameter("addr");
			 // ����Ʈ�� ���� ���� �����Ƿ� �迭�� ó��
			 String[] interest =  mr.getParameterValues("interest"); // �迭
			 String introduce =  mr.getParameter("textArea");
			 String img =  mr.getFilesystemName("img");
			 
			 // �迭 ���� �� ���� ����
			 String interest2 = "";
			 
			 // ���ɻ翡 �� �� ó���ϱ� (�迭�̶� üũ���ϸ� null ���� ���´�)
			 if(interest != null) {
				 for (String s : interest) {
					// �������� �ϳ��� ������ ��� 
					// ���߿� ���� ����� ���� ! ������ �߶󾲱�
					interest2 += s + "!";
				} 
			 } else {
					interest2 = "���ɻ� ����";
			 }

			 // �ڱ�Ұ� �� ó���ϱ� (null ���� �ƴ϶� ���� ������ ����)
			 // ���̰� �ϳ��� ���ٸ�? �̰ŵ� �����̽��� �����ѵ� ���ο� �ذ�� (���ڿ��� ���̷� ��)
			 if(introduce.length() == 0) {
				 introduce = "...";
			 }
			 
			 // log ���
			 System.out.println(name);
			 System.out.println(id);
			 System.out.println(pw);
			 System.out.println(gender);
			 System.out.println(addr);
			 System.out.println(interest);
			 System.out.println(interest2);
			 System.out.println(introduce);
			 System.out.println(img);
			 
			 // �� ���Խ�Ű��
			 pstmt.setString(1, name);
			 pstmt.setString(2, id);
			 pstmt.setString(3, pw);
			 pstmt.setString(4, gender);
			 pstmt.setString(5, addr);
			 pstmt.setString(6, interest2);
			 pstmt.setString(7, introduce);
			 pstmt.setString(8, img);
			
			 // �ϳ��� �ε����� �� ������ ok
			 if (pstmt.executeUpdate() == 1) {
				 System.out.println("��� ����!");
				 request.setAttribute("r", "��� ����!");
			 } else {
				 System.out.println("��� ����!");
				 request.setAttribute("r", "��� ����!");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����..");
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
			 
			 // �� �ҷ�����
			 String name = mr.getParameter("name");
			 String pw =  mr.getParameter("pw");
			 String pw2 =  mr.getParameter("pw2");
			 String addr =  mr.getParameter("addr"); // ���, ���ɰ��� �ٸ��� ����/���ο ������ �۾� ����.

			 String interest =  mr.getParameter("interest"); // �迭
			 String[] interest2 = mr.getParameterValues("interest2");
			 String introduce =  mr.getParameter("textArea");
			 
			 // ���� ���� ���ο� ���� �Ѵ� ���� �س��´�.
			 String oldFile =  mr.getParameter("img");
			 String newFile =  mr.getFilesystemName("img2");
			 
			 // �迭 ���� �� ���� ����
			 String interest3 = "";
			 
			 // ���ɻ翡 �� �� ó���ϱ� (�迭�̶� üũ���ϸ� null ���� ���´�)
			 if(interest2 != null) {
				 for (String s : interest2) {
					// �������� �ϳ��� ������ ��� 
					// ���߿� ���� ����� ���� ! ������ �߶󾲱�
					interest3 += s + "!";
				} 
			 } else {
					interest3 = "���ɻ� ����";
			 }

			 // �ڱ�Ұ� �� ó���ϱ� (null ���� �ƴ϶� ���� ������ ����)
			 // ���̰� �ϳ��� ���ٸ�? �̰ŵ� �����̽��� �����ѵ� ���ο� �ذ�� (���ڿ��� ���̷� ��)
			 if(introduce.length() == 0) {
				 introduce = "...";
			 }
			 
			 // log ���
			 System.out.println(name);
			 System.out.println(pw);
			 System.out.println(pw2);
			 System.out.println(addr);
			 System.out.println(interest);
			 System.out.println(interest3);			 
			 System.out.println(oldFile);
			 System.out.println(newFile);
			 
			 // �� ���Խ�Ű��
			 
			 pstmt.setString(1, name);
			 String pw3 = "";
			 if (pw2.length() == 0) {
				 pw3 = pw;	// ���� ��
	 		 }else {
		 		 pw3 = pw2;	 // ���� ��
			 }
			 pstmt.setString(2, pw3);	
			 pstmt.setString(3, addr);
			 if(interest2 == null) {				 
				 pstmt.setString(4, interest); // ���� ��
			 } else {
				 pstmt.setString(4, interest3); // ���� ��				 
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
			 
			 // �ϳ��� �ε����� �� ������ ok
			 if (pstmt.executeUpdate() == 1) {
				 System.out.println("���� ����!");
				 request.setAttribute("r", "���� ����!");	
				 
				 // ���⿡�ٰ� �α��� ����� �ٽ� ����ؼ� ������Ʈ ���� �൵ ��
				 
			 } else {
				 System.out.println("���� ����!");
				 request.setAttribute("r", "���� ����!");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
	
	public static int makeInterest(HttpServletRequest request) {
	
		User u = (User)request.getSession().getAttribute("userInfo");
		
		// ���ɻ� ������
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

			 // �Ķ���� �� ó��
			 String id = request.getParameter("id");
			 pstmt.setString(1, id);

			 // ���� �� �ҷ��ͼ� ó���ص� ��
			 
			 // �ϳ��� �ε����� �� ������ ok
			 if (pstmt.executeUpdate() == 1) {
				 System.out.println("Ż�� ����!");
				 request.setAttribute("r", "Ż�� ����!");
			 } else {
				 System.out.println("Ż�� ����!");
				 request.setAttribute("r", "Ż�� ����!");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

}
