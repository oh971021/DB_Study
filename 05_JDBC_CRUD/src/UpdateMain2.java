import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain2 {
	public static void main(String[] args) throws SQLException {
		// 준발 2 이름이 '발' 이 들어간 사람의 나이를 30으로 수정
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM DB_TEST";
		String sql2 = "UPDATE DB_TEST SET D_AGE = ? WHERE D_NAME like '%' || ? || '%'";
		// 포함 쪽 [구글링]
		// = jdbc sql like (like 문법의 바운딩 사용법)
		
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
		
		System.out.print("포함 검색어 (이름) : ");
		String name = k.next();
		System.out.print("변경하실 나이를 입력해주세요 : ");
		int age = k.nextInt();
		
		pstmt.setInt(1, age);
		pstmt.setString(2, name);
		
		int row = pstmt.executeUpdate();
		
		if (row >= 1) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("다시 입력해주세요");
		}
		
		pstmt.close();
		con.close();
		
	}
}
