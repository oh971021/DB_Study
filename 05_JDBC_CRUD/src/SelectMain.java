import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain {
	public static void main(String[] args) throws SQLException {
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM DB_TEST ORDER BY D_NO";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");
		
		// 데이터 조회
		PreparedStatement pstmt = con.prepareStatement(sql);
		
//		System.out.println("누구를 찾으실래요?");
//		String name = k.next();
		
		// 껍데기 시리즈 중 조회하는 기능이 아니면 없어도 됨
		// select 사용할 때만 입력함.
		ResultSet rs = pstmt.executeQuery();
		
		// rs.next() : 다음 레코드로 가는 기능 (화살표 아래로 넘겨 줌)
		//				다음 데이터가 있으면 true, 없으면 false
		while (rs.next()) {
			// rs.getXXXX("컬럼") : 현재 화살표 위치의 컬럼 값 가지고오기.
			System.out.print(rs.getInt("d_no") + "번 ");
			System.out.print(rs.getString("d_name") + " ");
			System.out.println(rs.getInt("d_age") + "살");
			System.out.println("===========");
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
}
