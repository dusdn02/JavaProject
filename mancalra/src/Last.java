import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Last extends JFrame {
	JButton restart;
	JButton exit;
	JLabel whowin;
	ImageIcon backm;
	int n1,n2;

	Last(Main m) {
		setTitle("MANCALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(250, 130);
		setSize(1005, 680);
		backm = new ImageIcon("src/images/mainBack.jpg");
		JLabel back = new JLabel(backm);
		
		setLayout(null);
		
		back.setSize(1000, 626);
		add(back);
		
		restart = new JButton("다시하기");
		exit = new JButton("그만하기");
		whowin = new JLabel();
		
		if(m.single_use.p[6]>m.single_use.p[13])
			n1=1;
		else if(m.single_use.p[6]<m.single_use.p[13])
			n1=2;
		else if(m.double_use.p[6]>m.double_use.p[13])
			n1=3;
		else if(m.double_use.p[6]<m.double_use.p[13])
			n1=4;
//		else
//			n1=0;
		
		switch(n1) {
		case 1:
			whowin.setText("WIN");
			break;
		case 2:
			whowin.setText("LOSE");
			break;
		case 3:
			whowin.setText("Player1 WIN");
			break;
		case 4:
			whowin.setText("Player2 WIN");
			break;
		case 0:
			whowin.setText("동점입니다~");
			break;
		}
		
		whowin.setFont(new Font("돋음",Font.BOLD, 30));
		whowin.setBounds(200, 20, 500, 300);
	
		restart.setBounds(300, 400, 150, 100);
		restart.setFont(m.f);
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.LastChange("restart");
			}
		});
	
		exit.setBounds(500, 400, 150, 100);
		exit.setFont(m.f);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.LastChange("end");
			}
		});
	
		back.add(restart);
		back.add(exit);
		back.add(whowin);
	
	}
}
