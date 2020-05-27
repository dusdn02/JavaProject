

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Show extends JPanel{
	private JButton Modify;
	private JButton deleteB;
	private JButton back;
	private JLabel yearL;
	private JLabel monthL;
	private JLabel dayL;
	private JLabel weatherL;
	private JLabel titleL;
	private JLabel contentL;
	private Dairy dairy;
	
	Show(Vector<String> year, Vector<String> month, Vector<String> day, Vector<String> weather, 
			Vector<String> title, Vector<String> content, Dairy dairy){//, int i
		this.dairy = dairy;
		setLayout(null);
		
		int i = dairy.list.choiceList();
		
		String y =((String)year.get(i));
		String m =((String)month.get(i));
		String d =((String)day.get(i));
		String w =((String)weather.get(i));
		String t =((String)title.get(i));
		String c =((String)content.get(i));
		
		yearL = new JLabel(y);
		yearL.setHorizontalAlignment(JTextField.CENTER);
		yearL.setFont(new Font("", Font.PLAIN, 20));//���� ũ��
		yearL.setBounds(55, 10, 90, 30);//��ġ
		
		monthL = new JLabel(m);
		monthL.setHorizontalAlignment(JTextField.CENTER);
		monthL.setFont(new Font("", Font.PLAIN, 20));
		monthL.setBounds(150, 10, 60, 30);
		
		dayL = new JLabel(d);
		dayL.setHorizontalAlignment(JTextField.CENTER);
		dayL.setFont(new Font("", Font.PLAIN, 20));
		dayL.setBounds(215, 10, 60, 30);
		
		weatherL = new JLabel(w);
		weatherL.setHorizontalAlignment(JTextField.CENTER);
		weatherL.setFont(new Font("", Font.PLAIN, 20));
		weatherL.setBounds(305, 10, 120, 30);
		
		titleL = new JLabel(t);
		titleL.setFont(new Font("", Font.PLAIN, 20));
		titleL.setBounds(40, 70, 400, 30);
		
		contentL = new JLabel(c);
		contentL.setFont(new Font("", Font.PLAIN, 20));
		contentL.setBounds(40, 110, 400, 440);
		
		Modify = new JButton("����");
		Modify.setBounds(40, 570, 120, 40);
		deleteB = new JButton("����");
		deleteB.setBounds(180, 570, 120,40);
		back = new JButton("�ڷΰ���");
		back.setBounds(320, 570, 120, 40);
		
		
		add(yearL);
		add(monthL);
		add(dayL);
		add(weatherL);
		add(titleL);
		add(contentL);
		add(Modify);
		add(deleteB);
		add(back);
		
		
		Modify.addActionListener(new ModifyActionListener());
		deleteB.addActionListener(new DeleteActionListenr());
		back.addActionListener(new BackActionListener());
		
		System.out.println("Show Ȯ��");
		
	}
	
	class ModifyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//db������Ʈ
			String year = yearL.getText();
		    String month = monthL.getText();
		    String day = dayL.getText();
		    String weather = weatherL.getText();
		    String title = titleL.getText();
		    String content = contentL.getText();
			dairy.update(year, month, day, weather ,title, content);
			System.out.println("����?");
			dairy.change("����");	
			
		}
	}
	class DeleteActionListenr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String year = yearL.getText();
		    String month = monthL.getText();
		    String day = dayL.getText();
		    String weather = weatherL.getText();
		    String title = titleL.getText();
		    String content = contentL.getText();
			dairy.delete(year, month, day, weather ,title, content);
		
			dairy.change("����");
		}
	}
	class BackActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				dairy.change("�ڷΰ���");
			
		}
		
	}
}
