import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int com = random.nextInt(3);
		System.out.println(com);
		System.out.println("0.가위  1.바위  2.보");
		int you = sc.nextInt();
		
		int num = com - you;
		
		switch(num) {
		case 0: System.out.println("비겼습니다."); break;
		case -1: case 2: System.out.println("당신이 이겼습니다."); break;
		case 1: case -2: System.out.println("컴퓨터가 이겼습니다."); break;
		}

	}

}
