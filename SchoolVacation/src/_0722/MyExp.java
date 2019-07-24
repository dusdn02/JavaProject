package _0722;

public class MyExp {
	int base;
	int exp;
	public MyExp(int x, int y) {
		this.base=x;
		this.exp=y;
	}
	
	int getValue() {
		int sum=1;
		for(int i=0; i<exp; i++) {
			sum*=base;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		MyExp number1 = new MyExp(2,3);
		System.out.println(number1.getValue());
	}

}
