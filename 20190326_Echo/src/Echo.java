import java.util.Scanner;

public class Echo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("�Է�>>");
			String inputString = sc.nextLine();

			if (inputString.equals("exit"))
				break;

			System.out.println("���>>" + inputString);
		}//while
		
		System.out.println("�����մϴ�.");

	}//main

}
