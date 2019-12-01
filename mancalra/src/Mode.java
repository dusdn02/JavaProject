import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//1�ο� 2�ο� �����ϴ� �г�
public class Mode extends JFrame{
	private JButton Single_b;
	private JButton Double_b;
	ImageIcon backm;
	
	Mode(Main m){
		setTitle("MANCALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(250, 130);
		setSize(1005, 680);
		backm = new ImageIcon("src/images/mainBack.jpg");
		JLabel back = new JLabel(backm);
		
		System.out.println("mode ����");
		setLayout(null);
		
		back.setSize(1000, 626);
		add(back);
		
		Single_b = new JButton("1�ο�");
		Single_b.setFont(m.f);
		Single_b.setBounds(300, 400, 150, 100);
		
		Single_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.SecondChange("one");
			}
		});
		
		Double_b = new JButton("2�ο�");
		Double_b.setFont(m.f);
		Double_b.setBounds(500, 400, 150, 100);
	
		Double_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.SecondChange("two");
			}
		});
		
		back.add(Single_b);
		back.add(Double_b);
		System.out.println("Mode �Ϸ�");
	}
	
}
