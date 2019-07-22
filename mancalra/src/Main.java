
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		JFrame frame = new JFrame("MANCALA");
		JPanel menu = new JPanel();
		JPanel game = new JPanel();
		frame.setPreferredSize(new Dimension(1900, 900));

		ImageIcon board = new ImageIcon("src/GameBoard/ngb.jpg");
		JLabel imageLabel = new JLabel(board);// ���Ӻ���

		JButton Single_use = new JButton("1�ο�");
		JButton Double_use = new JButton("2�ο�");
		
		
		CardLayout Screen_Change = new CardLayout();
		
//		menu.setLayout(null);
//		
//		menu.add(Single_use);
//		menu.add(Double_use);
//		frame.add(menu);
		//�޴� ���
		
		//���� ��� ������

		JButton[] ball = new JButton[13];// ���۵�
		for (int i = 0; i < 13; i++) {
			if (i == 6)
				continue;
			ball[i] = new JButton();
		}//������ �ִ� �׾Ƹ��� ����
		
		game.setLayout(null);
		ball[0].setBounds(380, 338, 90, 40);
		game.add(ball[0]);
		ball[1].setBounds(590, 338, 90, 40);
		game.add(ball[1]);
		ball[2].setBounds(798, 338, 90, 40);
		game.add(ball[2]);
		ball[3].setBounds(1020, 338, 90, 40);
		game.add(ball[3]);
		ball[4].setBounds(1230, 338, 90, 40);
		game.add(ball[4]);
		ball[5].setBounds(1441, 338, 90, 40);
		game.add(ball[5]);
		ball[7].setBounds(385, 813, 90, 40);
		game.add(ball[7]);
		ball[8].setBounds(595, 813, 90, 40);
		game.add(ball[8]);
		ball[9].setBounds(794, 813, 90, 40);
		game.add(ball[9]);
		ball[10].setBounds(1025, 813, 90, 40);
		game.add(ball[10]);
		ball[11].setBounds(1235, 813, 90, 40);
		game.add(ball[11]);
		ball[12].setBounds(1452, 813, 90, 40);
		game.add(ball[12]);
		imageLabel.setBounds(0, 200, 1910, 800);
		game.add(imageLabel);

		frame.add(game);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		int[] p = { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
		int turn = 0;// ����
		int tmp = 0;// �ű� ����
		int com_sum = 0;
		int user_sum = 0;
		int n = 0;

		System.out.println("-----------�޴�-----------");
		System.out.println("1. 1�ο� ���");
		System.out.println("2. 2�ο� ���");
		System.out.println("-------------------------");
		int mode = sc.nextInt();

		// 1�ο�
		if (mode == 1) {
			System.out.println("1�ο� �Դϴ�.");
			while (true) {
				n = Print_Game(p, n);
				int choice;
				if (turn % 2 == 0) {// �� ����
					int i;
					System.out.println("������");
					while (true) {
						choice = sc.nextInt() - 1;
						if (Check_position(p, choice) == true)
							break;
						else
							continue;
					}

					tmp = p[choice];
					p[choice] = 0;
					i = Insert_ball(p, tmp, choice, 13);
					if ((i + choice) == 7) {
						turn--;
						continue;
					}
					Get_ball(p, choice, i, 6);

					if(No_ball_Endgame(p, i, com_sum, 0, 7)== true)
						break;
				} else {// ��ǻ�� ����
					int i = 1;
					System.out.println("��ǻ�� ����");
					while (true) {
						choice = random.nextInt(6) + 7;
						if (p[choice] != 0)
							break;
					}
//					System.out.println("	*" + choice);
					tmp = p[choice];
					p[choice] = 0;
					i = Insert_ball(p, tmp, choice, 6);
					if ((i + choice) == 14) {
						turn--;
						continue;
					} // �ڱ� �׾Ƹ��� ������ ���� ������ �ѹ���
					Get_ball(p, choice, i, 13);

					if(No_ball_Endgame(p, i, com_sum, 7, 13)== true)
						break;
					// �ڽ��� ���� �׾Ƹ��� ���� ������ ����
				}

				turn++;
			}
			System.out.println("��������");
			if (user_sum > com_sum)
				System.out.println("Win~~!!!");
			else
				System.out.println("Lose...TT");

		} else if (mode == 2) {// 2�ο�
			System.out.println("2�ο� �Դϴ�!");
			System.out.println("ù ��°�� �� �÷��̾��� �г����� �����ּ���");
			String user1 = sc.next();
			System.out.println("�� ��°�� �� �÷��̾��� �г����� �����ּ���");
			String user2 = sc.next();
			while (true) {
				n = Print_Game(p, n);
				int choice;

				if (turn % 2 == 0) {// 1 ����
					int i;
					System.out.println(user1 + " ����");
					while (true) {
						choice = sc.nextInt() - 1;
						if (Check_position(p, choice) == true)
							break;
						else
							continue;
					}
					tmp = p[choice];
					p[choice] = 0;
					i = Insert_ball(p, tmp, choice, 13);
					Get_ball(p, choice, i, 6);
					if ((i + choice) == 7) {
						turn--;
					}
					if(No_ball_Endgame(p, i, com_sum, 0, 7)== true)
						break;

				} else {
					int i;
					System.out.println(user2 + " ����");
					while (true) {
						choice = sc.nextInt() - 1;
						choice = 12 - choice;
						if (p[choice] != 0 && choice > 6 && choice < 13) {
							break;
						} else {
							System.out.println("�� ���� ���� �����ϴ�..!! �ٽ��Է��ϼ���!!");
							continue;
						}
					}
					tmp = p[choice];
					p[choice] = 0;
					i = Insert_ball(p, tmp, choice, 6);

					Get_ball(p, choice, i, 13);
					if ((i + choice) == 14) {
						turn--;
					} // �ڱ� �׾Ƹ��� ������ ���� ������ �ѹ���
					if(No_ball_Endgame(p, i, com_sum, 7, 13)== true)
						break; // �ڽ��� ���� �׾Ƹ��� ���� ������ ����
				}
				turn++;
			} // while
			if (user_sum > com_sum)
				System.out.println(user1 + " Win~~!!!");
			else
				System.out.println(user2 + " Win~~!!!");
		}
		


	}// main
	
	private static boolean No_ball_Endgame(int[] p, int i, int com_sum, int start, int end) {
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

	private static void Get_ball(int[] p, int choice, int i, int n) {
		if (p[i + choice - 1] == 1 && p[12 - (i + choice - 1)] != 0) {// && (i + choice - 1) < n
			int steal_ball = 0;
			steal_ball = p[i + choice - 1] + p[12 - (i + choice - 1)];
			p[i + choice - 1] = 0;
			p[12 - (i + choice - 1)] = 0;
			p[n] += steal_ball;
		}
	}

	private static boolean Check_position(int[] p, int choice) {
		if (p[choice] != 0 && choice < 6 && choice > -1) {
			return true;
		} else {
			System.out.println("�� ���� ���� �����ϴ�..!! �ٽ��Է��ϼ���!!");
			return false;
		}
	}

	private static int Print_Game(int[] p, int n) {
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

	private static int Insert_ball(int[] p, int tmp, int choice, int n) {
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
