import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Single_use extends JPanel {
	private Main main =  null;
	Random random = new Random();
	int[] p = { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
	int turn = 0;// ����
	int tmp = 0;// �ű� ����
	int com_sum = 0;
	int user_sum = 0;
	int n = 0;
	int choice;

	Single_use(test t) {
//		super.setLayout(main.card);

		JButton[] ball = new JButton[13];// ���۵�
		for (int i = 0; i < 13; i++) {
			if (i == 6)
				continue;
			ball[i] = new JButton(Integer.toString(p[i]));
		} // ������ �ִ� �׾Ƹ��� ����
		
		setLayout(null);
		ball[0].setBounds(380, 338, 90, 40);
		ball[1].setBounds(590, 338, 90, 40);
		ball[2].setBounds(798, 338, 90, 40);
		ball[3].setBounds(1020, 338, 90, 40);
		ball[4].setBounds(1230, 338, 90, 40);
		ball[5].setBounds(1441, 338, 90, 40);
		ball[7].setBounds(385, 813, 90, 40);
		ball[8].setBounds(595, 813, 90, 40);
		ball[9].setBounds(794, 813, 90, 40);
		ball[10].setBounds(1025, 813, 90, 40);
		ball[11].setBounds(1235, 813, 90, 40);
		ball[12].setBounds(1452, 813, 90, 40);
		
		for (int i = 0; i < 13; i++) {
			add(ball[i]);
		}

		System.out.println("1�ο� �Դϴ�.");
		while (true) {
			n = main.Print_Game(p, n);
			
			if (turn % 2 == 0) {// �� ����
				int i;
				System.out.println("������");
				while (true) {

					for (int k = 0; k < 13; k++) {
						ball[k].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								choice = (int)e.getSource();

							}
						});
						add(ball[k]);
					}
					if (main.Check_position(p, choice) == true)
						break;
					else
						continue;
				}

				tmp = p[choice];
				p[choice] = 0;
				i = main.Insert_ball(p, tmp, choice, 13);
				if ((i + choice) == 7) {
					turn--;
					continue;
				}
				main.Get_ball(p, choice, i, 6);

				if (main.No_ball_Endgame(p, i, com_sum, 0, 7) == true)
					break;
			} else {// ��ǻ�� ����
				int i = 1;
				System.out.println("��ǻ�� ����");
				while (true) {
					choice = random.nextInt(6) + 7;
					if (p[choice] != 0)
						break;
				}
//						System.out.println("	*" + choice);
				tmp = p[choice];
				p[choice] = 0;
				i = main.Insert_ball(p, tmp, choice, 6);
				if ((i + choice) == 14) {
					turn--;
					continue;
				} // �ڱ� �׾Ƹ��� ������ ���� ������ �ѹ���
				main.Get_ball(p, choice, i, 13);

				if (main.No_ball_Endgame(p, i, com_sum, 7, 13) == true)
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

	}

}
