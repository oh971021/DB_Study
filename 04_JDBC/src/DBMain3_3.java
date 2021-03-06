import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMain3_3 {
	public static void main(String[] args) throws SQLException {
		
		// 과자 테이블 과자 하나 넣기
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "insert into snack values(snack_seq.nextval, ?, ?, ?, ?,  sysdate)";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");

		System.out.println("이름 : ");
		String name = k.next();
		System.out.println("메이커 : ");
		String maker = k.next();
		System.out.println("무게 : ");
		double weight = k.nextInt();
		System.out.println("가격 : ");
		int price = k.nextInt();
	
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setNString(1, name);
		pstmt.setNString(2, maker);
		pstmt.setDouble(3, weight);
		pstmt.setInt(4, price);
		
		System.out.println(sql);
		
		if(pstmt.executeUpdate() == 1) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("등록 실패!");
		};
		
		pstmt.close();
		con.close();
	}
}
