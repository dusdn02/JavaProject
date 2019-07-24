import java.util.Scanner;

class StackApp{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int n = sc.nextInt();
		StringStack ss = new StringStack(n);
		
		while(true) {
			System.out.print("문자열 입력 (다 치면 그만 입력) >> ");
			String str = sc.next();
			if(ss.push(str)==true) {
			}
			if(str.equals("그만")) {
				break;
			}
		}
		System.out.println("스택에 저장된 모든 문자의 합 >> "+ss.pop());
	}
}