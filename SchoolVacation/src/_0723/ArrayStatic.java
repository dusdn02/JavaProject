package _0723;

public class ArrayStatic {
	static int[] Link(int[] a, int b[]) {
		int[] sum = new int[a.length+b.length];
		
		for(int i=0; i<a.length; i++) {
			sum[i] = a[i];
		}
		for(int i=a.length; i<a.length+b.length;i++) {
			sum[i]=b[i-a.length];
		}
		
		return sum;
	}
	static void print(int sum[]){
		System.out.print("[");
		for(int i=0; i<sum.length;i++) {
			System.out.print(sum[i]+" ");
		}
		System.out.println("]");
	}

}
