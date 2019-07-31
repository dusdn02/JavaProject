package _0729;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoneyChangerFrame extends JFrame {
	int [] moneyI = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	String [] moneyT = {"������", "����", "õ��", "500��", "100��", "50��", "10��", "1��"};
	JTextField [] tf = new JTextField [8];
	Container contentPane;
	
	public MoneyChangerFrame() {
		setTitle("Money Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane=getContentPane();
		
		contentPane.setBackground(Color.PINK);
		contentPane.setLayout(null);
		
		JLabel la = new JLabel("�ݾ�");
		la.setHorizontalAlignment(JLabel.RIGHT);
		la.setSize(50, 20);
		la.setLocation(60, 70);
		contentPane.add(la);
				
		JTextField source = new JTextField(30);
		source.setSize(100, 20);
		source.setLocation(140, 70);
		contentPane.add(source);
					
		JButton cb = new JButton("���");
		cb.setSize(70, 20);
		cb.setLocation(250, 70);
		contentPane.add(cb);
			
		for(int i=0; i<moneyT.length; i++) {
			la = new JLabel(moneyT[i]);
			la.setHorizontalAlignment(JLabel.RIGHT);
			la.setSize(50, 20);
			la.setLocation(90, 100+i*20);
			contentPane.add(la);
			
			tf[i] = new JTextField(30);
			tf[i].setHorizontalAlignment(JTextField.CENTER);
			tf[i].setSize(70, 20);
			tf[i].setLocation(160, 100+i*20);
			contentPane.add(tf[i]);
		}
		
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = source.getText();
				
				if(m.length() == 0) return;
				
				int money = Integer.parseInt(m);
				for(int i=0; i<moneyI.length; i++) {
					int res = money/moneyI[i];
					tf[i].setText(Integer.toString(res));
					if(res > 0) 
						money = money%moneyI[i];
				}
			}
		});
	
		
		setSize(400,400);
		setLocation(800,300);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new MoneyChangerFrame();
	}
}