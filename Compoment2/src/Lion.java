import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lion extends JFrame{
	
	private MyPanel panel = new MyPanel();
	public Lion() {
		setTitle("lion ±×¸®±â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.ORANGE);
			g.fillOval(50,50,300,300); 
			
			g.setColor(Color.ORANGE);
			g.fillOval(40,40,100,100);
			
			g.setColor(Color.ORANGE);
			g.fillOval(250,40,100,100);
			
			g.setColor(Color.BLACK);
			g.fillOval(120,175,20,20);
			g.setColor(Color.BLACK);
			g.fillOval(260,175,20,20);
			
			g.setColor(Color.BLACK);
			g.fillRoundRect(95, 140, 70, 15, 20, 20);
			g.setColor(Color.BLACK);
			g.fillRoundRect(235, 140, 70, 15, 20, 20);
			
			g.setColor(Color.WHITE);
			g.fillOval(150,220,50,50);
			g.setColor(Color.WHITE);
			g.fillOval(200,220,50,50);
			
			g.setColor(Color.BLACK);
			g.fillOval(185,210,30,30);
			
		}
	}	

	public static void main(String[] args) {
		new Lion();
	}

}
