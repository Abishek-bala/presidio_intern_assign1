package day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		Future f= es.submit(new MyCallable());
		
	
		
		String s = (String)f.get();
		Thread.sleep(1000);
		System.out.println(s);
		
		System.out.println("main");
		
		es.shutdown();
	}
}

class MyCallable implements Callable{
	@Override
	public Object call() throws Exception {
		System.out.println("called");
		Thread.sleep(1000);
		// TODO Auto-generated method stub
		return "hello world";
	}
}
