import java.util.Scanner;

public class NumberToWeekday {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int num = sc.nextInt();
		
		if(num==1)System.out.println("월요일");
		else if(num==2)System.out.println("화요일");
		else if(num==3)System.out.println("수요일");
		else if(num==4)System.out.println("목요일");
		else if(num==5)System.out.println("금요일");
		else if(num==6)System.out.println("토요일");
		else if(num==7)System.out.println("일요일");
		else System.out.println("잘못 입력했습니다.");
		
//		switch(num) {
//		case 1: System.out.println("월요일");break;
//		case 2: System.out.println("화요일");break;
//		case 3: System.out.println("수요일");break;
//		case 4: System.out.println("목요일");break;
//		case 5: System.out.println("금요일");break;
//		case 6: System.out.println("토요일");break;
//		case 7: System.out.println("일요일");break;
//		default: System.out.println("잘못 입력했습니다.");
//		}

	}

}
