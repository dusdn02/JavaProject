import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class End extends JFrame{
	JButton restart;
	JButton exit;
	ImageIcon backm;
	
	End(Main m){
		setTitle("MANCALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(250, 130);
		setSize(1005, 680);
		restart = new JButton("다시하기");
		exit = new JButton("그만하기");
		
		backm = new ImageIcon("src/images/mainBack.jpg");
		JLabel back = new JLabel(backm);
		
		setLayout(null);
		
		back.setSize(1000, 626);
		add(back);
		
		restart.setBounds(300, 400, 150, 100);
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.LastChange("restart");
			}
		});
		
		exit.setBounds(500, 400, 150, 100);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.LastChange("end");
			}
		});
		
		add(restart);
		add(exit);
		
	}
	
	public static void main(String[] args) {
		new End(null);
	}

}
