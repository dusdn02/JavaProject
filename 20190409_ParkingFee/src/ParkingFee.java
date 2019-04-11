
//분을 입력받아
//최초 30분은 2000원, 10분당 1000원
//주차요금을 출력하자
//5 -> 2000, 30 -> 2000, 40 -> 3000, 41 -> 4000
import java.util.Scanner;

public class ParkingFee {

	public static void main(String[] args) {
		int fee;
		Scanner sc = new Scanner(System.in);

		int pa = 0;
		// 분을 입력받자
		// 0이상 30분 이하면, 1500
		// 30분 초과 40분 이하면, 3000

//		if(0<= parkingMinutes && parkingMinutes <= 30) {
//			fee = 2000;
//		}else {
//		
//		int 십의자리 = parkingMinutes/10;
//		int 일의자리 = parkingMinutes%10;
//		fee = (십의자리-1)*1000;
//		if(일의자리 >= 1)
//			fee +=1000;
//		}

		System.out.println("(0).exit");

		while (true) {
			System.out.println("몇 분인가요?");
			int parkingMinutes = sc.nextInt();
			if (parkingMinutes >= 1440) {
				System.out.println("주차 시간은 24시간을 넘을 수 없습니다.");
				continue;
			} else if (parkingMinutes == 0)
				break;

			if ((parkingMinutes - 30) <= 0) {
				fee = 1500;
			} else {
				pa = (parkingMinutes - 30) / 10;
				if ((parkingMinutes - 30) % 10 > 0)
					pa++;
				fee = 1500 + pa * 1000;
			}

			if (fee >= 25000) {
				System.out.println("하루 최대 25000원입니다.");
			} else
				System.out.println("주차요금은 " + fee + "원 입니다.");

		}

	}

}
