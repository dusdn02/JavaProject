package JDBC;

import java.sql.*;

public class StudentUpdate {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();// 필수
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root", "mirim2");// 필수
			System.out.println("DB 연결 완료");
			String sql = "update student set dept = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "컴퓨터공학");
			pstmt.setString(2, "1012019");
			
			pstmt.executeUpdate();
			
			sql = "select * from student where id = '1012014'";
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
