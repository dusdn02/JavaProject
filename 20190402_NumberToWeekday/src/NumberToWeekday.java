import java.util.Scanner;

public class NumberToWeekday {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���.");
		int num = sc.nextInt();
		
		if(num==1)System.out.println("������");
		else if(num==2)System.out.println("ȭ����");
		else if(num==3)System.out.println("������");
		else if(num==4)System.out.println("�����");
		else if(num==5)System.out.println("�ݿ���");
		else if(num==6)System.out.println("�����");
		else if(num==7)System.out.println("�Ͽ���");
		else System.out.println("�߸� �Է��߽��ϴ�.");
		
//		switch(num) {
//		case 1: System.out.println("������");break;
//		case 2: System.out.println("ȭ����");break;
//		case 3: System.out.println("������");break;
//		case 4: System.out.println("�����");break;
//		case 5: System.out.println("�ݿ���");break;
//		case 6: System.out.println("�����");break;
//		case 7: System.out.println("�Ͽ���");break;
//		default: System.out.println("�߸� �Է��߽��ϴ�.");
//		}

	}

}
