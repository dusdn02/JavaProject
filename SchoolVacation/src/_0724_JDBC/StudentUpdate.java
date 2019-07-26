package _0724_JDBC;

import java.sql.*;
import java.util.Scanner;

public class StudentUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println("dept >>");
		String dept = sc.next();
		System.out.println("id >>");
		String id = sc.next();
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();// 필수
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root", "mirim2");// 필수
			System.out.println("DB 연결 완료");
			String sql = "update student set dept = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			pstmt.setString(2, id);
			
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
