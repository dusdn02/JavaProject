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
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();// 필수
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root", "mirim2");// 필수
			System.out.println("DB 연결 완료");
			
			while(true) {
				System.out.println();
				System.out.print("1 입력 , 2 전체 검색 , 3 조건 검색 , 4 정보 수정 , 5 조건 삭제 , 6 종료 >>");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1 ://입력
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
				case 2://전체 검색
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
				case 3://조건 검색
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
				case 4://정보 수정
					System.out.print("어디를  1 name , 2 dept , 3 id >>");
					int where = sc.nextInt();
					System.out.print(w[where-1]+" >>");
					String wh = sc.next();
					System.out.print("어떻게  1 name , 2 dept , 3 id >>");
					int how = sc.nextInt();
					System.out.print(w[how-1]+" >>");
					String ho = sc.next();					
					sql = "update student set "+w[how-1]+" = ? where "+w[where-1]+" = ?";
					pstmt = conn.prepareStatement(sql);//에러
					pstmt.setString(how, wh);
					pstmt.setString(where, ho);
					
					pstmt.executeUpdate();
					break;
				case 5://조건 삭제
					System.out.print("1 name , 2 dept , 3 id >>");
					where = sc.nextInt();
					sql = "delete from student where "+w[where-1]+" = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(where, input[where-1]);
					
					pstmt.executeUpdate();
					break;
				case 6://종료
					System.out.println("종료합니다.");
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
