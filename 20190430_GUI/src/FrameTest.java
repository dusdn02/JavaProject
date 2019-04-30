import java.awt.*;
import javax.swing.*;

public class FrameTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("창");
		JLabel label = new JLabel("레이블");
		frame.add(label);			
		frame.setPreferredSize(new Dimension(400,100));
		frame.setLocation(200, 500);
		frame.pack();//(반드시 필요함)
		frame.setVisible(true);//눈에 보이게(반드시 필요함)
		
		
		JFrame frame2 = new JFrame("창투");
		frame2.pack();
		frame2.setVisible(true);
	}

}
