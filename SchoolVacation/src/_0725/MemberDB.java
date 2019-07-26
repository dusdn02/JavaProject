package _0725;

import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MemberDB extends JFrame implements ActionListener {
	private JMenuItem save, view, exit, selectview;	
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private int numberOfRecord;
	private JTextField textName;
	private JPasswordField textPass;
	private JTextField textNum1;
	private JTextField textNum2;
	private JTextField textPhone;
	private JLabel lbName;
	private JLabel lbPass;
	private JLabel lbNum1;
	private JLabel lbNum2;
	private JLabel lbPhone;
	private JButton nextButton;
	private ResultSet viewRS=null;
		
	public MemberDB() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost:3306/javap", "root","mirim2"); // JDBC 연결
            String sql = "select count(id) from register";			
			pstmt = conn.prepareStatement(sql); // SQL문 처리용 Statement 객체 생성
			ResultSet rs;
			rs = pstmt.executeQuery(); // 레코드 개수를 얻어오는 쿼리
			rs.next();
			numberOfRecord = rs.getInt(1);
		} catch (ClassNotFoundException e) {
			handleError(e.getMessage());
		} catch (SQLException e) {
			handleError(e.getMessage());
		}
		
		setTitle("회원 데이터 베이스"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(6, 2)); 
			
		menuBar = new JMenuBar(); // JMenuBar 컴포넌트를 생성
		menu1 = new JMenu("메뉴");
		menuBar.add(menu1); // 메뉴를 메뉴바에 붙인다
		menu2 = new JMenu("종료");

		// 서브 메뉴
		save = new JMenuItem("회원 등록");
		save.addActionListener(this); // save 메뉴에 대한 이벤트 리스너를 등록
		menu1.add(save); // 메뉴 아이템을 메뉴에 붙인다
		view = new JMenuItem("모든 회원 보기");
		menu1.add(view); // 메뉴 아이템을 메뉴에 붙인다
		view.addActionListener(this); // view 메뉴에 대한 이벤트 리스너를 등록
	
		selectview = new JMenuItem("특정 회원 검색");
		selectview.addActionListener(this); // save 메뉴에 대한 이벤트 리스너를 등록
		menu1.add(selectview); 
				
		exit = new JMenuItem("나가기");
		exit.addActionListener(this); // exit 메뉴에 대한 이벤트 리스너를 등록
		menu2.add(exit); // 메뉴 아이템을 메뉴에 붙인다
		menuBar.add(menu2); // 메뉴를 메뉴바에 붙인다
		setJMenuBar(menuBar); // 메뉴바를 프레임에 붙인다
				
		lbName = new JLabel("성명"); 
		lbName.setSize(50, 20);		
		lbName.setHorizontalAlignment(JLabel.CENTER);		
		textName = new JTextField(20); 
		textName.setSize(80, 20);		
		
		lbPass = new JLabel("비밀번호"); 		
		lbPass.setSize(60, 20);		
		lbPass.setHorizontalAlignment(JLabel.CENTER);		
		textPass = new JPasswordField(20);
		textPass.setSize(80, 20);
				
		lbNum1 = new JLabel("주민번호1");			
		lbNum1.setHorizontalAlignment(JLabel.CENTER);				
		textNum1 = new JTextField(20); 			
		lbNum2 = new JLabel("주민번호2");			
		lbNum2.setHorizontalAlignment(JLabel.CENTER);				
		textNum2 = new JTextField(20); 
					
		lbPhone = new JLabel("전화번호");			
		lbPhone.setHorizontalAlignment(JLabel.CENTER);		
		textPhone = new JTextField(20); 
					
		c.add(lbName);
		c.add(textName);
		c.add(lbPass);
		c.add(textPass);
		c.add(lbNum1);
		c.add(textNum1);
		c.add(lbNum2);
		c.add(textNum2);
		c.add(lbPhone);
		c.add(textPhone);
			
		nextButton = new JButton("다음 회원"); 
		nextButton.addActionListener(this); 		
		JPanel panel = new JPanel();
		panel.setSize(50,50); // 버튼 크기
		panel.add(nextButton);
		c.add(panel,BorderLayout.SOUTH);
		
		setSize(400, 400); 
		setVisible(true); // 프레임이 화면에 나타나도록 설정
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) { // 종료
			System.exit(0);
		} else if (e.getSource() == save) { 	
			    String name = textName.getText();
			    String pass = textPass.getText();
			    String num1 = textNum1.getText();
			    String num2 = textNum2.getText();
			    String phone = textPhone.getText();
				insertMember(name, pass, num1,num2 ,phone); 
			
		}
		else if (e.getSource() == view) { // 
			showMember();
		} else if (e.getSource() == selectview) {			
			String name2 = textName.getText();
			showSelectMember(name2);			
		} else if (e.getSource() == nextButton) { // 
		   try {
			if (viewRS == null || !viewRS.next()) {
				textName.setText("데이타 없음");
				textPass.setText("");
				textNum1.setText("");
				textNum2.setText("");
				textPhone.setText("");
			} else {					
				
				textName.setText(viewRS.getString("name")); // 파일 이름을 textLabel에 출력
				textPass.setText(viewRS.getString("pass")); // 파일 이름을 textLabel에 출력
				textNum1.setText(viewRS.getString("Num1")); // 파일 이름을 textLabel에 출력
				textNum2.setText(viewRS.getString("Num2")); // 파일 이름을 textLabel에 출력
				textPhone.setText(viewRS.getString("Phone")); // 파일 이름을 textLabel에 출력
			}
		} catch (SQLException e1) {
			handleError(e1.getMessage());
		}
	   }
	}
	
	private void showMember() {
		try {
			String sql = "select * from register";
			pstmt=conn.prepareStatement(sql);
			viewRS = pstmt.executeQuery(); // DB에서 모든 사진을 얻어옴
			if (viewRS.next()) { // 첫번째 사진 표시		

				textName.setText(viewRS.getString("name")); // 파일 이름을 textLabel에 출력
				textPass.setText(viewRS.getString("pass")); // 파일 이름을 textLabel에 출력
				textNum1.setText(viewRS.getString("Num1")); // 파일 이름을 textLabel에 출력
				textNum2.setText(viewRS.getString("Num2")); // 파일 이름을 textLabel에 출력
				textPhone.setText(viewRS.getString("Phone")); // 파일 이름을 textLabel에 출력
			} else { 				
				textName.setText("데이타 없음");
			}
		} catch (SQLException e) {
			handleError(e.getMessage());
		}
	}
	private void showSelectMember(String name) {
		try {
			String sql = "select * from register where name=?";
			System.out.println("name:"+name);
			System.out.println("sql:"+sql);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name );
			viewRS = pstmt.executeQuery(); // DB에서 모든 사진을 얻어옴
			if (viewRS.next()) { 
				textName.setText(viewRS.getString("name")); // 파일 이름을 textLabel에 출력
				textPass.setText(viewRS.getString("pass")); // 파일 이름을 textLabel에 출력
				textNum1.setText(viewRS.getString("Num1")); // 파일 이름을 textLabel에 출력
				textNum2.setText(viewRS.getString("Num2")); // 파일 이름을 textLabel에 출력
				textPhone.setText(viewRS.getString("Phone")); // 파일 이름을 textLabel에 출력
			} else { 				
				textName.setText("데이타 없음");
			}
		} catch (SQLException e) {
			handleError(e.getMessage());
		}
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private void insertMember(String n1, String n2, String n3, String n4, String n5) {
        try{            
        	String sql = "insert into register"
        			+ "(id, name, pass, num1, num2, phone) VALUES (?, ?, ?, ?, ?,? )";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,++numberOfRecord);
            pre.setString(2,n1);
            pre.setString(3,n2);
            pre.setString(4,n3);
            pre.setString(5,n4);
            pre.setString(6,n5);
            
            pre.executeUpdate(); // DB에 사진 저장
            textName.setText("");
            textPass.setText("");
            textNum1.setText("");
            textNum2.setText("");
            textPhone.setText("");
            pre.close(); 
        } catch (Exception e){
            handleError(e.getMessage());
        }
	}

	public static void main(String[] args) {
		MemberDB frame = new MemberDB();
	}
}