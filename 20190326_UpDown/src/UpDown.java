import java.util.*;

public class UpDown {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		int rNumber = random.nextInt(100)+1;
		int count=0;

//		System.out.println(rNumber);

		while (true) {

			System.out.println("1~100의 숫자 하나를 입력하세요.");
			int you = sc.nextInt();
			count++;

			if (you == rNumber) {
				System.out.println("정답!!");
				break;
			} else if (you < rNumber)
				System.out.println("UP");
			else
				System.out.println("DOWN");

		}//while
		
		System.out.println(count + "번만에 맞추셨습니다!!");

	}

}
