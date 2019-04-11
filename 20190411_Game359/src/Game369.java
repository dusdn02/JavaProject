
public class Game369 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i < 10000; i++) {
			String numberString = String.valueOf(i);
			int count = count369(numberString);
			if (count == 0)
				System.out.println(i);
			else {
				for (int k = 0; k < count; k++)
					System.out.print("¦");
				System.out.println();
			}
		}
	}

	private static int count369(String numberString) {
		int sum = 0;
		for (int i = 0; i < numberString.length(); i++) {
			char ch = numberString.charAt(i);
			if (ch == '3' || ch == '6' || ch == '9') {
				sum++;
			}
		}

		return sum;
	}

}
