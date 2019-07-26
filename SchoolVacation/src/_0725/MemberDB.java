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
					+ "//localhost:3306/javap", "root","mirim2"); // JDBC ����
            String sql = "select count(id) from register";			
			pstmt = conn.prepareStatement(sql); // SQL�� ó���� Statement ��ü ����
			ResultSet rs;
			rs = pstmt.executeQuery(); // ���ڵ� ������ ������ ����
			rs.next();
			numberOfRecord = rs.getInt(1);
		} catch (ClassNotFoundException e) {
			handleError(e.getMessage());
		} catch (SQLException e) {
			handleError(e.getMessage());
		}
		
		setTitle("ȸ�� ������ ���̽�"); // ������ Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ���� ��ư(X)�� Ŭ���ϸ� ���α׷� ����
		
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(6, 2)); 
			
		menuBar = new JMenuBar(); // JMenuBar ������Ʈ�� ����
		menu1 = new JMenu("�޴�");
		menuBar.add(menu1); // �޴��� �޴��ٿ� ���δ�
		menu2 = new JMenu("����");

		// ���� �޴�
		save = new JMenuItem("ȸ�� ���");
		save.addActionListener(this); // save �޴��� ���� �̺�Ʈ �����ʸ� ���
		menu1.add(save); // �޴� �������� �޴��� ���δ�
		view = new JMenuItem("��� ȸ�� ����");
		menu1.add(view); // �޴� �������� �޴��� ���δ�
		view.addActionListener(this); // view �޴��� ���� �̺�Ʈ �����ʸ� ���
	
		selectview = new JMenuItem("Ư�� ȸ�� �˻�");
		selectview.addActionListener(this); // save �޴��� ���� �̺�Ʈ �����ʸ� ���
		menu1.add(selectview); 
				
		exit = new JMenuItem("������");
		exit.addActionListener(this); // exit �޴��� ���� �̺�Ʈ �����ʸ� ���
		menu2.add(exit); // �޴� �������� �޴��� ���δ�
		menuBar.add(menu2); // �޴��� �޴��ٿ� ���δ�
		setJMenuBar(menuBar); // �޴��ٸ� �����ӿ� ���δ�
				
		lbName = new JLabel("����"); 
		lbName.setSize(50, 20);		
		lbName.setHorizontalAlignment(JLabel.CENTER);		
		textName = new JTextField(20); 
		textName.setSize(80, 20);		
		
		lbPass = new JLabel("��й�ȣ"); 		
		lbPass.setSize(60, 20);		
		lbPass.setHorizontalAlignment(JLabel.CENTER);		
		textPass = new JPasswordField(20);
		textPass.setSize(80, 20);
				
		lbNum1 = new JLabel("�ֹι�ȣ1");			
		lbNum1.setHorizontalAlignment(JLabel.CENTER);				
		textNum1 = new JTextField(20); 			
		lbNum2 = new JLabel("�ֹι�ȣ2");			
		lbNum2.setHorizontalAlignment(JLabel.CENTER);				
		textNum2 = new JTextField(20); 
					
		lbPhone = new JLabel("��ȭ��ȣ");			
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
			
		nextButton = new JButton("���� ȸ��"); 
		nextButton.addActionListener(this); 		
		JPanel panel = new JPanel();
		panel.setSize(50,50); // ��ư ũ��
		panel.add(nextButton);
		c.add(panel,BorderLayout.SOUTH);
		
		setSize(400, 400); 
		setVisible(true); // �������� ȭ�鿡 ��Ÿ������ ����
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) { // ����
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
				textName.setText("����Ÿ ����");
				textPass.setText("");
				textNum1.setText("");
				textNum2.setText("");
				textPhone.setText("");
			} else {					
				
				textName.setText(viewRS.getString("name")); // ���� �̸��� textLabel�� ���
				textPass.setText(viewRS.getString("pass")); // ���� �̸��� textLabel�� ���
				textNum1.setText(viewRS.getString("Num1")); // ���� �̸��� textLabel�� ���
				textNum2.setText(viewRS.getString("Num2")); // ���� �̸��� textLabel�� ���
				textPhone.setText(viewRS.getString("Phone")); // ���� �̸��� textLabel�� ���
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
			viewRS = pstmt.executeQuery(); // DB���� ��� ������ ����
			if (viewRS.next()) { // ù��° ���� ǥ��		

				textName.setText(viewRS.getString("name")); // ���� �̸��� textLabel�� ���
				textPass.setText(viewRS.getString("pass")); // ���� �̸��� textLabel�� ���
				textNum1.setText(viewRS.getString("Num1")); // ���� �̸��� textLabel�� ���
				textNum2.setText(viewRS.getString("Num2")); // ���� �̸��� textLabel�� ���
				textPhone.setText(viewRS.getString("Phone")); // ���� �̸��� textLabel�� ���
			} else { 				
				textName.setText("����Ÿ ����");
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
			viewRS = pstmt.executeQuery(); // DB���� ��� ������ ����
			if (viewRS.next()) { 
				textName.setText(viewRS.getString("name")); // ���� �̸��� textLabel�� ���
				textPass.setText(viewRS.getString("pass")); // ���� �̸��� textLabel�� ���
				textNum1.setText(viewRS.getString("Num1")); // ���� �̸��� textLabel�� ���
				textNum2.setText(viewRS.getString("Num2")); // ���� �̸��� textLabel�� ���
				textPhone.setText(viewRS.getString("Phone")); // ���� �̸��� textLabel�� ���
			} else { 				
				textName.setText("����Ÿ ����");
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
            
            pre.executeUpdate(); // DB�� ���� ����
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