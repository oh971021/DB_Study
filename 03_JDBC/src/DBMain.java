import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) throws SQLException {
		
		// DB 관련 작업
		// 1순위 : DB 연결
		// 껍데기 시리즈
		// 뭘하든 CRUD
		
		// 드라이버를 불러와야 사용 가능함. (driver load) : ojdbc를 불러오는 것
				// 빌드패스로 연결하기
		
		// 연결 (connection)	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");
		
		// 실행도구 생성 (statement)
		Statement st = con.createStatement();
		
		// 결과 얻기 (resultset)
		// 원하는 SQL문 입력하기
		String sql = "SELECT * FROM DB_TEST";
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {			 
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("-----");			
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
