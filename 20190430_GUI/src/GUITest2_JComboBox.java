import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUITest2_JComboBox {

	public static void main(String[] args) {
		JFrame frame = new JFrame("â�̸�");
		frame.setLocation(1200, 700);
		frame.setPreferredSize(new Dimension(300,200));
		
		JPanel panel = new JPanel();//���۷�Ʈ�� ������ ���� �� �ֵ��� ��
		
//		String[] picnics = {"�Ҳɱ���","��������"};
//		JComboBox<String> cb = new JComboBox<>(picnics);
//		cb.addItem("����ķ��");
//		cb.addItem("�ܿﴫ�ο�");
//		panel.add(cb);
		
		JLabel label = new JLabel("month:");
		String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		JComboBox<String> cb = new JComboBox<>(month);
		panel.add(label);
		panel.add(cb);
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
