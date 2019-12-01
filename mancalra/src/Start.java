import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start extends JFrame {
	private JButton Start_b;
	private JButton Way_b;
	ImageIcon backm;

	Start(Main m) {
		setTitle("MANCALA");

		backm = new ImageIcon("src/images/mainBack.jpg");
		JLabel back = new JLabel(backm);

		setLayout(null);

		back.setSize(1000, 626);
		add(back);
		Start_b = new JButton("게임 시작");
		Start_b.setFont(m.f);
		Start_b.setBounds(300, 400, 150, 100);

		Start_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.FirstChange("mode");
			}
		});

		Way_b = new JButton("게임 방법");
		Way_b.setFont(m.f);
		Way_b.setBounds(500, 400, 150, 100);

		back.add(Start_b);
		back.add(Way_b);

		Way_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.FirstChange("menu");
			}
		});

		System.out.println("스타트 버튼 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(250, 130);
		setSize(1005, 680);
		setVisible(true);
	}
}
