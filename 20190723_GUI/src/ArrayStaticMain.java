
public class ArrayStaticMain {

	public static void main(String[] args) {
		ArrayStatic ar = new ArrayStatic();
		int[] a = {1,5,7,9};
		ar.print(a);
		int[] b = {3,6,-1,100,77};
		ar.print(b);
		int[] c = ar.Link(a,b);
		ar.print(c);
	}
}
