import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMain2 {
	public static void main(String[] args) throws SQLException {
		
		// ����� �̸�, ���̸� �Է��ؼ� DB�� �����Ѵ�.
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");

		
		System.out.println("�̸� : ");
		String name = k.next();
		System.out.println("���� : ");
		int age = k.nextInt();
		
		Statement st = con.createStatement();
	
		String sql = "insert into db_test values(db_test_seq.nextval, '" + name + "', " + age + ")";
		System.out.println(sql);
		
		if(st.executeUpdate(sql) == 1) {
			System.out.println("��� ����!");
		} else {
			System.out.println("��� ����!");
		};
		
		st.close();
		con.close();
	}
}