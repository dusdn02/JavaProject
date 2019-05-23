import java.util.Scanner;

public class Page {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("몇개의 게시물이 있나요? (정수로 쓰세요)");
			int result = sc.nextInt();
			float page = (float) result / 7;

			if (page - (int) page > 0)
				page += 1;

			System.out.println((int) page + "페이지");

			System.out.println("종료하려면 exit를 입력해주세요");

			String choice = sc.next();

			if ("exit".equals(choice)) {
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}


//		Scanner sc = new Scanner(System.in);
//
//		int nPerPage = 7;
//
//		while (true) {
//
//			System.out.println("몇 개의 게시물을 표시할까요?(정수로 쓰세요.)  종료.(0)");
//			String inputString = sc.nextLine();
//			//if exit? -> exit
//			if(inputString.contentEquals("exit")) {
//				System.out.println("끝");
//				break;
//			}
//			//String -> int
//			int result = Integer.parseInt(inputString);
//			
////			if(result==0) {
////				System.out.println("끝");
////				break;
////			}
//		
//			//calculate page
//			int 결과 = result / nPerPage;
//			if (result % nPerPage != 0)
//				결과 = result / nPerPage + 1;
//
//			System.out.println(결과 + "페이지가 필요합니다.");
//
//		}
	}
}
