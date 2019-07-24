package _0722;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RadioButtonItemEventEx extends JFrame{
	JRadioButton [] radio = new JRadioButton [3];
	String [] text = {"사과", "배", "체리"};
	JLabel label = new JLabel();
	Container contentPane;
	public RadioButtonItemEventEx() {
		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel radioPanel = new JPanel(); 
		radioPanel.setBackground(Color.GRAY);
		ButtonGroup group = new ButtonGroup(); 

		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			group.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}
		radio[2].setSelected(true); 
		contentPane.add(radioPanel, BorderLayout.NORTH); 
		contentPane.add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER); //setHorizontalAlignment가 가로정렬
		setSize(250,200);
		setVisible(true);
	}
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return; 
			if(radio[0].isSelected())
				label.setText(text[0]);
			else if(radio[1].isSelected())
				label.setText(text[1]);
			else
				label.setText(text[2]);
		}
	}
	
	public static void main(String [] args) {
		new RadioButtonItemEventEx();
	}
}
