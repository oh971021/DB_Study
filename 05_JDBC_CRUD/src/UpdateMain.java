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
		System.out.println("���� ����!");
		
		// ������ ����
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt("d_no") + "�� | ");
			System.out.print(rs.getString("d_name") + " | ");
			System.out.print(rs.getInt("d_age") + "�� \n");
			System.out.println("---------------");
		}
		
		pstmt = con.prepareStatement(sql2);
		
		System.out.print("�����Ͻ� ���̸� �Է����ּ��� : ");
		int age = k.nextInt();
		System.out.print("���̸� �ٲ� ����� �������� : ");
		int no = k.nextInt();
		
		pstmt.setInt(1, age);
		pstmt.setInt(2, no);
		
		int row = pstmt.executeUpdate();
		
		if (row == 1) {
			System.out.println("���� �Ϸ�!");
		} else {
			System.out.println("�ٽ� �Է����ּ���");
		}
		
		pstmt.close();
		con.close();
		
	}
}