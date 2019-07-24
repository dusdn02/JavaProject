import java.util.Scanner;

public interface Stack {
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}