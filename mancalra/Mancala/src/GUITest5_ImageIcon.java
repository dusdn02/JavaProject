import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GUITest5_ImageIcon {

	public static void main(String[] args) {
		JFrame frame = new JFrame("â�̸�");
		JPanel panel = new JPanel();
		frame.setPreferredSize(new Dimension(400,600));
		
		//ImageIcon, JLabel
		ImageIcon Gray = new ImageIcon("src/images/Gray.jpg");
		JLabel imageLabel = new JLabel(Gray);
		
		//ImageIcon, JButton
		ImageIcon B612_20190127_111308_809 = new ImageIcon("src/images/B612_20190127_111308_809.jpg");
		//JButton imageButton = new JButton(B612_20190127_111308_809);
		
		//ImageIcon ũ�� ����
		ImageIcon smallGray = new ImageIcon(B612_20190127_111308_809.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JButton imageButton = new JButton(smallGray);
		imageButton.setRolloverIcon(Gray); //���콺�� ������ ������ ��Ÿ���� �̹���
		imageButton.setPressedIcon(B612_20190127_111308_809);//Ŭ���ϸ� ���̴� �̹���
		
		
		panel.add(imageButton);
		panel.add(imageLabel);
	
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
