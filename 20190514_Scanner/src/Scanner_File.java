import java.io.*;
import java.util.Scanner;

public class Scanner_File {

	public static void main(String[] args) {
		File Phone = new File("Phone.txt");
		FileWriter fw = null;
		String s;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("��ȭ��ȣ �Է����α׷��Դϴ�.");
			while (true) {
				System.out.print("name PhoneNumber>>");
				s = sc.nextLine();

				if (s.equals("�׸�")) {
					System.out.println("Phone.txt�� ����Ǿ����ϴ�.");
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
