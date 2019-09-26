import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//1인용 2인용 선택하는 패널
public class Mode extends JPanel{
	public Main main;
	private JButton Single_b;
	private JButton Double_b;
	
	Mode(test t){
//		super.setLayout(main.card);
		
		System.out.println("mode 시작");
		setLayout(null);
		Single_b = new JButton("1인용");
		Single_b.setBounds(100, 100, 100, 50);
		
		Single_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				main.Secondchange("1인용");
			}
		});
		
		Double_b = new JButton("2인용");
		Double_b.setBounds(100, 300, 100, 50);
	
		Double_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				main.Secondchange("2인용");
			}
		});
		
		add(Single_b);
		add(Double_b);
		System.out.println("Mode 완료");
	}
	
}
