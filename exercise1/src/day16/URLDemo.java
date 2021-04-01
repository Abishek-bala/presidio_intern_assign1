package day16;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.google.com/index.html");
		
		URLConnection urlCon = url.openConnection();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		
		FileWriter out = new FileWriter("gogleindex.html");
		
		int i=0;
		char[] c= new char[128];
		while((i=br.read(c))!=-1) {
			String s = new String(c,0,i);
			System.out.println(s);
			out.write(c,0,i);
		}
		out.close();
		
	}
}
