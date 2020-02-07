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
			System.out.println("      ����");
			System.out.println("**************");
			System.out.println("   1.�Է�");
			System.out.println("   2.�˻�");
			System.out.println("   3.����");
			System.out.println("   4.����");
			System.out.println("**************");
			System.out.print("��ȣ ���� : ");
			int choice = scan.nextInt();

			if (choice == 1) {
				insertArticle();
			} else if (choice == 2) {
				selectArticle();
			} else if (choice == 3) {
				deleteArticle();
			} else if (choice == 4) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	private void deleteArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�˻��� ���� : ");
		String name = scan.next();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete student where name like ";

		try {
			pstmt = conn.prepareStatement(sql + "'%" + name.trim() + "%'");
			pstmt.executeUpdate();
			System.out.println("���� �Ϸ�!");
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
		System.out.println("   1.�̸� �˻�");
		System.out.println("   2.��ü �˻�");
		System.out.println("   3.�����޴�");
		System.out.println("**************");
		System.out.print("��ȣ ���� : ");
		int choice = scan.nextInt();

		try {
			if (choice == 1) {
				System.out.print("�˻��� ���� : ");
				String name = scan.next();

				pstmt = conn.prepareStatement(sql2 + "'%" + name.trim() + "%'");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.print("�̸�  = " + rs.getString("name") + "\t");
					if (rs.getInt("code") == 1) {
						System.out.print("�й� = " + rs.getString("value"));
					} else if (rs.getInt("code") == 2) {
						System.out.print("���� = " + rs.getString("value"));
					} else if (rs.getInt("code") == 3) {
						System.out.print("�μ� = " + rs.getString("value"));
					}
					System.out.println();
				}
			} else if (choice == 2) {
				pstmt = conn.prepareStatement(sql);// ����
				rs = pstmt.executeQuery();// ����
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
		System.out.println("   1.�л�");
		System.out.println("   2.����");
		System.out.println("   3.������");
		System.out.println("   4.�����޴�");
		System.out.println("**************");
		System.out.print("��ȣ ���� : ");
		int choice = scan.nextInt();

		if (choice == 1) {
			System.out.print("�̸� �Է� : ");
			name = scan.next();
			System.out.print("�й� �Է� : ");
			value = scan.next();
			code = 1;

		} else if (choice == 2) {
			System.out.print("�̸� �Է� : ");
			name = scan.next();
			System.out.print("���� �Է� : ");
			value = scan.next();
			code = 2;

		} else if (choice == 3) {
			System.out.print("�̸� �Է� : ");
			name = scan.next();
			System.out.print("�μ� �Է� : ");
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

			System.out.println("��� �Ϸ�!");
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
