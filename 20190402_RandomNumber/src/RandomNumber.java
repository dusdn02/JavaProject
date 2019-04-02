import java.util.Random;
import java.util.Scanner;

public class RandomNumber {

	public static void main(String[] args) {
		int start = 1;
		int end = 100;
		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("1~100���� ���� �� �ϳ��� �����ϼ���.");
		System.out.println("���ڰ� ������ �ͺ��� ũ�ٸ� (DOWN)'0'�� �۴ٸ� (UP)'1'�� �Է��ϰ� ������ '2'�� �Է��ϼ���.");
		System.out.println("�����Ϸ��� Enter�� ��������");

		String e = sc.nextLine();

		while (true) {
			int randomNumber = random.nextInt(end + 1 - start) + start;
			System.out.println(randomNumber);

			int you = sc.nextInt();

			if (you == 2) {
				System.out.println("�����Դϴ�");
				break;
			} else if (you == 0)
				end = randomNumber - 1;
			else if (you == 1)
				start = randomNumber + 1;

		} // while

	}

}
