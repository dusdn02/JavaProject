import java.util.Scanner;

public class Page {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("��� �Խù��� �ֳ���? (������ ������)");
			int result = sc.nextInt();
			float page = (float) result / 7;

			if (page - (int) page > 0)
				page += 1;

			System.out.println((int) page + "������");

			System.out.println("�����Ϸ��� exit�� �Է����ּ���");

			String choice = sc.next();

			if ("exit".equals(choice)) {
				System.out.println("�����մϴ�.");
				System.exit(0);
			}
		}

//		Scanner sc = new Scanner(System.in);
//
//		int nPerPage = 7;
//
//		while (true) {
//
//			System.out.println("�� ���� �Խù��� ǥ���ұ��?(������ ������.)  ����.(0)");
//			int result = sc.nextInt();
//			
//			if(result==0) {
//				System.out.println("��");
//				break;
//			}
//			
//			int ��� = result / nPerPage;
//			if (result % nPerPage != 0)
//				��� = result / nPerPage + 1;
//
//			System.out.println(��� + "�������� �ʿ��մϴ�.");
//
//		}
	}
}
