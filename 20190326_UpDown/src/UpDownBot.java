import java.util.*;

public class UpDownBot {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int rNumber = 50, count = 0;
		float temp = 25;
		
		int start = 0,end =99;

		System.out.println("1~100���� ���� �� �ϳ��� �����ϼ���.");
		System.out.println("���ڰ� ������ �ͺ��� ũ�ٸ� (DOWN)'0'�� �۴ٸ� (UP)'1'�� �Է��ϰ� ������ '2'�� �Է��ϼ���.");
		System.out.println("�����Ϸ��� Enter�� ��������");

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

		System.out.println(count + "������ ������ϴ�!!");

	}

}
