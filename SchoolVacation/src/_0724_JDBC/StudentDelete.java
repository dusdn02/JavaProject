package _0724_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDelete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println("id >>");
		String id = sc.next();
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();// �ʼ�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root", "mirim2");// �ʼ�
			System.out.println("DB ���� �Ϸ�");
			String sql = "delete from student where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			sql = "select * from student where id = ?";
			pstmt.setString(1, id);
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			System.out.println("Name   Dept      id");
			while(srs.next()) {
				System.out.print(srs.getString("name")+" ");
				System.out.print(srs.getString("dept")+" ");
				System.out.print(srs.getString("id")+" ");
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				}

			}
		}

	}
}
