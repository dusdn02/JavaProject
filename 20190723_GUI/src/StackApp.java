import java.util.Scanner;

class StackApp{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("�� ���� ���� ������ ũ�� �Է� >> ");
		int n = sc.nextInt();
		StringStack ss = new StringStack(n);
		
		while(true) {
			System.out.print("���ڿ� �Է� (�� ġ�� �׸� �Է�) >> ");
			String str = sc.next();
			if(ss.push(str)==true) {
			}
			if(str.equals("�׸�")) {
				break;
			}
		}
		System.out.println("���ÿ� ����� ��� ������ �� >> "+ss.pop());
	}
}