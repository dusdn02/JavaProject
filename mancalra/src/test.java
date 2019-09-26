
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test extends JFrame {
	public test t = null;
	Container contentPane;
	public Way way;
	public Mode mode = null;
	public Single_use single_use = null;
	public Double_use double_use = null;
	public GameBoard GameBoard = null;
	public Start start = null;
	public CardLayout card = new CardLayout();
	public JPanel cards;

	public test() {
		setTitle("MANCALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(150, 100);
		setSize(1500, 800);
		setVisible(true);
//		contentPane = getContentPane();
//		this.setLayout(card);
		setLayout(null);
		
		start = new Start(t);
		mode = new Mode(t);
		single_use = new Single_use(t);
		double_use = new Double_use(t);
		way = new Way(t);
		
//		getContentPane().setLayout(new CardLayout());
		
		cards = new JPanel(card);
	//	card = new CardLayout();
		System.out.println("*********");
		cards.add(start, "start");
		System.out.println("*********");
		cards.add(mode, "mode");
		cards.add(single_use, "single_use");
		cards.add(double_use, "double_use");
		cards.add(way, "way");

		System.out.println("asdfadgsfafgrw4wred");
//		add(cards);


		System.out.println("Firstchange �Ϸ�");
		
//		contentPane.add(jp);
		getContentPane().add(cards);
		
	}

//	public void Firstchange(String panelName) {
//		if (panelName.equals("���� ����")) {
//			getContentPane().removeAll();
//			getContentPane().add(mode);
//			revalidate();
//			repaint();
//			System.out.println("---���� ����---");
//		}else if(panelName.equals("���� ���")) {
//			getContentPane().removeAll();
//			getContentPane().add(menu);
//			revalidate();
//			repaint();
//			System.out.println("---���� ���---");
//		}
//		
////		cards.next(this.getContentPane());
//	}
//	public void Secondchange(String panelName) {
//		if (panelName.equals("1�ο�")) {
//			getContentPane().removeAll();
//			getContentPane().add(single_use);
//			revalidate();
//			repaint();
//			System.out.println("---1�ο�---");
//		}else if(panelName.equals("2�ο�")) {
//			getContentPane().removeAll();
//			getContentPane().add(double_use);
//			revalidate();
//			repaint();
//			System.out.println("---2�ο�---");
//		}
//	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

//		GameBoard gb = new GameBoard();
		System.out.println("test ����");
		test t = new test();
		System.out.println("test �Ϸ�");
		t.way = new Way(t);
		t.mode = new Mode(t);
		t.single_use = new Single_use(t);
		t.double_use = new Double_use(t);

//		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		main.setLocation(650, 200);
//		main.setSize(1900, 900);
//		main.setVisible(true);

	}// main

	public static boolean No_ball_Endgame(int[] p, int i, int com_sum, int start, int end) {
		int sum = 0;
		for (i = start; i < end; i++) {
			com_sum += p[i];
			if (i < end - 1)
				sum += p[i];
		}
		if (sum == 0)
			return true;
		else
			return false;
	}

	public static void Get_ball(int[] p, int choice, int i, int n) {
		if (p[i + choice - 1] == 1 && p[12 - (i + choice - 1)] != 0) {// && (i + choice - 1) < n
			int steal_ball = 0;
			steal_ball = p[i + choice - 1] + p[12 - (i + choice - 1)];
			p[i + choice - 1] = 0;
			p[12 - (i + choice - 1)] = 0;
			p[n] += steal_ball;
		}
	}

	public static boolean Check_position(int[] p, int choice) {
		if (p[choice] != 0 && choice < 6 && choice > -1) {
			return true;
		} else {
			System.out.println("�� ���� ���� �����ϴ�..!! �ٽ��Է��ϼ���!!");
			return false;
		}
	}

	public static int Print_Game(int[] p, int n) {
		for (int i = 12; i > 6; i--)
			System.out.print("  " + p[i] + "  ");
		System.out.println();
		System.out.println(p[13] + "                            " + p[6]);
		for (int i = 0; i < 6; i++)
			System.out.print("  " + p[i] + "  ");
		System.out.println();
		for (int i = 0; i < 14; i++)
			n += p[i];
		System.out.println("======================================================================");
		return n;
	}

	public static int Insert_ball(int[] p, int tmp, int choice, int n) {
		int i;
		for (i = 1; i <= tmp; i++) {
			if ((i + choice) >= 14) {// i+choice�� ��ġ
				i -= 14;
				tmp -= 14;
			} // ���� �ѹ��� ���� tmp�� �ٽ� 0����
			if ((i + choice) == n)// ����� ū�׾Ƹ����� ���� ���� �ʴ´�
				continue;
			else
				p[i + choice]++;// �� �̿ܿ� �� ���� �ִ´�
		}
		return i;
	}

}// class
