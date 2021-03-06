import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) throws SQLException {
		
		// DB 관련 작업
		// 1. 연결
		// : Maven Project로 연결
		
		// CRUD - c : 자바로 테이블에 값 넣기 = rs 필요없음 (rs는 조회할 때만 필요함)
		// 2. 껍데기 3종
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "c##ojs", "ojs");
		System.out.println("연결 성공!");
		
		Statement st = con.createStatement();
	
		// excuteQuery : Select (R) - 조회할 때만 사용
		// excuteUpdate : 나머지 (CUD) - 조회 이외의 데이터 수정은 이걸로 함
	
		String sql = "insert into db_test values(db_test_seq.nextval, '준발', 24)";
		
		// sql문 == 1 은 몇 개의 행을 실행했는지의 숫자를 확인하는 숫자
		if(st.executeUpdate(sql) == 1) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("등록 실패!");
		};
		
		st.close();
		con.close();
		
	}
}
