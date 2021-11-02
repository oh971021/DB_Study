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
		System.out.println("���� ����!");
		
		// ������ ����
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// ������ ���� �� �ۼ�
		System.out.print("�̸� : ");
		String name = k.next();
		System.out.print("���� : ");
		int age = k.nextInt();
		
		// index�� ����ǥ�� ��ġ�� ����.
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
				
		// ������ sql���� ���������� execute�� ��������� �Ѵ�.
		int row = pstmt.executeUpdate(); // CUD �Ҷ� ��뤾 ����� ��.
											// R : executeQuery();
		
		if (row == 1) {
			System.out.println("��� ����!");
		} else {
			System.out.println("��� ����!");
		}
		
		pstmt.close();
		con.close();
		
	}
}