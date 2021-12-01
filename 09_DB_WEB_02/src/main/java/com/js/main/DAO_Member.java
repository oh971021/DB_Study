package com.js.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// DAO( Data Access Object )
// DB ���� �۾� �����ϴ� Model
public class DAO_Member {
	
	public static ArrayList<Member> showAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			System.out.println("���� ����");
			
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Member> members = new ArrayList<Member>();
			Member m = null;
			
			while (rs.next()) {
				// ���� ���� ��ü �����ϱ�
				m = new Member();

				m.setNo(rs.getInt("m_no"));
				m.setName(rs.getString("m_name")); 
			    m.setAge(rs.getInt("m_age"));

			    // ������� ��ü �߰��ϱ�
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
