import java.awt.Dimension;

import javax.swing.*;

public class yaho {

	public static void main(String[] args) {
		JFrame frame = new JFrame("â�̸�");
		frame.setLocation(1200, 700);
		frame.setPreferredSize(new Dimension(300,200));
		
		JPanel panel = new JPanel();//���۷�Ʈ�� ������ ���� �� �ֵ��� ��
		JLabel label = new JLabel("ID:");
		JTextField tf = new JTextField("���̵� �Է��ϼ���");
		//Ŭ���ϸ� �ȳ����� ������
		//tf.setText("");
		
		panel.add(label);
		panel.add(tf);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
