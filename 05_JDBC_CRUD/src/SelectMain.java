import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain {
	public static void main(String[] args) throws SQLException {
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM DB_TEST ORDER BY D_NO";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");
		
		// ������ ��ȸ
		PreparedStatement pstmt = con.prepareStatement(sql);
		
//		System.out.println("������ ã���Ƿ���?");
//		String name = k.next();
		
		// ������ �ø��� �� ��ȸ�ϴ� ����� �ƴϸ� ��� ��
		// select ����� ���� �Է���.
		ResultSet rs = pstmt.executeQuery();
		
		// rs.next() : ���� ���ڵ�� ���� ��� (ȭ��ǥ �Ʒ��� �Ѱ� ��)
		//				���� �����Ͱ� ������ true, ������ false
		while (rs.next()) {
			// rs.getXXXX("�÷�") : ���� ȭ��ǥ ��ġ�� �÷� �� ����������.
			System.out.print(rs.getInt("d_no") + "�� ");
			System.out.print(rs.getString("d_name") + " ");
			System.out.println(rs.getInt("d_age") + "��");
			System.out.println("===========");
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
}