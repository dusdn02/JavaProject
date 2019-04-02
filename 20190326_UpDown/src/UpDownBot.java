import java.util.*;

public class UpDownBot {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int rNumber = 50, count = 0;
		float temp = 25;
		
		int start = 0,end =99;

		System.out.println("1~100까지 숫자 중 하나를 생각하세요.");
		System.out.println("숫자가 생각한 것보다 크다면 (DOWN)'0'을 작다면 (UP)'1'을 입력하고 맞으면 '2'을 입력하세요.");
		System.out.println("시작하려면 Enter를 누르세요");

		String e = sc.nextLine();

		while (true) {
			rNumber =(end-start)/2;

			System.out.println(rNumber);

			int you = sc.nextInt();

			if (you == 2) {
				break;
			} else if (you == 1) {
				start = rNumber+1;
			} else if (you == 0) {
				end = rNumber-1;
			}

			count++;


		} // while

		System.out.println(count + "번만에 맞췄습니다!!");

	}

}
