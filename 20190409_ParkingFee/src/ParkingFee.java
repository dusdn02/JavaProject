
//���� �Է¹޾�
//���� 30���� 2000��, 10�д� 1000��
//��������� �������
//5 -> 2000, 30 -> 2000, 40 -> 3000, 41 -> 4000
import java.util.Scanner;

public class ParkingFee {

	public static void main(String[] args) {
		int fee;
		Scanner sc = new Scanner(System.in);

		int pa = 0;
		// ���� �Է¹���
		// 0�̻� 30�� ���ϸ�, 1500
		// 30�� �ʰ� 40�� ���ϸ�, 3000

//		if(0<= parkingMinutes && parkingMinutes <= 30) {
//			fee = 2000;
//		}else {
//		
//		int �����ڸ� = parkingMinutes/10;
//		int �����ڸ� = parkingMinutes%10;
//		fee = (�����ڸ�-1)*1000;
//		if(�����ڸ� >= 1)
//			fee +=1000;
//		}

		System.out.println("(0).exit");

		while (true) {
			System.out.println("�� ���ΰ���?");
			int parkingMinutes = sc.nextInt();
			if (parkingMinutes >= 1440) {
				System.out.println("���� �ð��� 24�ð��� ���� �� �����ϴ�.");
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
				System.out.println("�Ϸ� �ִ� 25000���Դϴ�.");
			} else
				System.out.println("��������� " + fee + "�� �Դϴ�.");

		}

	}

}
