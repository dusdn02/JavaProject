import java.awt.*;
import javax.swing.*;

public class FrameTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("â");
		JLabel label = new JLabel("���̺�");
		frame.add(label);			
		frame.setPreferredSize(new Dimension(400,100));
		frame.setLocation(200, 500);
		frame.pack();//(�ݵ�� �ʿ���)
		frame.setVisible(true);//���� ���̰�(�ݵ�� �ʿ���)
		
		
		JFrame frame2 = new JFrame("â��");
		frame2.pack();
		frame2.setVisible(true);
	}

}
