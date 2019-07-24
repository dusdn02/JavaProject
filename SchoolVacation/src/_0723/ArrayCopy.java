package _0723;

public class ArrayCopy {
	static void replaceSpace(char[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ')
				s[i] = ',';
		}
	}

	static void print(char[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		char str[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l' };
		replaceSpace(str);
		print(str);
	}

}
