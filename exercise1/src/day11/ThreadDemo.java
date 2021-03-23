package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	public ThreadDemo() {
		// TODO Auto-generated constructor stub
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(new Mythreaddemo());
		es.shutdown();
	}
	public static void main(String[] args) {
		new ThreadDemo();
		for(int i=0;i<5;i++) {
			System.out.println(i);
		}
	}
}

class Mythreaddemo implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("child thread");
	}
}
