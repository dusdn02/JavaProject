import java.util.*;

public class UpDown {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		int rNumber = random.nextInt(100)+1;
		int count=0;

//		System.out.println(rNumber);

		while (true) {

			System.out.println("1~100�� ���� �ϳ��� �Է��ϼ���.");
			int you = sc.nextInt();
			count++;

			if (you == rNumber) {
				System.out.println("����!!");
				break;
			} else if (you < rNumber)
				System.out.println("UP");
			else
				System.out.println("DOWN");

		}//while
		
		System.out.println(count + "������ ���߼̽��ϴ�!!");

	}

}
