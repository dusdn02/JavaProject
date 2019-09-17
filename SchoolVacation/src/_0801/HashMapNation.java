package _0801;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapNation {
	public static void main(String[] args) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);

		System.out.println("���� �̸��� �α��� 5�� �Է��ϼ���.(�� : Korea 5000)");
		while (true) {
			System.out.print("���� �̸�, �α� >>");
			String nation = sc.next();
			if (nation.equals("�׸�")) {
				break;
			}
			int population = sc.nextInt();
			nations.put(nation, population);
		}

		while (true) {
			System.out.print("�α� �˻� >>");
			String nation = sc.next();
			if (nation.equals("end"))
				break;
			Integer n = nations.get(nation);
			if (n == null)
				System.out.println(nation + "����� �����ϴ�.");
			else
				System.out.println(nation + "�� �α��� " + n);
		}
		sc.close();
	}
}
