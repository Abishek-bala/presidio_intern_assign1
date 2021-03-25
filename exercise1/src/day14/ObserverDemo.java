package day14;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm alrm =new FireAlarm();
		alrm.addObserver(new student());
		alrm.addObserver(new Teacher());
		alrm.setFire();
	}
}

class ThreadedObservable extends Observable{
	@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		super.addObserver(o);
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
			super.notifyObservers();
		
		
	}
}

class FireAlarm extends ThreadedObservable{
	public void setFire() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{
			setChanged();
			notifyObservers("there is a fire");
		});
		es.shutdown();
	}
}

class Teacher implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		runAway();
	}
	
	public void runAway() {
			System.out.println("teacher thinking");
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("teacher running");
	}
}

class student implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		runAway();
	}
	
	public void runAway() {
		
		System.out.println("student running");
	}
}
