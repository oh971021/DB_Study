import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain3 {
	public static void main(String[] args) throws SQLException {
		
		Scanner k = new Scanner(System.in);
		
		// ������ ��� �̸� �Է��ϸ� �� ��� ����
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM DB_TEST";
		String sql2 = "DELETE DB_TEST WHERE D_NO = ?";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt("d_no") + "�� | ");
			System.out.print(rs.getString("d_name") + " | ");
			System.out.print(rs.getInt("d_age") + "�� \n");
			System.out.println("---------------");
		} 
		
		System.out.print("������ ��� ��ȣ�� �Է��ϼ��� : ");
		int no = k.nextInt();
		
		pstmt = con.prepareStatement(sql2);
		pstmt.setInt(1, no);
		
		int row = pstmt.executeUpdate();
		if (row == 1) {
			System.out.println(no + "(��/��) ���� �Ϸ�!");
		} 
		
		pstmt.close();
		con.close();
		
		
	}
}
