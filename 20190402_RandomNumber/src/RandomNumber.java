import java.util.Random;
import java.util.Scanner;

public class RandomNumber {

	public static void main(String[] args) {
		int start = 1;
		int end = 100;
		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("1~100까지 숫자 중 하나를 생각하세요.");
		System.out.println("숫자가 생각한 것보다 크다면 (DOWN)'0'을 작다면 (UP)'1'을 입력하고 맞으면 '2'을 입력하세요.");
		System.out.println("시작하려면 Enter를 누르세요");

		String e = sc.nextLine();

		while (true) {
			int randomNumber = random.nextInt(end + 1 - start) + start;
			System.out.println(randomNumber);

			int you = sc.nextInt();

			if (you == 2) {
				System.out.println("정답입니다");
				break;
			} else if (you == 0)
				end = randomNumber - 1;
			else if (you == 1)
				start = randomNumber + 1;

		} // while

	}

}
