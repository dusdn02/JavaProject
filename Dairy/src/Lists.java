

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Lists extends JPanel {
	private JButton Additional;

	JList<String> View;
	private Dairy dairy;
	

	Lists(Dairy dairy) {//String y, String m, String d, 
		
//		this.revalidate();
//		this.repaint();
		
		
		this.dairy = dairy;
		setLayout(null);
		
		
		
		DefaultListModel<String> mo = new DefaultListModel<String>();
		Vector<String> v = new Vector<String>();
//		String date = y + "." + m + "." + d;

		
		View = new JList<String>();
		
//		for(int i=0; i<v.size(); i++) {
		dairy.Select(v, View);
//		}
		
//		if (!(y == null && m == null && d == null)) {
////			v.addElement(date);
//			mo.addElement(date);	
//
//			View.setFont(new Font("", Font.BOLD, 20));
////			View.setListData(v);
//			View.setModel(mo);
//			View.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		}
				
		View.setBounds(40, 20, 400, 500);
		View.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JScrollPane scrollPane = new JScrollPane(View);
		scrollPane.setPreferredSize(new Dimension(300, 300)); // 사이즈 설정
		add(scrollPane);
		add(View);

		Additional = new JButton("추가");
		Additional.setHorizontalAlignment(JTextField.CENTER);
		Additional.setFont(new Font("", Font.PLAIN, 20));
		Additional.setBounds(200, 580, 80, 50);

		add(Additional);

		Additional.addActionListener(new WritingActionListener());
		View.addListSelectionListener(new ListActionListener());
		System.out.println("Lists 확인");

	}

	class WritingActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dairy.change("일기 쓰기");
		}
	}

	class ListActionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			
			
			dairy.change("보기");
			
		}
	}
	public int choiceList() {
		int i = View.getSelectedIndex();
		return i;
	}
}
