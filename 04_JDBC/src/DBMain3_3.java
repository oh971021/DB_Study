import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMain3_3 {
	public static void main(String[] args) throws SQLException {
		
		// ���� ���̺� ���� �ϳ� �ֱ�
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "insert into snack values(snack_seq.nextval, ?, ?, ?, ?,  sysdate)";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");

		System.out.println("�̸� : ");
		String name = k.next();
		System.out.println("����Ŀ : ");
		String maker = k.next();
		System.out.println("���� : ");
		double weight = k.nextInt();
		System.out.println("���� : ");
		int price = k.nextInt();
	
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setNString(1, name);
		pstmt.setNString(2, maker);
		pstmt.setDouble(3, weight);
		pstmt.setInt(4, price);
		
		System.out.println(sql);
		
		if(pstmt.executeUpdate() == 1) {
			System.out.println("��� ����!");
		} else {
			System.out.println("��� ����!");
		};
		
		pstmt.close();
		con.close();
	}
}