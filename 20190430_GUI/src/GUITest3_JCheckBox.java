import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUITest3_JCheckBox {

	public static void main(String[] args) {
		JFrame frame = new JFrame("â�̸�");
		frame.setLocation(1200, 700);
		frame.setPreferredSize(new Dimension(300,200));
		
		JPanel panel = new JPanel();//���۷�Ʈ�� ������ ���� �� �ֵ��� ��
		JCheckBox cbChicken = new JCheckBox("ġŲ");
		JCheckBox cbPizza = new JCheckBox("����");
		
		panel.add(cbChicken);
		panel.add(cbPizza);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
