import java.util.Random;
import java.util.Scanner;

public class Mochippa {

	public static void main(String[] args) {
		int com, you, num;
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String rps[] = { "����", "����", "��" };

		while (true) {
			com = random.nextInt(3);
			System.out.println(com);
			System.out.println("0.����  1.����  2.��");
			you = sc.nextInt();

			num = com - you;

			if (num != 0)
				break;
			else
				System.out.println("�����ϴ�. �ٽ� ");

		}

		A: while (true) {

			switch (num) {
			case 0:
				switch (num) {
				case -1:
				case 2:
					System.out.println("����� �̰���ϴ�.");
					break;
				case 1:
				case -2:
					System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
					break;
				}
				break A;
			case -1:
			case 2:
				System.out.println("���� : ���");
				com = random.nextInt(3);
				you = sc.nextInt();
				System.out.print("��ǻ�� : " + rps[com] + "  ");
				System.out.println("��� : " + rps[you]);
				num = com - you;
				break;
			case 1:
			case -2:
				System.out.println("���� : ��ǻ��");
				com = random.nextInt(3);
				you = sc.nextInt();
				System.out.print("��ǻ�� : " + rps[com] + "  ");
				System.out.println("��� : " + rps[you]);
				num = com - you;
				break;
			}

		}

	}

}
