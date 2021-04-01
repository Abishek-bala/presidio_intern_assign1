package day16;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.InputStreamReader;

public class Server {
	
	ServerSocket ss;
	Socket s;
	BufferedReader br,in;
	PrintWriter out;
	
	ExecutorService es ;
	
	public Server() throws Exception {
		ss =new ServerSocket(2500);
		es = Executors.newFixedThreadPool(2);
		System.out.println("server ready..");
		es.execute(()->{
			try{
				while(true) {
					s=ss.accept();
					System.out.println("client details : "+s);
					
					out = new PrintWriter(s.getOutputStream(),true);
					System.out.println("enter message to client");
					in = new BufferedReader(new InputStreamReader(System.in));
					String msg = in.readLine();
					out.println(msg);
					
					br=new BufferedReader(new InputStreamReader(s.getInputStream()));
					msg=br.readLine();
					System.out.println("Message From Client..:"+msg);
					
				}
				}catch(Exception e) {
					e.printStackTrace();
			}
				
		});
		
		
		
		
	}
	public static void main(String[] args) throws Exception {
		new Server();
	}
}
