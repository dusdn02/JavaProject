import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Double_use extends JPanel {
	private Main main;
	NameInput nameinput;
	int[] p = { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
	int turn = 0;// ����
	int tmp = 0;// �ű� ����
	int com_sum = 0;
	int user_sum = 0;
	int n = 0;
	int choice;

	Double_use(test t) {
		
//		super.setLayout(main.cards);

		JButton[] ball = new JButton[13];// ���۵�
		for (int i = 0; i < 13; i++) {
			if (i == 6)
				continue;
			ball[i] = new JButton(Integer.toString(p[i]));
		} // ������ �ִ� �׾Ƹ��� ����

		String user1 = nameinput.fn;
		String user2 = nameinput.sn;
		while (true) {
			n = main.Print_Game(p, n);

			if (turn % 2 == 0) {// 1 ����
				int i;
				while (true) {
					for (int k = 0; k < 13; k++) {
						ball[k].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								choice = (int) e.getSource();

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
				main.Get_ball(p, choice, i, 6);
				if ((i + choice) == 7) {
					turn--;
				}
				if (main.No_ball_Endgame(p, i, com_sum, 0, 7) == true)
					break;

			} else {
				int i;
				System.out.println(user2 + " ����");
				while (true) {
					for (int k = 0; k < 13; k++) {
						ball[k].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								choice = (int) e.getSource();

							}
						});
						add(ball[k]);
					}
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
				i = main.Insert_ball(p, tmp, choice, 6);

				main.Get_ball(p, choice, i, 13);
				if ((i + choice) == 14) {
					turn--;
				} // �ڱ� �׾Ƹ��� ������ ���� ������ �ѹ���
				if (main.No_ball_Endgame(p, i, com_sum, 7, 13) == true)
					break; // �ڽ��� ���� �׾Ƹ��� ���� ������ ����
			}
			turn++;
		} // while
		if (user_sum > com_sum)
			System.out.println(user1 + " Win~~!!!");
		else
			System.out.println(user2 + " Win~~!!!");
	}
}
