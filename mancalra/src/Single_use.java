import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Single_use extends JFrame {
	private MyPanel panel = new MyPanel();
	Random random = new Random();
	int[] p = new int[] { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
	int turn = 0;// 순서
	int tmp = 0;// 옮길 구슬
	int com_sum = 0;
	int user_sum = 0;
	int n = 0;
	int choice;
	int check;
	int k;
	int who=0;
	int color;
	JLabel mine;
	JLabel com;
	JLabel m1;
	JLabel m2;
	JLabel m3;
	JLabel m4;
	JLabel m5;
	JLabel m6;
	JLabel c1;
	JLabel c2;
	JLabel c3;
	JLabel c4;
	JLabel c5;
	JLabel c6;
	JLabel turn_label;

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Color c = Color.BLACK;
			g.setColor(c);
			g.drawOval(190, 200, 170, 170);
			g.setColor(c);
			g.drawOval(370, 200, 170, 170);
			g.setColor(c);
			g.drawOval(550, 200, 170, 170);
			g.setColor(c);
			g.drawOval(730, 200, 170, 170);
			g.setColor(c);
			g.drawOval(910, 200, 170, 170);
			g.setColor(c);
			g.drawOval(1090, 200, 170, 170);

			g.setColor(c);
			g.drawRoundRect(10, 200, 170, 370, 50, 50);

			g.setColor(c);
			g.drawOval(190, 400, 170, 170);
			g.setColor(c);
			g.drawOval(370, 400, 170, 170);
			g.setColor(c);
			g.drawOval(550, 400, 170, 170);
			g.setColor(c);
			g.drawOval(730, 400, 170, 170);
			g.setColor(c);
			g.drawOval(910, 400, 170, 170);
			g.setColor(c);
			g.drawOval(1090, 400, 170, 170);

			g.setColor(c);
			g.drawRoundRect(1270, 200, 170, 370, 50, 50);

		}
	}

	Single_use(Main m) {
		setTitle("1인용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLocation(150, 100);
		setSize(1480, 800);

		m1 = new JLabel(Integer.toString(p[0]));
		m2 = new JLabel(Integer.toString(p[1]));
		m3 = new JLabel(Integer.toString(p[2]));
		m4 = new JLabel(Integer.toString(p[3]));
		m5 = new JLabel(Integer.toString(p[4]));
		m6 = new JLabel(Integer.toString(p[5]));

		c1 = new JLabel(Integer.toString(p[7]));
		c2 = new JLabel(Integer.toString(p[8]));
		c3 = new JLabel(Integer.toString(p[9]));
		c4 = new JLabel(Integer.toString(p[10]));
		c5 = new JLabel(Integer.toString(p[11]));
		c6 = new JLabel(Integer.toString(p[12]));

		mine = new JLabel(Integer.toString(p[6]));
		com = new JLabel(Integer.toString(p[13]));

		m1.setFont(m.f);
		m2.setFont(m.f);
		m3.setFont(m.f);
		m4.setFont(m.f);
		m5.setFont(m.f);
		m6.setFont(m.f);
		c1.setFont(m.f);
		c2.setFont(m.f);
		c3.setFont(m.f);
		c4.setFont(m.f);
		c5.setFont(m.f);
		c6.setFont(m.f);
		mine.setFont(m.f);
		com.setFont(m.f);

		setLayout(null);
		c6.setBounds(275, 285, 40, 20);
		add(c6);
		c5.setBounds(455, 285, 40, 20);
		add(c5);
		c4.setBounds(635, 285, 40, 20);
		add(c4);
		c3.setBounds(815, 285, 40, 20);
		add(c3);
		c2.setBounds(995, 285, 40, 20);
		add(c2);
		c1.setBounds(1175, 285, 40, 20);
		add(c1);

		com.setBounds(90, 385, 40, 20);
		add(com);

		m1.setBounds(275, 485, 40, 20);
		add(m1);
		m2.setBounds(455, 485, 40, 20);
		add(m2);
		m3.setBounds(635, 485, 40, 20);
		add(m3);
		m4.setBounds(815, 485, 40, 20);
		add(m4);
		m5.setBounds(995, 485, 40, 20);
		add(m5);
		m6.setBounds(1175, 485, 40, 20);
		add(m6);

		mine.setBounds(1350, 385, 40, 20);
		add(mine);

		turn_label = new JLabel("내차례");
		turn_label.setBounds(1100, 150, 200, 40);
		turn_label.setFont(new Font("돋음", Font.BOLD, 20));
		add(turn_label);

		System.out.println("1인용 입니다.");

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
//				System.out.println("x:"+x+"  y:"+y);
				choice = -1;
				color = 0;

				if (y >= 400 && y <= 570) {
					if (x >= 190 && x <= 360) {
						// m1
						System.out.println("m1");
						choice = 0;
					} else if (x >= 370 && x <= 540) {
						// m2
						System.out.println("m2");
						choice = 1;
					} else if (x >= 550 && x <= 720) {
						// m3
						System.out.println("m3");
						choice = 2;
					} else if (x >= 730 && x <= 900) {
						// m4
						System.out.println("m4");
						choice = 3;
					} else if (x >= 910 && x <= 1080) {
						// m5
						System.out.println("m5");
						choice = 4;
					} else if (x >= 1090 && x <= 1260) {
						// m6
						System.out.println("m6");
						choice = 5;
					}
				}

				if (turn % 2 == 0) {// 내 차례
					if (Main.No_ball_Endgame(p, com_sum, 0, 7) == true) {
						who = 1;
						m.ThirdChange("1");
					}
					int i;
					System.out.println("내차례");
					color = 1;

					tmp = p[choice];
					p[choice] = 0;
					i = Main.Insert_ball(p, tmp, choice, 13);
					if ((i + choice) == 7) {
						turn--;
					}
					Main.Get_ball(p, choice, i, 6);
					repaint();
				} else {// 컴퓨터 차례
					if (Main.No_ball_Endgame(p, com_sum, 7, 13) == true) {
						who = 2;
						m.ThirdChange("1");
					}
					int i = 1;
					System.out.println("컴퓨터 차례");
					color = 2;
					while (true) {
						choice = random.nextInt(6) + 7;
						if (p[choice] != 0)
							break;
					}
					tmp = p[choice];
					p[choice] = 0;
					i = Main.Insert_ball(p, tmp, choice, 6);
					if ((i + choice) == 14) {
						turn--;
					} // 자기 항아리에 마지막 공이 들어오면 한번더
					Main.Get_ball(p, choice, i, 13);
					
					repaint();

				}

				if (turn % 2 == 0) {
					turn_label.setText("컴퓨터 차례");
					add(turn_label);
					repaint();
				} else {
					turn_label.setText("내차례");
					add(turn_label);
					repaint();
				}

				m1.setText(Integer.toString(p[0]));
				m2.setText(Integer.toString(p[1]));
				m3.setText(Integer.toString(p[2]));
				m4.setText(Integer.toString(p[3]));
				m5.setText(Integer.toString(p[4]));
				m6.setText(Integer.toString(p[5]));

				mine.setText(Integer.toString(p[6]));

				c1.setText(Integer.toString(p[7]));
				c2.setText(Integer.toString(p[8]));
				c3.setText(Integer.toString(p[9]));
				c4.setText(Integer.toString(p[10]));
				c5.setText(Integer.toString(p[11]));
				c6.setText(Integer.toString(p[12]));

				com.setText(Integer.toString(p[13]));

				repaint();
				turn++;

			}
		});
	}
}
