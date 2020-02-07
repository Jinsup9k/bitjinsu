package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("all")
public class Student2 {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.56:1521:xe";
	private String username = "C##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	public Student2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void menu() {
		while (true) {
			System.out.println();
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.(1~4)");
			}
		}
	}

	private void deleteArticle() {
		System.out.print("�˻��� ���� : ");
		String name = scan.next();

		conn = getConnection();
		String sql = "delete student where name=?";

		try {
			pstmt = conn.prepareStatement(sql + name);
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "�� ���� �Ϸ�!");
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
		conn = getConnection();

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
				String sql1 = "select * from student where name like ";

				pstmt = conn.prepareStatement(sql1 + "'%" + name.trim() + "%'");
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
				String sql2 = "select * from student";
				
				pstmt = conn.prepareStatement(sql2);// ����
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
		String name = null, value = null;

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
		} else if (choice == 2) {
			System.out.print("�̸� �Է� : ");
			name = scan.next();
			System.out.print("���� �Է� : ");
			value = scan.next();
		} else if (choice == 3) {
			System.out.print("�̸� �Է� : ");
			name = scan.next();
			System.out.print("�μ� �Է� : ");
			value = scan.next();
		} else if (choice == 4) {
			return;
		}

		conn = getConnection();
		String sql = "insert into student(name,value,code) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, choice);
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
		new Student2().menu();
	}
}
