import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//1�ο� 2�ο� �����ϴ� �г�
public class Mode extends JPanel{
	public Main main;
	private JButton Single_b;
	private JButton Double_b;
	
	Mode(test t){
//		super.setLayout(main.card);
		
		System.out.println("mode ����");
		setLayout(null);
		Single_b = new JButton("1�ο�");
		Single_b.setBounds(100, 100, 100, 50);
		
		Single_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				main.Secondchange("1�ο�");
			}
		});
		
		Double_b = new JButton("2�ο�");
		Double_b.setBounds(100, 300, 100, 50);
	
		Double_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				main.Secondchange("2�ο�");
			}
		});
		
		add(Single_b);
		add(Double_b);
		System.out.println("Mode �Ϸ�");
	}
	
}
