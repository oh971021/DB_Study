package com.js.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// DAO( Data Access Object )
// DB 관련 작업 정리하는 Model
public class DAO_Member {
	
	public static ArrayList<Member> showAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			System.out.println("연결 성공");
			
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Member> members = new ArrayList<Member>();
			Member m = null;
			
			while (rs.next()) {
				// 값을 넣을 객체 생성하기
				m = new Member();

				m.setNo(rs.getInt("m_no"));
				m.setName(rs.getString("m_name")); 
			    m.setAge(rs.getInt("m_age"));

			    // 만들어진 객체 추가하기
			    members.add(m);
			}
			
			return members;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}
	
}
