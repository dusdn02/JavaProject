import javax.swing.*;
import java.awt.*;

public class GraphicsFillEx extends JFrame {
	private MyPanel panel = new MyPanel();
	public GraphicsFillEx() {
		setTitle("fillXXX 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(100, 350);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10,10,50,50);
			g.setColor(Color.BLUE);
			g.fillOval(10,70,50,50);
			g.setColor(Color.GREEN);
			g.fillRoundRect(10,130,50,50,20,20);
			
			g.setColor(Color.RED);
			g.fillArc(10,190,50,50,90,51); 
			g.setColor(Color.ORANGE);
			g.fillArc(10,190,50,50,141,52); 
			g.setColor(Color.YELLOW);
			g.fillArc(10,190,50,50,193,51); 
			g.setColor(Color.GREEN);
			g.fillArc(10,190,50,50,244,52); 
			g.setColor(Color.BLUE);
			g.fillArc(10,190,50,50,296,51); 
			g.setColor(Color.CYAN);
			g.fillArc(10,190,50,50,347,52); 
			g.setColor(Color.MAGENTA);
			g.fillArc(10,190,50,50,90,52); 
			
			g.setColor(Color.ORANGE);
			int [] x ={30,10,30,60};
			int [] y ={250,275,300,275};
			g.fillPolygon(x, y, 4); 
		}
	}	
	public static void main(String [] args) {
		new GraphicsFillEx();
	}
}
