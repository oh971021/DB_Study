import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BMIMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "INSERT INTO BMI VALUES (BMI_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
				
		// 테이블 - BMI 
				// 번호, 이름, 체중, 키, BMI(소수점 2자리), 결과
				
		try {			
			// 껍데기 3녀석 만들기
			con = DriverManager.getConnection(url, "c##ojs", "ojs");
			
			pstmt = con.prepareStatement(sql);
			
			// 입력 받는 칸
			System.out.print("이름 : ");
			String name = k.next(); 
			System.out.print("체중 : ");
			double weight = k.nextDouble();
			System.out.print("키 : ");
			double height = k.nextDouble();
			double bmi = 0;
			
			// BMI 계산식
			if(height > 3) {
				height /= 100;
			}
			
			String result = "비만";
			
			bmi = weight / (height * height);
			
			if(bmi < 20) {
				result = "저체중";
			}else if(bmi < 25)   {
				result = "정상";
			}else if(bmi < 30)  {
				result = "과체중";
			}

			System.out.print("등록 중");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".");
			Thread.sleep(300);
			System.out.print(".\n");
			
			bmi = Double.parseDouble(String.format("%.2f",bmi));
			
//			System.out.println(name);
//			System.out.println(weight);
//			System.out.println(height);
//			System.out.println(bmi);
//			System.out.println(result);
			
			// 데이터 작성
			pstmt.setString(1, name);
			pstmt.setDouble(2, weight);
			pstmt.setDouble(3, height);
			pstmt.setDouble(4, bmi);
			pstmt.setString(5, result);
			
			// 데이터 삽입
			int row = pstmt.executeUpdate();
			
			if (row == 1) {
				System.out.println("등록 성공!");
				System.out.printf("BMI 수치 : %.2f\n", bmi);
				System.out.printf("%s님, 당신은 %s입니다\n", name, result);
			} else {
				System.out.println("다시 입력해주세요!");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pstmt.close();
			con.close();
		}


		
		
	}
}
