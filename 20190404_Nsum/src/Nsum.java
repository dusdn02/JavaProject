import java.util.Scanner;

public class Nsum {

	public static void main(String[] args) {
		int sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요>>");
		String num= sc.nextLine();
		
		for(int i=0; i<num.length(); i++) {
			char n = num.charAt(i);
		
			sum+=n - '0';
		}
		
		System.out.println(sum);

	}

}
