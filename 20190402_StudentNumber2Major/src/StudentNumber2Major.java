import java.util.Scanner;

public class StudentNumber2Major {

	public static void main(String[] args) {
		
		int year, clas;
		Scanner sc = new Scanner(System.in);
		System.out.println("�й��� �Է��ϼ���");
		String num = sc.next();
		
		year = num.charAt(0);
		clas = num.charAt(1);
		
		switch(year) {
		case '1': case '2':
			switch(clas) {
			case '1': case '2':
				System.out.println("���̵�����Ʈ�����"); break;
			case '3': case '4':
				System.out.println("���̵�����ַ�ǰ�"); break;
			case '5': case '6':
				System.out.println("���̵������ΰ�"); break;
			}
			break;
		case '3':
			switch(clas) {
			case '1': case '2':
				System.out.println("���ͷ�Ƽ��̵���"); break;
			case '3': case '4':
				System.out.println("���̵������ΰ�"); break;
			case '5': case '6':
				System.out.println("���̵�����ַ�ǰ�"); break;
			}
			break;
		}

	}

}
