import java.io.*;
import java.util.Scanner;

public class Scanner_File {

	public static void main(String[] args) {
		File Phone = new File("Phone.txt");
		FileWriter fw = null;
		String s;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("전화번호 입력프로그램입니다.");
			while (true) {
				System.out.print("name PhoneNumber>>");
				s = sc.nextLine();

				if (s.equals("그만")) {
					System.out.println("Phone.txt에 저장되었습니다.");
					break;
				}
				fw = new FileWriter(Phone, true);
				fw.write(s+"\n");
			}
			
			sc.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
