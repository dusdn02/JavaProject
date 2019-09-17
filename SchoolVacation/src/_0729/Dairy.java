package _0729;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Dairy extends JFrame {
	public Dairy dairy = null;
	public Lists list = null;
	public Write writeS = null;
	public Write writeM = null;
	public Show show = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private static Vector<String> year = new Vector<String>();
	private static Vector<String> month = new Vector<String>();
	private static Vector<String> day = new Vector<String>();
	private static Vector<String> weather = new Vector<String>();
	private static Vector<String> title = new Vector<String>();
	private static Vector<String> content = new Vector<String>();
	static ResultSet srs = null;
	static int i=0;

	public Dairy() {

//		DefaultListModel model = new DefaultListModel();
		// Write wirte = new Write();

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root", "mirim2");
			System.out.println("DB 연결 완료");
			String sql = "select * from dairy";
			pstmt = conn.prepareStatement(sql); // SQL문 처리용 Statement 객체 생성
//			ResultSet rs;
//			rs = pstmt.executeQuery(); 
			srs = pstmt.executeQuery();
			while (srs.next()) {
				System.out.print(srs.getString("year") + " ");
				year.add(srs.getString("year"));
				System.out.print(srs.getString("month") + " ");
				month.add(srs.getString("month"));
				System.out.print(srs.getString("day") + " ");
				day.add(srs.getString("day"));
				System.out.print(srs.getString("weather") + " ");
				weather.add(srs.getString("weather"));
				System.out.print(srs.getString("title") + " ");
				title.add(srs.getString("title"));
				System.out.print(srs.getString("content") + " ");
				content.add(srs.getString("content"));
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			handleError(e.getMessage());
		} catch (SQLException e) {
			handleError(e.getMessage());
		}

	}

	public void Select(Vector<String> v, JList<String> View) {// String n1, String n2, String n3, String n4, String n5,
																// String n6
		try {
			String sql = "select * from dairy";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();
			while (srs.next()) {
				String date = srs.getString("year") + "." + srs.getString("month") + "." + srs.getString("day");

				v.addElement(date);
//					mo.addElement(date);	

				View.setFont(new Font("", Font.BOLD, 20));
				View.setListData(v);
//					View.setModel(mo);
				View.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			}
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}
	
	public void delete(String n1, String n2, String n3, String n4, String n5, String n6) {//
		try {
			String sql = "delete from dairy where year = ? and month = ? and day = ? and weather = ? and title = ? and content = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n1);
			pstmt.setString(2, n2);
			pstmt.setString(3, n3);
			pstmt.setString(4, n4);
			pstmt.setString(5, n5);
			pstmt.setString(6, n6);
			
			pstmt.executeUpdate();
			
			sql = "select * from dairy";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();
			while (srs.next()) {
				System.out.print(srs.getString("year") + " ");
				System.out.print(srs.getString("month") + " ");
				System.out.print(srs.getString("day") + " ");
				System.out.print(srs.getString("weather") + " ");
				System.out.print(srs.getString("title") + " ");
				System.out.print(srs.getString("content") + " ");
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void update(String n1, String n2, String n3, String n4, String n5, String n6) {
		try {
			String sql = "update dairy set weather = ?, title = ?, content = ? where year = ? and month = ? and day = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n4);
			pstmt.setString(2, n5);
			pstmt.setString(3, n6);
			pstmt.setString(4, n1);
			pstmt.setString(5, n2);
			pstmt.setString(6, n3);

			pstmt.executeUpdate();

			sql = "select * from dairy";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();
			while (srs.next()) {
				System.out.print(srs.getString("year") + " ");
				System.out.print(srs.getString("month") + " ");
				System.out.print(srs.getString("day") + " ");
				System.out.print(srs.getString("weather") + " ");
				System.out.print(srs.getString("title") + " ");
				System.out.print(srs.getString("content") + " ");
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void insertMember(String n1, String n2, String n3, String n4, String n5, String n6) {
		try {
			String sql = "insert into dairy (year, month, day, weather, title, content) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n1);
			pstmt.setString(2, n2);
			pstmt.setString(3, n3);
			pstmt.setString(4, n4);
			pstmt.setString(5, n5);
			pstmt.setString(6, n6);

			pstmt.executeUpdate();

			sql = "select * from dairy";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();
			while (srs.next()) {
				System.out.print(srs.getString("year") + " ");
				System.out.print(srs.getString("month") + " ");
				System.out.print(srs.getString("day") + " ");
				System.out.print(srs.getString("weather") + " ");
				System.out.print(srs.getString("title") + " ");
				System.out.print(srs.getString("content") + " ");
				System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException sqle) {
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException sqle) {
//				}
//
//			}
//		}

	}

	public void change(String panelName) {
		if (panelName.equals("뒤로가기")) {
			getContentPane().removeAll();
			getContentPane().add(list);
			revalidate();
			repaint();
		} else if (panelName.equals("저장")) {
			getContentPane().removeAll();
			getContentPane().add(list);
			list.revalidate();
			list.repaint();
		} else if (panelName.equals("수정")) {
			getContentPane().removeAll();
			getContentPane().add(writeM);
			writeM.revalidate();
			writeM.repaint();
		} else if (panelName.equals("보기")) {
			getContentPane().removeAll();
			getContentPane().add(show);
			show.revalidate();
			show.repaint();
		} else if(panelName.equals("일기 쓰기")){
			getContentPane().removeAll();
			getContentPane().add(writeS);
			writeS.revalidate();
			writeS.repaint();
		}
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	

	public static void main(String[] args) throws SQLException {

		Dairy dairy = new Dairy();

		dairy.setTitle("일기장");
//		dairy.Select();
		dairy.list = new Lists(dairy);// "","","",year, month, day, 

		dairy.writeS = new Write(dairy);
		dairy.writeM = new Write(year, month, day, weather, title, content, dairy);//, i
		
		dairy.show = new Show(year, month, day, weather, title, content, dairy);//, i

		dairy.add(dairy.list);

		dairy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dairy.setLocation(650, 200);
		dairy.setSize(500, 700);
		dairy.setVisible(true);

	}
}
