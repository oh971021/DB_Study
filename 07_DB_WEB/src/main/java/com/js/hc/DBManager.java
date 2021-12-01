package com.js.hc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB관련 작업할 때, 매번 연결코드를 쓴 이후 작업을 해왔다.

// 그걸 AOP(관점지향)으로 정리하자
public class DBManager {

	// DB 작업 시 연결을 위한 작업
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 실제 사용하는 곳에선 con 에서 받아 쓸거기 떄문에 return 을 해준다.
		return DriverManager.getConnection(url, "c##ojs", "ojs");
	}

	// 닫을게 많은데 한번에 닫기
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		// 닫는 건 역순으로 닫아준다.
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
