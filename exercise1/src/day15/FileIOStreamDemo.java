package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOStreamDemo {
	public static void main(String[] args) throws Exception {
		final int EOF=-1;
		byte[] buff=new byte[512];
		FileInputStream in=new FileInputStream("abc.txt");
		FileOutputStream out=new FileOutputStream("Yourfile.txt");
		int reading;
		while((reading=in.read(buff))!=EOF){
			out.write(buff);
			}
		in.close();
		out.close();
	}
}
