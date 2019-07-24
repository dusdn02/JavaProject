abstract class Calculator{
	public abstract int add(int a, int b);
	public abstract int subtract(int a, int b);
	public abstract double average(int[] a);
}

public class GoodCalc extends Calculator{

	public static void main(String[] args) {
		GoodCalc g = new GoodCalc();
		int[] av = {3,5,6,2,6,9};
		System.out.println("add : "+ g.add(3,6));
		System.out.println("subtract : "+ g.subtract(3,6));
		System.out.println("average : "+ g.average(av));
	}

	public int add(int a, int b) {
		return a+b;
	}

	public int subtract(int a, int b) {
		if(a>b)
			return a-b;
		else
			return b-a;
	}

	public double average(int[] a) {
		int sum =0;
		for(int i=0; i<a.length;i++) {
			sum+=a[i];
		}
		return (double)(sum/a.length);
	}
}

