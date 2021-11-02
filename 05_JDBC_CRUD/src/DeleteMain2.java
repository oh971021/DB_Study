import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain2 {
	public static void main(String[] args) throws SQLException {
		
		Scanner k = new Scanner(System.in);
		
		// ������ ��� �̸� �Է��ϸ� �� ��� ����
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "DELETE DB_TEST WHERE D_NO = ?";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		System.out.print("��ȣ : ");
		int no = k.nextInt();
		
		pstmt.setInt(1, no);
		
		int row = pstmt.executeUpdate();
		if (row == 1) {
			System.out.println(no + "(��/��) ���� �Ϸ�!");
		} 
		
		pstmt.close();
		con.close();
		
		
	}
}