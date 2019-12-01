import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//1인용 2인용 선택하는 패널
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
		
		System.out.println("mode 시작");
		setLayout(null);
		
		back.setSize(1000, 626);
		add(back);
		
		Single_b = new JButton("1인용");
		Single_b.setFont(m.f);
		Single_b.setBounds(300, 400, 150, 100);
		
		Single_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.SecondChange("one");
			}
		});
		
		Double_b = new JButton("2인용");
		Double_b.setFont(m.f);
		Double_b.setBounds(500, 400, 150, 100);
	
		Double_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.SecondChange("two");
			}
		});
		
		back.add(Single_b);
		back.add(Double_b);
		System.out.println("Mode 완료");
	}
	
}
