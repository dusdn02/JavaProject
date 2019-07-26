package _0726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManage {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		String sql = null;
		ResultSet srs = null;
		String[] input = new String[3];
		String[] w = {"name","dept","id"};
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();// �ʼ�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root", "mirim2");// �ʼ�
			System.out.println("DB ���� �Ϸ�");
			
			while(true) {
				System.out.println();
				System.out.print("1 �Է� , 2 ��ü �˻� , 3 ���� �˻� , 4 ���� ���� , 5 ���� ���� , 6 ���� >>");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1 ://�Է�
					System.out.print("name >>");
					input[0] = sc.next();
					System.out.print("dept >>");
					input[1] = sc.next();
					System.out.print("id >>");
					input[2] = sc.next();
					
					sql = "insert into student (name, dept, id) values(?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, input[0]);
					pstmt.setString(2, input[1]);
					pstmt.setString(3, input[2]);
					
					pstmt.executeUpdate();
					break;
				case 2://��ü �˻�
					sql = "select * from student";
					pstmt = conn.prepareStatement(sql);
					srs = pstmt.executeQuery();
					System.out.println("Name    Dept      id");
					while(srs.next()) {
						System.out.print(srs.getString("name")+" ");
						System.out.print(srs.getString("dept")+" ");
						System.out.print(srs.getString("id")+" ");
						System.out.println();
					}
					break;
				case 3://���� �˻�
					System.out.print("1 name , 2 dept , 3 id >>");
					int ch= sc.nextInt();
					System.out.print(w[ch-1]+" >>");
					input[ch-1] = sc.next();
					sql = "select * from student where "+w[ch-1]+" = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, input[ch-1]);
					
					srs = pstmt.executeQuery();
					System.out.println("Name    Dept      id");
					while(srs.next()) {
						System.out.print(srs.getString("name")+" ");
						System.out.print(srs.getString("dept")+" ");
						System.out.print(srs.getString("id")+" ");
						System.out.println();
					}
					break;
				case 4://���� ����
					System.out.print("���  1 name , 2 dept , 3 id >>");
					int where = sc.nextInt();
					System.out.print(w[where-1]+" >>");
					String wh = sc.next();
					System.out.print("���  1 name , 2 dept , 3 id >>");
					int how = sc.nextInt();
					System.out.print(w[how-1]+" >>");
					String ho = sc.next();					
					sql = "update student set "+w[how-1]+" = ? where "+w[where-1]+" = ?";
					pstmt = conn.prepareStatement(sql);//����
					pstmt.setString(how, wh);
					pstmt.setString(where, ho);
					
					pstmt.executeUpdate();
					break;
				case 5://���� ����
					System.out.print("1 name , 2 dept , 3 id >>");
					where = sc.nextInt();
					sql = "delete from student where "+w[where-1]+" = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(where, input[where-1]);
					
					pstmt.executeUpdate();
					break;
				case 6://����
					System.out.println("�����մϴ�.");
					System.exit(0);
					break;
				}
			}
		
		}catch(SQLException ex) {
			System.out.println("SQLException:"+ex);
		}catch(Exception ex) {
			System.out.println("Exception:"+ex);
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException sqle) {	}
			}
		}
	
	}
}
