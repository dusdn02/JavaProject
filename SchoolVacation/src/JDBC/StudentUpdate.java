package JDBC;

import java.sql.*;

public class StudentUpdate {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();// �ʼ�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root", "mirim2");// �ʼ�
			System.out.println("DB ���� �Ϸ�");
			String sql = "update student set dept = '��ǻ�Ͱ���' where id = '1012014'";
			pstmt = conn.prepareStatement(sql);
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
