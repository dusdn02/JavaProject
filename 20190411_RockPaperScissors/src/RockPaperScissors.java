import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int com = random.nextInt(3);
		System.out.println("0.����  1.����  2.��");
		int you = sc.nextInt();
		
		int num = com - you;
		
		switch(num)

	}

}
