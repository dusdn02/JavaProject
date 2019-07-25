package _0725;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fin = null;
//		InputStreamReader in = null;
		try {
			fin = new FileReader("C:\\javaproject\\SchoolVacation\\src\\_0725\\hangul.txt");
//			in = new InputStreamReader(fin, "MS949");
			int c;
			while((c= fin.read())!=-1) {
				System.out.print((char)c);
			}
			fin.close();
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
		
	}

}
