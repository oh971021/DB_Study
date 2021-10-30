import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) throws SQLException {
		
		// 연결URL
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// 연결 시도 -> 주소 -> 연결할 db 메이커 판단 
		// 자동으로 메이커 맞는 driver 찾아 줌
		
		// 연결
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");
		
		con.close();
	}
}
