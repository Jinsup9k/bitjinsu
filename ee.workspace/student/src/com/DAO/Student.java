package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("all")
public class Student {

	public Student() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:xe", "C##java", "bit");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void menu() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("**************");
			System.out.println("      관리");
			System.out.println("**************");
			System.out.println("   1.입력");
			System.out.println("   2.검색");
			System.out.println("   3.삭제");
			System.out.println("   4.종료");
			System.out.println("**************");
			System.out.print("번호 선택 : ");
			int choice = scan.nextInt();

			if (choice == 1) {
				insertArticle();
			} else if (choice == 2) {
				selectArticle();
			} else if (choice == 3) {
				deleteArticle();
			} else if (choice == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private void deleteArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 글자 : ");
		String name = scan.next();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete student where name like ";

		try {
			pstmt = conn.prepareStatement(sql + "'%" + name.trim() + "%'");
			pstmt.executeUpdate();
			System.out.println("삭제 완료!");
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

	private void selectArticle() {
		Scanner scan = new Scanner(System.in);
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student";
		String sql2 = "select * from student where name like ";

		System.out.println("**************");
		System.out.println("   1.이름 검색");
		System.out.println("   2.전체 검색");
		System.out.println("   3.이전메뉴");
		System.out.println("**************");
		System.out.print("번호 선택 : ");
		int choice = scan.nextInt();

		try {
			if (choice == 1) {
				System.out.print("검색할 글자 : ");
				String name = scan.next();

				pstmt = conn.prepareStatement(sql2 + "'%" + name.trim() + "%'");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.print("이름  = " + rs.getString("name") + "\t");
					if (rs.getInt("code") == 1) {
						System.out.print("학번 = " + rs.getString("value"));
					} else if (rs.getInt("code") == 2) {
						System.out.print("과목 = " + rs.getString("value"));
					} else if (rs.getInt("code") == 3) {
						System.out.print("부서 = " + rs.getString("value"));
					}
					System.out.println();
				}
			} else if (choice == 2) {
				pstmt = conn.prepareStatement(sql);// 생성
				rs = pstmt.executeQuery();// 실행
				while (rs.next()) {
					System.out.println(rs.getString("name") + "\t" + rs.getString("value"));
				}
			} else if (choice == 3) {
				return;
			}
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

	private void insertArticle() {
		Scanner scan = new Scanner(System.in);
		String name = null, value = null;
		int code = 0;

		System.out.println("**************");
		System.out.println("   1.학생");
		System.out.println("   2.교수");
		System.out.println("   3.관리자");
		System.out.println("   4.이전메뉴");
		System.out.println("**************");
		System.out.print("번호 선택 : ");
		int choice = scan.nextInt();

		if (choice == 1) {
			System.out.print("이름 입력 : ");
			name = scan.next();
			System.out.print("학번 입력 : ");
			value = scan.next();
			code = 1;

		} else if (choice == 2) {
			System.out.print("이름 입력 : ");
			name = scan.next();
			System.out.print("과목 입력 : ");
			value = scan.next();
			code = 2;

		} else if (choice == 3) {
			System.out.print("이름 입력 : ");
			name = scan.next();
			System.out.print("부서 입력 : ");
			value = scan.next();
			code = 3;

		} else if (choice == 4) {
			return;
		}

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into student(name,value,code) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, code);
			pstmt.executeUpdate();

			System.out.println("등록 완료!");
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
		new Student().menu();
	}
}
