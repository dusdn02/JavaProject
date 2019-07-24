package JDBC;

import java.sql.*;

public class DriverTest {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();//�ʼ�
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap","root","mirim2");//�ʼ�
			System.out.println("Success");
		}catch(SQLException ex) {
			System.out.println("SQLException:"+ex);
		}catch(Exception ex) {
			System.out.println("Exception:"+ex);
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException sqle) {	}
			}
		}
	}

}
