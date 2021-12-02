package com.js.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.net.aso.m;

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

	public static String regMember(Member m) {

		// �� �ޱ� : �𵨿��� �۾��س���
		// ������ �����
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBManager.connect();
			
			String sql = "insert into member values(member_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setInt(2, m.getAge());
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("��� ����");
				return "��� ����";
			} else {
				return "��� ����";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "DB ���� ����";
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
	
	
	
}
