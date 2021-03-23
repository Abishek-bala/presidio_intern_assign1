package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadDemo2 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		ReservationCounter rc = new ReservationCounter();
		es.execute(()->{
			Thread.currentThread().setName("Ram");
			synchronized(rc) {
			rc.bookTicket(1000);
			rc.getChange();}
		});
		
		es.execute(()->{
			Thread.currentThread().setName("shek");
			synchronized(rc) {
			rc.bookTicket(500);
			rc.getChange();}
		});
		es.shutdown();
	}
}

class ReservationCounter{
	int amt;
	public void bookTicket(int amount) {
		Thread t=Thread.currentThread();
		String name = t.getName();
		this.amt=amount;
		System.out.println("ticket for "+name+" amount = "+amt);
	}
	public void getChange() {
		System.out.println("change for="+Thread.currentThread().getName()+"="+(amt-100));
	}
}
