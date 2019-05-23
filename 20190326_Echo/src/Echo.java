import java.util.Scanner;

public class Echo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("입력>>");
			String inputString = sc.nextLine();

			if (inputString.equals("exit"))
				break;

			System.out.println("출력>>" + inputString);
		}//while
		
		System.out.println("종료합니다.");

	}//main

}
