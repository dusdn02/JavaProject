
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;



public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		GameBoard gb = new GameBoard();


		JButton Single_use = new JButton("1인용");
		JButton Double_use = new JButton("2인용");
		
		
		CardLayout Screen_Change = new CardLayout();
		
//		menu.setLayout(null);
//		
//		menu.add(Single_use);
//		menu.add(Double_use);
//		frame.add(menu);
		//메뉴 페널
		
		//게임 방법 프레임


	
		int[] p = { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
		int turn = 0;// 순서
		int tmp = 0;// 옮길 구슬
		int com_sum = 0;
		int user_sum = 0;
		int n = 0;

		System.out.println("-----------메뉴-----------");
		System.out.println("1. 1인용 모드");
		System.out.println("2. 2인용 모드");
		System.out.println("-------------------------");
		int mode = sc.nextInt();

		// 1인용
		if (mode == 1) {
			System.out.println("1인용 입니다.");
			while (true) {
				n = Print_Game(p, n);
				int choice;
				if (turn % 2 == 0) {// 내 차례
					int i;
					System.out.println("내차례");
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
				} else {// 컴퓨터 차례
					int i = 1;
					System.out.println("컴퓨터 차례");
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
					} // 자기 항아리에 마지막 공이 들어오면 한번더
					Get_ball(p, choice, i, 13);

					if(No_ball_Endgame(p, i, com_sum, 7, 13)== true)
						break;
					// 자신쪽 작은 항아리에 공이 없으면 종료
				}

				turn++;
			}
			System.out.println("게임종료");
			if (user_sum > com_sum)
				System.out.println("Win~~!!!");
			else
				System.out.println("Lose...TT");

		} else if (mode == 2) {// 2인용
			System.out.println("2인용 입니다!");
			System.out.println("첫 번째로 할 플레이어의 닉네임을 적어주세요");
			String user1 = sc.next();
			System.out.println("두 번째로 할 플레이어의 닉네임을 적어주세요");
			String user2 = sc.next();
			while (true) {
				n = Print_Game(p, n);
				int choice;

				if (turn % 2 == 0) {// 1 차례
					int i;
					System.out.println(user1 + " 차례");
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
					System.out.println(user2 + " 차례");
					while (true) {
						choice = sc.nextInt() - 1;
						choice = 12 - choice;
						if (p[choice] != 0 && choice > 6 && choice < 13) {
							break;
						} else {
							System.out.println("그 곳엔 공이 없습니다..!! 다시입력하세요!!");
							continue;
						}
					}
					tmp = p[choice];
					p[choice] = 0;
					i = Insert_ball(p, tmp, choice, 6);

					Get_ball(p, choice, i, 13);
					if ((i + choice) == 14) {
						turn--;
					} // 자기 항아리에 마지막 공이 들어오면 한번더
					if(No_ball_Endgame(p, i, com_sum, 7, 13)== true)
						break; // 자신쪽 작은 항아리에 공이 없으면 종료
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
			System.out.println("그 곳엔 공이 없습니다..!! 다시입력하세요!!");
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
