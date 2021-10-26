import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	// 1. Driver load (DB 드라이버 불러옴)
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##ojs";
		String pw = "ojs";
		
	// 2. Connect (DB와 연결)
		Connection con = DriverManager.getConnection(url, id, pw);
		System.out.println("연결 성공");
		
	// 3. Statement (실행도구 생성)
		Statement st = con.createStatement();
		
	// 4. ResultSet (결과 얻기)
		String sql = "select * from db_test";
		ResultSet rs = st.executeQuery(sql); // select 한 DB 테이블이 통째로 rs에 들어가 있다.
		
		if (rs.next()) { // 1행을 가르키게 된다.
		String name = rs.getString("d_name");
		System.out.print(name + " ");
		
		int age = rs.getInt("d_age");
		System.out.println(age);
		}
		
		// 닫을 때는 반대순서로 닫아준다.
		
		rs.close(); // DB와 연결되어 있는 빈껍데기 시리즈들을 닫아준다.
		st.close(); // 닫아주는 이유는 DB와 연결되는 수가 정해져 있끼 때문에
		con.close(); // 닫아주지 않으면 다음에 사용하지 못한다.
		
		
	}
}
