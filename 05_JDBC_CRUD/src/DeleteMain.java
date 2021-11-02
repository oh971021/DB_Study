import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) throws SQLException {
		
		Scanner k = new Scanner(System.in);
		
		// ������ ��� �̸� �Է��ϸ� �� ��� ����
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "DELETE DB_TEST WHERE D_NAME = ?";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		System.out.print("�̸� : ");
		String name = k.next();
		
		pstmt.setString(1, name);
		
		int row = pstmt.executeUpdate();
		if (row == 1) {
			System.out.println(name + "(��/��) ���� �Ϸ�!");
		} else {
			System.out.println(name + "�� �ش��ϴ� ���� ���� �����Ǿ����ϴ�!");
		}
		
		pstmt.close();
		con.close();
		
		
	}
}