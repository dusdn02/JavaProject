import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Calculator extends JFrame{
	
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		contentPane.add(new JButton("sin"));
		contentPane.add(new JButton("cos"));
		contentPane.add(new JButton("tan"));
		contentPane.add(new JButton("log"));
		contentPane.add(new JButton("Exp"));
		contentPane.add(new JButton("Mod"));
		contentPane.add(new JButton("CE"));
		contentPane.add(new JButton("C"));
		contentPane.add(new JButton("<x"));
		contentPane.add(new JButton("%"));
		contentPane.add(new JButton("*"));
		contentPane.add(new JButton("-"));
		contentPane.add(new JButton("+"));
		contentPane.add(new JButton("7"));
		contentPane.add(new JButton("8"));
		contentPane.add(new JButton("9"));
		contentPane.add(new JButton("4"));
		contentPane.add(new JButton("5"));
		contentPane.add(new JButton("6"));
		contentPane.add(new JButton("1"));
		contentPane.add(new JButton("2"));
		contentPane.add(new JButton("3"));
		contentPane.add(new JButton("="));
		
		
		setSize(800, 700);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
