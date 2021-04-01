package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
	Socket s;
	BufferedReader in , br;
	PrintWriter out;
	public Client() throws Exception {
		while(true) {
			s= new Socket("localhost",2500);
			
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String messagefromserver = in.readLine();
			System.out.println("Message from server : "+ messagefromserver );
			
			out = new PrintWriter(s.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter message to server");
			String msg = br.readLine();
			out.println(msg);	
		}
		
		
		
	}
	public static void main(String[] args) throws Exception {
		new Client();
	}
}