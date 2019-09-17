package _0801;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapNation {
	public static void main(String[] args) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);

		System.out.println("나라 이름과 인구를 5개 입력하세요.(예 : Korea 5000)");
		while (true) {
			System.out.print("나라 이름, 인구 >>");
			String nation = sc.next();
			if (nation.equals("그만")) {
				break;
			}
			int population = sc.nextInt();
			nations.put(nation, population);
		}

		while (true) {
			System.out.print("인구 검색 >>");
			String nation = sc.next();
			if (nation.equals("end"))
				break;
			Integer n = nations.get(nation);
			if (n == null)
				System.out.println(nation + "나라는 없습니다.");
			else
				System.out.println(nation + "의 인구는 " + n);
		}
		sc.close();
	}
}
