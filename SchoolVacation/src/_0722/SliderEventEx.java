package _0722;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderEventEx extends JFrame{
	JSlider [] slider = new JSlider[3];
	JLabel colorlabel = new JLabel();
	Container contentPane;
	SliderEventEx(){
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800, 400);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		colorlabel.setText("   SLIDER EXAMPLE    ");
		for(int i=0; i<slider.length; i++) { 
			slider[i] = new JSlider(JSlider.HORIZONTAL, 0, 250, 125); 
			slider[i].setPaintLabels(true); 
			slider[i].setPaintTicks(true); 
			slider[i].setPaintTrack(true);
			slider[i].setMajorTickSpacing(50); 
			slider[i].setMinorTickSpacing(10); 
			slider[i].addChangeListener(new MyChangeListener()); 
			contentPane.add(slider[i]);
		}

		slider[0].setForeground(Color.RED);
		slider[1].setForeground(Color.GREEN);
		slider[2].setForeground(Color.BLUE);
		
//		contentPane.add(slider[0]);
//		contentPane.add(slider[1]);
//		contentPane.add(slider[2]);
		colorlabel.setOpaque(true); 
		colorlabel.setBackground( 
				new Color(slider[0].getValue(),slider[1].getValue(), slider[2].getValue()));
		contentPane.add(colorlabel);
		setSize(350,300);
		setVisible(true);
	}
	class MyChangeListener implements ChangeListener { 
		public void stateChanged(ChangeEvent e) { 
			colorlabel.setBackground( 
				new Color (slider[0].getValue(),slider[1].getValue(), slider[2].getValue())); 
		}
	}
	public static void main(String[] args) {
		new SliderEventEx();
	}
}
