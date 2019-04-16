import java.util.Random;
import java.util.Scanner;

public class Mochippa {

	public static void main(String[] args) {
		int com, you, num;
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String rps[] = { "가위", "바위", "보" };

		while (true) {
			com = random.nextInt(3);
			System.out.println(com);
			System.out.println("0.가위  1.바위  2.보");
			you = sc.nextInt();

			num = com - you;

			if (num != 0)
				break;
			else
				System.out.println("비겼습니다. 다시 ");

		}

		A: while (true) {

			switch (num) {
			case 0:
				switch (num) {
				case -1:
				case 2:
					System.out.println("당신이 이겼습니다.");
					break;
				case 1:
				case -2:
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				}
				break A;
			case -1:
			case 2:
				System.out.println("공격 : 당신");
				com = random.nextInt(3);
				you = sc.nextInt();
				System.out.print("컴퓨터 : " + rps[com] + "  ");
				System.out.println("당신 : " + rps[you]);
				num = com - you;
				break;
			case 1:
			case -2:
				System.out.println("공격 : 컴퓨터");
				com = random.nextInt(3);
				you = sc.nextInt();
				System.out.print("컴퓨터 : " + rps[com] + "  ");
				System.out.println("당신 : " + rps[you]);
				num = com - you;
				break;
			}

		}

	}

}
