import java.awt.*;
import javax.swing.*;

public class RadioButtonEx extends JFrame {
	Container contentPane;
	public RadioButtonEx() {
		setTitle("������ư ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup();
		JRadioButton apple = new JRadioButton("���");
		JRadioButton pear = new JRadioButton("��", true);
		JRadioButton cherry = new JRadioButton("ü��");

		g.add(apple);
		g.add(pear);
		g.add(cherry);

		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);
		
		setSize(250,150);
		setVisible(true);
	}
	public static void main(String [] args) {
		new RadioButtonEx();
	}
}
