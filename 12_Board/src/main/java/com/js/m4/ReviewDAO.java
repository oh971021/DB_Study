package com.js.m4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.js.main.DBManager;

public class ReviewDAO {

	public static void getAllReivew(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from review_test order by r_no desc";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Review> reviews = new ArrayList<Review>(); 
			
			Review r = null;
			
			while (rs.next()) {
				r = new Review();
				r.setNo(rs.getInt("r_no"));
				r.setTitle(rs.getString("r_title"));
				r.setTxt(rs.getString("r_txt"));
				r.setDate(rs.getDate("r_date"));
				
				reviews.add(r);
			}
			request.setAttribute("reviews", reviews);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void regReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		String sql = "insert into review_test values(review_test_seq.nextval,?,?,sysdate)";
		
		try {
			request.setCharacterEncoding("UTF-8");

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록 성공!");
			} else {
				request.setAttribute("r", "등록 실패!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 문제...");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void getReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from review_test where r_no = ?";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("num")));
			
			rs = pstmt.executeQuery();
			
			Review r = null;
			
			if (rs.next()) {
				r = new Review();
				r.setNo(rs.getInt("r_no"));
				r.setTitle(rs.getString("r_title"));
				r.setTxt(rs.getString("r_txt"));
				r.setDate(rs.getDate("r_date"));				
			}
			
			request.setAttribute("review", r);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void updateReview(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
											// 날짜 유지 컨셉은 date 설정 유무에 따라 다르다.
															// r_date = sysdate
		String sql = "update review_test set r_title = ?, r_txt = ? where r_no = ?";
		
		try {
			request.setCharacterEncoding("utf-8");
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
		
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			int no = Integer.parseInt(request.getParameter("no"));
			
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setInt(3, no);
			// 셋팅 완료.
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공!!");
			} else {
				request.setAttribute("r", "수정 실패!!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

	public static void deleteReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete review_test where r_no = ?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
		
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공!");
			} else {
				request.setAttribute("r", "삭제 실패!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버 오류!");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
}
