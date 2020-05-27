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
	public Start start;
	public Last last;
	Font f = new Font("돋음", Font.BOLD, 20);

	public Main() {

		start = new Start(this);
		mode = new Mode(this);
		single_use = new Single_use(this);
		double_use = new Double_use(this);
		way = new Way(this);
		last = new Last(this);

		start.setVisible(true);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		Main m = new Main();
	}// main

	public void FirstChange(String name) {
		if (name.equals("mode")) {
			start.setVisible(false);
			mode.setVisible(true);
		} else if (name.equals("menu")) {
			way.setVisible(true);
		} else
			System.out.println("fc안됨");
	}

	public void SecondChange(String name) {
		mode.setVisible(false);
		if (name.equals("one")) {
			single_use.setVisible(true);
		} else if (name.equals("two")) {
			double_use.setVisible(true);
		} else
			System.out.println("sc안됨");
	}

	public void ThirdChange(String name) {
		if(name.equals("1")) {
			single_use.setVisible(false);
		}else if(name.equals("2")) {
			double_use.setVisible(false);
		}
		last.setVisible(true);
		for(int i=0; i<14; i++) {
			if(i==6 || i==13) {
				single_use.p[i]=0;
				double_use.p[i]=0;
				continue;
			}
			single_use.p[i]=4;
			double_use.p[i]=4;
		}
		single_use.repaint();
		double_use.repaint();
	}

	public void LastChange(String name) {
		
		last.setVisible(false);
		if (name.equals("restart")) {
			start.setVisible(true);
		}

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
