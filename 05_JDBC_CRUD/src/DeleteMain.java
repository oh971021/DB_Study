import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) throws SQLException {
		
		Scanner k = new Scanner(System.in);
		
		// 삭제할 사람 이름 입력하면 그 사람 삭제
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "DELETE DB_TEST WHERE D_NAME = ?";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		System.out.print("이름 : ");
		String name = k.next();
		
		pstmt.setString(1, name);
		
		int row = pstmt.executeUpdate();
		if (row == 1) {
			System.out.println(name + "(을/를) 삭제 완료!");
		} else {
			System.out.println(name + "에 해당하는 여러 행이 삭제되었습니다!");
		}
		
		pstmt.close();
		con.close();
		
		
	}
}
