import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMain2 {
	public static void main(String[] args) throws SQLException {
		
		// 사람의 이름, 나이를 입력해서 DB에 저장한다.
		
		Scanner k = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");

		
		System.out.println("이름 : ");
		String name = k.next();
		System.out.println("나이 : ");
		int age = k.nextInt();
		
		Statement st = con.createStatement();
	
		String sql = "insert into db_test values(db_test_seq.nextval, '" + name + "', " + age + ")";
		System.out.println(sql);
		
		if(st.executeUpdate(sql) == 1) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("등록 실패!");
		};
		
		st.close();
		con.close();
	}
}
