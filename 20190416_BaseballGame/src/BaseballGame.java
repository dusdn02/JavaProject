import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		int SIZE = 5;
		int ball = 0, strike = 0;
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
//temp
		int ran[] = new int[SIZE];
		int num[] = new int[SIZE];

		ran[0] = random.nextInt(10);

//		while (ran[0] == ran[1] || ran[1] == ran[2] || ran[0] == ran[2]) {
//			ran[1] = random.nextInt(10);
//			ran[2] = random.nextInt(10);
//		}

		for (int i = 0; i < SIZE; i++) {
			ran[i] = random.nextInt(10);
			for (int j = 0; j < i; j++) {
				if (ran[i] == ran[j])
					i--;
			}
		} // 세자리 숫자가 중복되지 않도록

//		for(int i=0; i<SIZE;i++)
//			System.out.print(ran[i]);

		System.out.println(SIZE + "자리 숫자를 입력하세요.");

		while (true) {
			for (int i = 0; i < SIZE; i++)
				num[i] = sc.nextInt();

//		for(int i=0; i<SIZE;i++)
//			System.out.print(num[i]);

			strike = 0;
			ball = 0;

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (num[i] == ran[j]) {
						if (i == j)
							strike++;
						else
							ball++;
					}
				}
			}
			if (strike == 0 && ball == 0) {
				System.out.println("아웃!!");
			} else if (strike == SIZE) {
				System.out.println("정답입니다.");
				break;
			} else {
				System.out.println(strike + "S" + ball + "B");
			}
		}

	}

}
