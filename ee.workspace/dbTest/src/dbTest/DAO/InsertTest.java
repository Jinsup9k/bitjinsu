package dbTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {

	public InsertTest() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loading success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:xe", "C##java", "bit");
			System.out.println("connection success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("키 입력 : ");
		double height = scan.nextDouble();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into dbtest(name,age,height,logtime) values(?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);

			int su = pstmt.executeUpdate();// 실행 - 개수가 리턴
			System.out.println(su + "updated");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.insertArticle();
	}
}
