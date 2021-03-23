package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class DaemonThreadDemo {
	public DaemonThreadDemo() {		
//		new Thread(new Runnable() {		
//			@Override
//			public void run() {
//				for(int i=0;i<20;i++){
//					System.out.println("child thread..........");
//					//try {Thread.sleep(2000);}catch(Exception e) {}
//				}
//			}
//		}).start();
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
				System.out.println("child thread....");
				try {Thread.sleep(200);}catch(Exception e) {}
			}
		});
	}
	public static void main(String[] args) {
		
		System.out.println("main thread started....");
		new DaemonThreadDemo();

		try {Thread.sleep(10000);}catch(Exception e) {}
		Thread.currentThread().setDaemon(true);
		
		
		System.exit(1);
		System.out.println("hello");
	}
}