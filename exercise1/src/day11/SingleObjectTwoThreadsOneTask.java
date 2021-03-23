package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleObjectTwoThreadsOneTask {
	public static void main(String[] args) {
		Gun g = new Gun();
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			for(int i=0;i<3;i++) {
				g.fill();
			}
		});
		
		es.execute(()->{
			for(int i=0;i<3;i++) {
				g.shoot();
			}
		});
	}
}

class Gun{
	
	boolean flag;
	
	synchronized public void fill(){
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("filling...");
		flag = true;
		notify();
	}
	
	synchronized public void shoot(){
		if(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("shooting...");
		flag = false;
		notify();
	}
	
}