
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public Way way;
	public Mode mode;
	public Single_use single_use;
	public Double_use double_use;
	public GameBoard GameBoard;
	public Start start;
	public End end;
	Font f = new Font("����", Font.BOLD, 20);

	public Main() {

		start = new Start(this);
		mode = new Mode(this);
		single_use = new Single_use(this);
		double_use = new Double_use(this);
		way = new Way(this);
		end = new End(this);
//		add(start, "start");

		start.setVisible(true);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

//		GameBoard gb = new GameBoard();
		System.out.println("test ����");
		Main m = new Main();
		System.out.println("test �Ϸ�");

//		m.card.show(m.main, "start");

	}// main

	public void FirstChange(String name) {
		if (name.equals("mode")) {
			start.setVisible(false);
			mode.setVisible(true);
		} else if (name.equals("menu")) {
			way.setVisible(true);
		} else
			System.out.println("fc�ȵ�");
	}

	public void SecondChange(String name) {
		mode.setVisible(false);
		if (name.equals("one")) {
			single_use.setVisible(true);
		} else if (name.equals("two")) {
			double_use.setVisible(true);
		} else
			System.out.println("sc�ȵ�");
	}

	public void ThirdChange(String name) {
		if(name.equals("1"))
			single_use.setVisible(false);
		else if(name.equals("2"))
			double_use.setVisible(false);
		end.setVisible(true);
	}

	public void LastChange(String name) {
		end.setVisible(false);
		if (name.equals("restart"))
			start.setVisible(true);

	}

	public static boolean No_ball_Endgame(int[] p, int com_sum, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += p[i];
		}
		if (sum == 0)
			return true;
		else
			return false;
	}

	public static void Get_ball(int[] p, int choice, int i, int n) {
		if (n == 6 && i + choice > n)
			return;
		else if (n == 13 && i + choice < 6)
			return;

		if (p[i + choice - 1] == 1 && p[12 - (i + choice - 1)] != 0) {// && (i + choice - 1) < n
			int steal_ball = 0;
			steal_ball = p[i + choice - 1] + p[12 - (i + choice - 1)];
			p[i + choice - 1] = 0;
			p[12 - (i + choice - 1)] = 0;
			p[n] += steal_ball;
		}
	}

	public static boolean Check_position(int[] p, int choice) {
//		System.out.println("choice:"+choice);
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
