import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) throws SQLException {
		
		// DB ���� �۾�
		// 1���� : DB ����
		// ������ �ø���
		// ���ϵ� CRUD
		
		// ����̹��� �ҷ��;� ��� ������. (driver load) : ojdbc�� �ҷ����� ��
				// �����н��� �����ϱ�
		
		// ���� (connection)	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("���� ����!");
		
		// ���൵�� ���� (statement)
		Statement st = con.createStatement();
		
		// ��� ��� (resultset)
		// ���ϴ� SQL�� �Է��ϱ�
		String sql = "SELECT * FROM DB_TEST";
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {			 
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("-----");			
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}