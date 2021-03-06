import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) throws SQLException {

		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM DB_TEST";
		String sql2 = "UPDATE DB_TEST SET D_AGE = ? WHERE D_NO = ?";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");
		
		// 데이터 수정
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt("d_no") + "번 | ");
			System.out.print(rs.getString("d_name") + " | ");
			System.out.print(rs.getInt("d_age") + "살 \n");
			System.out.println("---------------");
		}
		
		pstmt = con.prepareStatement(sql2);
		
		System.out.print("변경하실 나이를 입력해주세요 : ");
		int age = k.nextInt();
		System.out.print("나이를 바꿀 사람을 고르세요 : ");
		int no = k.nextInt();
		
		pstmt.setInt(1, age);
		pstmt.setInt(2, no);
		
		int row = pstmt.executeUpdate();
		
		if (row == 1) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("다시 입력해주세요");
		}
		
		pstmt.close();
		con.close();
		
	}
}
