import java.util.Scanner;

public class StudentNumber2Major {

	public static void main(String[] args) {
//		String major[][] = {{"뉴미디어소프트웨어과"
//		
//			Scanner sc = new Scanner(System.in);
//			
//			System.out.println("학번을 입력해주세요 >>");
//			String input = sc.nextLine();
//			
//			String grade = input.substring(0,1);
//			String classNum = input.substring(1,2);
//			
//			int gradNum = Integer.parseInt(grade);
//			int classNumber = Integer.parseInt(classNum);
//			
//			int classNumber2 = (classNumber - 1)/2;
		
		int year, clas;
		Scanner sc = new Scanner(System.in);
		System.out.println("학번을 입력하세용");
		String num = sc.next();
		
		year = num.charAt(0);
		clas = num.charAt(1);
		
		switch(year) {
		case '1': case '2':
			switch(clas) {
			case '1': case '2':
				System.out.println("뉴미디어소프트웨어과"); break;
			case '3': case '4':
				System.out.println("뉴미디어웹솔루션과"); break;
			case '5': case '6':
				System.out.println("뉴미디어디자인과"); break;
			}
			break;
		case '3':
			switch(clas) {
			case '1': case '2':
				System.out.println("인터랙티브미디어과"); break;
			case '3': case '4':
				System.out.println("뉴미디어디자인과"); break;
			case '5': case '6':
				System.out.println("뉴미디어웹솔루션과"); break;
			}
			break;
		}

	}

}
