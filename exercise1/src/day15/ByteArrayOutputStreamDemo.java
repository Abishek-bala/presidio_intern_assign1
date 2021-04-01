package day15;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamDemo {
	public static void main(String args[]) throws Exception {
		ByteArrayOutputStream f=new ByteArrayOutputStream();
		String s="Hello World";
		byte buf[]=s.getBytes();
		f.write(buf);
		byte b[]=f.toByteArray();
		for(int I=0;I<b.length;I++){
			System.out.println(b[I]);
			}
		} 
}
