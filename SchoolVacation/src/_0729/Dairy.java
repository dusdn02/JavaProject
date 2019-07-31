package _0729;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

class Lists extends JPanel{
	private JButton Additional;
	private JList<String> View;
	private Dairy dairy;
	
	Lists(String y, String m, String d, Dairy dairy){
		this.dairy = dairy;
		setLayout(null);
		
		String[] date = {y+"."+m+"."+d};
		
//			v.add(date);
//		System.out.println(date);
		View = new JList<String>();
		View.setFont(new Font("", Font.PLAIN, 20));
		 if(!(y.equals("")&&m.equals("")&&d.equals(""))) {
			View.setListData(date);
			//View.add(date);
		 }
		
		View.setBounds(20, 20, 400, 500);
		
		add(View);
		
		Additional = new JButton("추가");
		Additional.setHorizontalAlignment(JTextField.CENTER);
		Additional.setFont(new Font("", Font.PLAIN, 20));
		Additional.setBounds(200, 580, 80, 50);
		
		add(Additional);
		
		
		Additional.addActionListener(new WritingActionListener());
		System.out.println("Lists 확인");
		
	}
	class WritingActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dairy.change("일기 쓰기");
		}
	}
	
}

class Write extends JPanel{
	private JButton save;
	private JButton back;
	private JTextField yearT;
	private JTextField monthT;
	private JTextField dayT;
	private JTextField weatherT;
	private JTextField titleT;
	private JTextArea contentT;
	private Dairy dairy;
	
	public Write(Dairy dairy){//
		this.dairy = dairy;
		setLayout(null);
		
		yearT = new JTextField("year");
		yearT.setHorizontalAlignment(JTextField.CENTER);
		yearT.setFont(new Font("", Font.PLAIN, 20));
		yearT.setBounds(55, 10, 90, 30);
		
		monthT = new JTextField("month");
		monthT.setHorizontalAlignment(JTextField.CENTER);
		monthT.setFont(new Font("", Font.PLAIN, 20));
		monthT.setBounds(150, 10, 60, 30);
		
		dayT = new JTextField("day");
		dayT.setHorizontalAlignment(JTextField.CENTER);
		dayT.setFont(new Font("", Font.PLAIN, 20));
		dayT.setBounds(215, 10, 60, 30);
		
		weatherT = new JTextField("weather");
		weatherT.setHorizontalAlignment(JTextField.CENTER);
		weatherT.setFont(new Font("", Font.PLAIN, 20));
		weatherT.setBounds(305, 10, 120, 30);
		
		titleT = new JTextField("최대 50자");
		titleT.setFont(new Font("", Font.PLAIN, 20));
		titleT.setBounds(40, 70, 400, 30);
		
		contentT = new JTextArea("최대 500자");
		contentT.setLineWrap(true);
		contentT.setFont(new Font("", Font.PLAIN, 20));
		contentT.setBounds(40, 110, 400, 440);
		
		save = new JButton("저장");
		save.setBounds(40, 570, 180, 30);
		back = new JButton("뒤로가기");
		back.setBounds(260, 570, 180, 30);
		
		//Dairy dairy = new Dairy(yearText, monthText, dayText, weatherText, titleText, cotentText);
		//Dairy dairy = new Dairy();
		
		add(yearT);
		add(monthT);
		add(dayT);
		add(weatherT);
		add(titleT);
		add(contentT);
		add(save);
		add(back);
		
		
		save.addActionListener(new SavingActionListener());
		back.addActionListener(new BackActionListener());
		
		System.out.println("Write 확인");
		
	}
	class SavingActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				//db에 저장
			String year = yearT.getText();
			System.out.println(year);
		    String month = monthT.getText();
		    String day = dayT.getText();
		    String weather = weatherT.getText();
		    String title = titleT.getText();
		    String content = contentT.getText();
			dairy.insertMember(year, month, day, weather ,title, content); 
			Lists list = new Lists(year, month, day, dairy);
			dairy.change("저장");	
			
		}
	}
	class BackActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				dairy.change("뒤로가기");
			
		}
	}
}

class Show extends JPanel{
	private JButton Modify;
	private JButton back;
	private JLabel year;
	private JLabel month;
	private JLabel day;
	private JLabel weather;
	private JLabel title;
	private JLabel content;
	private Dairy dairy;
	
	Show(Dairy dairy){
		this.dairy = dairy;
		setLayout(null);
		
		year = new JLabel();
		year.setHorizontalAlignment(JTextField.CENTER);
		year.setFont(new Font("", Font.PLAIN, 20));//글자 크기
		year.setBounds(55, 10, 90, 30);//위치
		
		month = new JLabel();
		month.setHorizontalAlignment(JTextField.CENTER);
		month.setFont(new Font("", Font.PLAIN, 20));
		month.setBounds(150, 10, 60, 30);
		
		day = new JLabel();
		day.setHorizontalAlignment(JTextField.CENTER);
		day.setFont(new Font("", Font.PLAIN, 20));
		day.setBounds(215, 10, 60, 30);
		
		weather = new JLabel();
		weather.setHorizontalAlignment(JTextField.CENTER);
		weather.setFont(new Font("", Font.PLAIN, 20));
		weather.setBounds(305, 10, 120, 30);
		
		title = new JLabel();
		title.setFont(new Font("", Font.PLAIN, 20));
		title.setBounds(40, 70, 400, 30);
		
		content = new JLabel();
		content.setFont(new Font("", Font.PLAIN, 20));
		content.setBounds(40, 110, 400, 440);
		
		Modify = new JButton("저장");
		Modify.setBounds(40, 570, 180, 30);
		back = new JButton("뒤로가기");
		back.setBounds(260, 570, 180, 30);
		
		
		add(year);
		add(month);
		add(day);
		add(weather);
		add(title);
		add(content);
		add(Modify);
		add(back);
		
		
		Modify.addActionListener(new ModifyActionListener());
		back.addActionListener(new BackActionListener());
		
	}
	class ModifyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//db업데이트
				dairy.change("수정");	
			
		}
	}
	class BackActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				dairy.change("뒤로가기");
			
		}
		
	}
}


public class Dairy extends JFrame{
	
	public Lists list = null;
	public Write write = null;
	public Show show = null;
	private int numberOfRecord;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private AbstractButton year;
	private AbstractButton month;
	private AbstractButton day;
	private AbstractButton weather;
	private AbstractButton title;
	private AbstractButton content;
	
	public Dairy() {
		
//		DefaultListModel model = new DefaultListModel();
		//Write wirte = new Write();
		
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javap", "root","mirim2");
			System.out.println("DB 연결 완료");
			String sql = "select * from dairy";	
			pstmt = conn.prepareStatement(sql); // SQL문 처리용 Statement 객체 생성
			ResultSet rs;
			rs = pstmt.executeQuery(); // 레코드 개수를 얻어오는 쿼리
//			System.out.println(rs.next());
//			numberOfRecord = rs.getInt(1);
			System.out.println("**********************");
		} catch (ClassNotFoundException e) {
			handleError(e.getMessage());
		} catch (SQLException e) {
			handleError(e.getMessage());
		}
		

	}
		
	public void insertMember(String n1, String n2, String n3, String n4, String n5, String n6) {
		try {
			String sql = "insert into dairy (year, month, day, weather, title, content) values(?,?,?,?,?,?)";	
            PreparedStatement pre = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,n1);
			pstmt.setString(2,n2);
			pstmt.setString(3,n3);
			pstmt.setString(4,n4);
			pstmt.setString(5,n5);
			pstmt.setString(6,n6);
			
			pstmt.executeUpdate();

			sql = "select * from dairy";
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			while(srs.next()) {
				System.out.print(srs.getString("year")+" ");
				System.out.print(srs.getString("month")+" ");
				System.out.print(srs.getString("day")+" ");
				System.out.print(srs.getString("weather")+" ");
				System.out.print(srs.getString("title")+" ");
				System.out.print(srs.getString("content")+" ");
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
		
		
//		try{            
//        	String sql = "insert into dairy (year, month, day, weather, title, content) values(?,?,?,?,?,?)";	
//            PreparedStatement pre = conn.prepareStatement(sql);
////           pre.setInt(1,++numberOfRecord);
//            pre.setString(1,n1);
//            pre.setString(2,n2);
//            pre.setString(3,n3);
//            pre.setString(4,n4);
//            pre.setString(5,n5);
//            pre.setString(6,n6);
//            
//            pre.executeUpdate(); // DB에 사진 저장
//            year.setText("");
//            month.setText("");
//            day.setText("");
//            weather.setText("");
//            title.setText("");
//            content.setText("");
//            pre.close(); 
//        } catch (Exception e){
//            handleError(e.getMessage());
//        }
	
}
	
	public void change(String panelName) {
		if(panelName.equals("뒤로가기")) {
			getContentPane().removeAll();
			getContentPane().add(list);
			revalidate();
			repaint();
		}else if(panelName.equals("저장")) {
			getContentPane().removeAll();
			getContentPane().add(list);
			revalidate();
			repaint();
		}else if(panelName.equals("수정")) {
			getContentPane().removeAll();
			getContentPane().add(write);
			revalidate();
			repaint();
		}else if(panelName.equals("보기")) {
			getContentPane().removeAll();
			getContentPane().add(show);
			revalidate();
			repaint();
		}else {
			getContentPane().removeAll();
			getContentPane().add(write);
			revalidate();
			repaint();
		}
	}
	
	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}

	public static void main(String[] args) {
		
		Dairy dairy = new Dairy();
		dairy.setTitle("일기장");
		dairy.list = new Lists("","","",dairy);
		dairy.write = new Write(dairy);
		dairy.show = new Show(dairy);
	
//		Write write = new Write();
		
//		Dairy dairy= new Dairy();
		
//		Show show = new Show();
		
		//contentpan.add(write);
		dairy.add(dairy.list);
		
		dairy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dairy.setLocation(650, 200);
		dairy.setSize(500, 700);
		dairy.setVisible(true);
		
	}
}
