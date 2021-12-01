package com.js.hc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {

	public static void call(HttpServletRequest request) {
	      String name = request.getParameter("n");
	      String age = request.getParameter("a");
	      
	      System.out.println(name);
	      System.out.println(age);
	}
	
	public static void reg(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			String name = request.getParameter("n");
			String age = request.getParameter("a");
			
			String sql = "INSERT INTO NAMEAGE VALUES (?, ?)";
			
			con = DBManager.connect();
			System.out.println("연결 성공!");
			
			// 데이터 생성
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "success!!");
			} else {
				request.setAttribute("r", "fail...");
			}
		
		} catch (Exception e) {
			request.setAttribute("r", "DB Server Error...");
			e.printStackTrace();
		} finally {
			// 쓰지 않은건 null 넣으면 된다.
			DBManager.close(con, pstmt, null);
		}
		
		
	}

	public static void select(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * FROM NAMEAGE";
			
			con = DBManager.connect();
			System.out.println("연결 성공!");
			
			// 데이터 조회
			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			
			request.setAttribute("rs", rs);
			
			ArrayList<Person> p = new ArrayList<Person>();
			
			while (rs.next()) {
				p.add(new Person(rs.getString("n_name"), rs.getInt("n_age")));
			}
			
			request.setAttribute("p", p);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}	
}