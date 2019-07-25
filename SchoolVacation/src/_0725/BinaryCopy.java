package _0725;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopy {
	public static void main(String[] args) {
		File src = new File("c:\\windows\\explorer.exe");
		File dst = new File("C:\\javaproject\\SchoolVacation\\src\\_0725\\explorer.bin");
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		int c;
		try {
			fi = new FileInputStream(src);
			fo = new FileOutputStream(dst);
			in = new BufferedInputStream(fi);
			out = new BufferedOutputStream(fo);
			while((c= in.read())!=-1) {
				out.write((char)c);
			}
			in.close();
			out.close();
			fi.close();
			fo.close();
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
		
	}

}
