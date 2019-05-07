import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUITest_JFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("창이름");
		frame.setLocation(1200, 700);
		frame.setPreferredSize(new Dimension(300,200));
//		frame.setSize(300,400);
		
		JPanel panel = new JPanel();//컨퍼런트가 여러개 나올 수 있도록 함
		JLabel label = new JLabel("오월은 푸르구나~");
		label.setText("너도나도 자란다~");
//		label.setOpaque(true);
//		label.setBackground(Color.pink);
		
		JTextField tf = new JTextField("우리들은 자란다~");
		
//		JLabel label2 = new JLabel("우리들은 자란다~");
		
		panel.add(label);
		panel.add(tf);
		frame.add(panel);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
