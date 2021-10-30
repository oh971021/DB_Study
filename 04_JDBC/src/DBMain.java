import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) throws SQLException {
		
		// DB ���� �۾�
		// 1. ����
		// : Maven Project�� ����
		
		// CRUD - c : �ڹٷ� ���̺��� �� �ֱ� = rs �ʿ���� (rs�� ��ȸ�� ���� �ʿ���)
		// 2. ������ 3��
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");
		
		Statement st = con.createStatement();
	
		// excuteQuery : Select (R) - ��ȸ�� ���� ���
		// excuteUpdate : ������ (CUD) - ��ȸ �̿��� ������ ������ �̰ɷ� ��
	
		String sql = "insert into db_test values(db_test_seq.nextval, '�ع�', 24)";
		
		// sql�� == 1 �� �� ���� ���� �����ߴ����� ���ڸ� Ȯ���ϴ� ����
		if(st.executeUpdate(sql) == 1) {
			System.out.println("��� ����!");
		} else {
			System.out.println("��� ����!");
		};
		
		st.close();
		con.close();
		
	}
}