package dbTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {

	public UpdateTest() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##java", "bit");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 글자 : ");
		String name = scan.next();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update dbtest set age = age + 1 where name like ";
		try {
			pstmt = conn.prepareStatement(sql + "'%" + name.trim() + "%'");
			
			int su = pstmt.executeUpdate();
			System.out.println(su + "updated");
		} catch (SQLException e) {
			e.printStackTrace();
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
		UpdateTest ut = new UpdateTest();
		ut.updateArticle();
	}
}
