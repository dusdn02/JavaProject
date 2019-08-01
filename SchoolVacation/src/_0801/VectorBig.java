package _0801;

import java.util.Scanner;
import java.util.Vector;




public class VectorBig {
	
	public static void printBig(Vector<Integer> v) {
		int big = v.get(0);
		for(int i=1; i<v.size(); i++) {
			if(big < v.get(i))
				big = v.get(i);
		}
		
		System.out.println("���� ū ���� " + big);		
	}

	
	
	public static void main(String[] args) {
		Vector <Integer>v = new Vector<Integer>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����(-1�� �Էµ� ������)>>");
		while(true) {
			int n = sc.nextInt();
			if(n==-1)
				break;
			v.add(n);
		}
		
		if(v.size()==0) {
			System.out.print("���� �ϳ��� ����");
			sc.close();
			return;
		}
		printBig(v);
		sc.close();
	
	}

}
