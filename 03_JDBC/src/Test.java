import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws SQLException {
		
		// 스낵테이블에 있는거 전체 출력
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##ojs";
		String pw = "ojs";
		
		Connection con = DriverManager.getConnection(url, id, pw);
		System.out.println("연결 성공!");
		
		Statement st = con.createStatement();
		System.out.println("도구 생성!");
		
		String sql = "SELECT * FROM SNACK";
		
		ResultSet rs = st.executeQuery(sql);
		System.out.println("SQL문 입력!");
		System.out.println("------------");
		
		while (rs.next()) {
			System.out.println(rs.getString("s_maker"));
			System.out.println(rs.getString("s_name"));
			System.out.println(rs.getInt("s_price"));
			System.out.println("------------");
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
