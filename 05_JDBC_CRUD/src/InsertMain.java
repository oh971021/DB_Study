import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) throws SQLException {

		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "INSERT INTO DB_TEST VALUES (DB_TEST_SEQ.NEXTVAL, ?, ?)";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");
		
		// 데이터 생성
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 데이터 생성 값 작성
		System.out.print("이름 : ");
		String name = k.next();
		System.out.print("나이 : ");
		int age = k.nextInt();
		
		// index는 물음표의 위치로 들어간다.
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
				
		// 도구로 sql문을 생성했으면 execute로 실행해줘야 한다.
		int row = pstmt.executeUpdate(); // CUD 할때 사용ㅎ ㅐ줘야 함.
											// R : executeQuery();
		
		if (row == 1) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("등록 실패!");
		}
		
		pstmt.close();
		con.close();
		
	}
}
