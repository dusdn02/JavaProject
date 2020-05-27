

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Write extends JPanel{
	
	private JButton save;
	private JButton back;
	private JTextField yearT;
	private JTextField monthT;
	private JTextField dayT;
	private JTextField weatherT;
	private JTextField titleT;
	private JTextArea contentT;
	private Dairy dairy;
	
	
	public Write(Vector<String> year, Vector<String> month, Vector<String> day, Vector<String> weather, 
			Vector<String> title, Vector<String> content, Dairy dairy) {//,int i 
		this.dairy = dairy;
		setLayout(null);
		
		int i = dairy.list.choiceList();
		
		String y =((String)year.get(i));
		String m =((String)month.get(i));
		String d =((String)day.get(i));
		String w =((String)weather.get(i));
		String t =((String)title.get(i));
		String c =((String)content.get(i));
		
		yearT = new JTextField(y);//i가 4임
		yearT.setHorizontalAlignment(JTextField.CENTER);
		yearT.setFont(new Font("", Font.PLAIN, 20));
		yearT.setBounds(55, 10, 90, 30);
	
		monthT = new JTextField(m);
		monthT.setHorizontalAlignment(JTextField.CENTER);
		monthT.setFont(new Font("", Font.PLAIN, 20));
		monthT.setBounds(150, 10, 60, 30);
		
		dayT = new JTextField(d);
		dayT.setHorizontalAlignment(JTextField.CENTER);
		dayT.setFont(new Font("", Font.PLAIN, 20));
		dayT.setBounds(215, 10, 60, 30);
		
		weatherT = new JTextField(w);
		weatherT.setHorizontalAlignment(JTextField.CENTER);
		weatherT.setFont(new Font("", Font.PLAIN, 20));
		weatherT.setBounds(305, 10, 120, 30);
		
		titleT = new JTextField(t);
		titleT.setFont(new Font("", Font.PLAIN, 20));
		titleT.setBounds(40, 70, 400, 30);
		
		contentT = new JTextArea(c);
		contentT.setLineWrap(true);
		contentT.setFont(new Font("", Font.PLAIN, 20));
		contentT.setBounds(40, 110, 400, 440);
		
		save = new JButton("저장");
		save.setBounds(40, 570, 180, 30);
		back = new JButton("뒤로가기");
		back.setBounds(260, 570, 180, 30);
		
		
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
		
		System.out.println("WriteM 확인");
		
	}
	
	
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
		
		System.out.println("WriteS 확인");
		
	}
	class SavingActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				//db에 저장
			String year = yearT.getText();
//			System.out.println(year);
		    String month = monthT.getText();
		    String day = dayT.getText();
		    String weather = weatherT.getText();
		    String title = titleT.getText();
		    String content = contentT.getText();
			dairy.insertMember(year, month, day, weather ,title, content); 
//			dairy.list = new Lists(year, month, day, dairy);
			System.out.println("저장?");
			dairy.change("저장");	
			
		}
	}
	class BackActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				dairy.change("뒤로가기");
			
		}
	}
}
