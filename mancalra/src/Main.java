import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame{
	public Main main = null;
	public Menu menu;
	public Mode mode;
	public Single_use single_use = null;
	public Double_use double_use = null;
	public GameBoard GameBoard = null;
	private JButton Start;
	private JButton Way;
//	private CardLayout cards = new CardLayout();
	
	
	public Main(){
		setLayout(null);
		Start = new JButton("게임 시작");
		Start.setBounds(100, 100, 100, 50);
		
		add(Start);
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Firstchange("게임 시작");
			}
		});
		
		Way = new JButton("게임 방법");
		Way.setBounds(100, 300, 100, 50);
		
		add(Way);
		Way.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Firstchange("게임 방법");
			}
		});
		System.out.println("Firstchange 완료");
		
//		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(150, 100);
		setSize(1500, 800);
		setVisible(true);
	}
	
	public void Firstchange(String panelName) {
		if (panelName.equals("게임 시작")) {
			getContentPane().removeAll();
			getContentPane().add(mode);
			revalidate();
			repaint();
			System.out.println("---게임 시작---");
		}else if(panelName.equals("게임 방법")) {
			getContentPane().removeAll();
			getContentPane().add(menu);
			revalidate();
			repaint();
			System.out.println("---게임 방법---");
		}
		
//		cards.next(this.getContentPane());
	}
	public void Secondchange(String panelName) {
		if (panelName.equals("1인용")) {
			getContentPane().removeAll();
			getContentPane().add(single_use);
			revalidate();
			repaint();
			System.out.println("---1인용---");
		}else if(panelName.equals("2인용")) {
			getContentPane().removeAll();
			getContentPane().add(double_use);
			revalidate();
			repaint();
			System.out.println("---2인용---");
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

//		GameBoard gb = new GameBoard();
		
		
		Main main = new Main();
		
		main.menu = new Menu(main);
		main.mode = new Mode(main);
		main.single_use = new Single_use(main);
		main.double_use = new Double_use(main);
		

//		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		main.setLocation(650, 200);
//		main.setSize(1900, 900);
//		main.setVisible(true);
		

	}// main
	
	public static boolean No_ball_Endgame(int[] p, int i, int com_sum, int start, int end) {
		int sum = 0;
		for (i = start; i < end; i++) {
			com_sum += p[i];
			if (i < end-1)
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
