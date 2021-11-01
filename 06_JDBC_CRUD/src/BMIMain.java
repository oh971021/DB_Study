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
				
		// ���̺� - BMI 
				// ��ȣ, �̸�, ü��, Ű, BMI(�Ҽ��� 2�ڸ�), ���
				
		try {			
			// ������ 3�༮ �����
			con = DriverManager.getConnection(url, "c##ojs", "ojs");
			
			pstmt = con.prepareStatement(sql);
			
			// �Է� �޴� ĭ
			System.out.print("�̸� : ");
			String name = k.next(); 
			System.out.print("ü�� : ");
			double weight = k.nextDouble();
			System.out.print("Ű : ");
			double height = k.nextDouble();
			double bmi = 0;
			
			// BMI ����
			if(height > 3) {
				height /= 100;
			}
			
			String result = "��";
			
			bmi = weight / (height * height);
			
			if(bmi < 20) {
				result = "��ü��";
			}else if(bmi < 25)   {
				result = "����";
			}else if(bmi < 30)  {
				result = "��ü��";
			}

			System.out.print("��� ��");
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
			
			// ������ �ۼ�
			pstmt.setString(1, name);
			pstmt.setDouble(2, weight);
			pstmt.setDouble(3, height);
			pstmt.setDouble(4, bmi);
			pstmt.setString(5, result);
			
			// ������ ����
			int row = pstmt.executeUpdate();
			
			if (row == 1) {
				System.out.println("��� ����!");
				System.out.printf("BMI ��ġ : %.2f\n", bmi);
				System.out.printf("%s��, ����� %s�Դϴ�\n", name, result);
			} else {
				System.out.println("�ٽ� �Է����ּ���!");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pstmt.close();
			con.close();
		}


		
		
	}
}
