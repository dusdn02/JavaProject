
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JFrame {
//	public test t = null;
	Container contentPane;
	public Way way;
	public Mode mode = null;
	public Single_use single_use = null;
	public Double_use double_use = null;
	public GameBoard GameBoard = null;
	public Start start;
	public CardLayout card = new CardLayout();
	public JPanel cards;

	public test() {
		setTitle("MANCALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(150, 100);
		setSize(1500, 800);
		setVisible(true);
		setLayout(card);
		
//		start = new Start(this);
//		mode = new Mode(this);
//		single_use = new Single_use(this);
//		double_use = new Double_use(this);
//		way = new Way(this);
		this.add(start, "start");
		
		
		this.add(mode, "mode");
//		cards.add(single_use, "single_use");
//		cards.add(double_use, "double_use");
//		cards.add(way, "way");


//		add(cards);

		card.show(this, "start");
		

		
//		JButton j = new JButton("12345");
//		j.setBounds(100, 100, 100, 50);
//		add(j);
		
	}



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

//		GameBoard gb = new GameBoard();
		System.out.println("test 시작");
		test t = new test();
		System.out.println("test 완료");
//		t.start = new Start(t);
//		System.out.println("start 완료");
//		t.card.show(t.cards, "start");
//		t.way = new Way(t);
//		t.mode = new Mode(t);
//		t.single_use = new Single_use(t);
//		t.double_use = new Double_use(t);

//		t.add(t.start);
		
		
		

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
			System.out.println("그 곳엔 공이 없습니다..!! 다시입력하세요!!");
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
			if ((i + choice) >= 14) {// i+choice는 위치
				i -= 14;
				tmp -= 14;
			} // 공이 한바퀴 돌면 tmp를 다시 0으로
			if ((i + choice) == n)// 상대편 큰항아리에는 공을 넣지 않는다
				continue;
			else
				p[i + choice]++;// 그 이외엔 다 공을 넣는다
		}
		return i;
	}

}// class
