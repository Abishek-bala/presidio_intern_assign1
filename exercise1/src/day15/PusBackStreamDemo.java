package day15;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class PusBackStreamDemo {
	public static void main(String arg[]) throws Exception{
		ByteArrayInputStream bis = new ByteArrayInputStream("staffsupport".getBytes());
		PushbackInputStream pis = new PushbackInputStream(bis) ;
		int ch=0 ;
		while ((ch=pis.read())!=-1){
			if ((char) ch=='s')
				pis.unread('S') ;
			else
				System.out.print((char)ch);
			}
		
		}
	}

