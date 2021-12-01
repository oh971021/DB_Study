package com.js.hc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB���� �۾��� ��, �Ź� �����ڵ带 �� ���� �۾��� �ؿԴ�.

// �װ� AOP(��������)���� ��������
public class DBManager {

	// DB �۾� �� ������ ���� �۾�
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// ���� ����ϴ� ������ con ���� �޾� ���ű� ������ return �� ���ش�.
		return DriverManager.getConnection(url, "c##ojs", "ojs");
	}

	// ������ ������ �ѹ��� �ݱ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		// �ݴ� �� �������� �ݾ��ش�.
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
		
	}
	
}
