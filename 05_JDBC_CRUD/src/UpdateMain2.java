import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain2 {
	public static void main(String[] args) throws SQLException {
		// �ع� 2 �̸��� '��' �� �� ����� ���̸� 30���� ����
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM DB_TEST";
		String sql2 = "UPDATE DB_TEST SET D_AGE = ? WHERE D_NAME like '%' || ? || '%'";
		// ���� �� [���۸�]
		// = jdbc sql like (like ������ �ٿ�� ����)
		
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
		
		System.out.print("���� �˻��� (�̸�) : ");
		String name = k.next();
		System.out.print("�����Ͻ� ���̸� �Է����ּ��� : ");
		int age = k.nextInt();
		
		pstmt.setInt(1, age);
		pstmt.setString(2, name);
		
		int row = pstmt.executeUpdate();
		
		if (row >= 1) {
			System.out.println("���� �Ϸ�!");
		} else {
			System.out.println("�ٽ� �Է����ּ���");
		}
		
		pstmt.close();
		con.close();
		
	}
}