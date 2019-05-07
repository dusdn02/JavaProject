import java.awt.Dimension;

import javax.swing.*;

public class yaho {

	public static void main(String[] args) {
		JFrame frame = new JFrame("창이름");
		frame.setLocation(1200, 700);
		frame.setPreferredSize(new Dimension(300,200));
		
		JPanel panel = new JPanel();//컨퍼런트가 여러개 나올 수 있도록 함
		JLabel label = new JLabel("ID:");
		JTextField tf = new JTextField("아이디를 입력하세요");
		//클릭하면 안내문구 지우자
		//tf.setText("");
		
		panel.add(label);
		panel.add(tf);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
