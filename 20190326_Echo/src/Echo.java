import java.util.Scanner;

public class Echo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("�Է��ϼ���.");
			String inputString = sc.nextLine();

			if (inputString.equals("exit"))
				break;

			System.out.println("���>>" + inputString);
		}
		System.out.println("�����մϴ�.");

	}

}
