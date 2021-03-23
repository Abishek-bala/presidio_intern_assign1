package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			Resource r = ThreadLocalUtility.getResource("1.0");
			System.out.println(r);
			r=ThreadLocalUtility.getResource("1.1");
			System.out.println(r);
		});
		
		es.execute(()->{
			Resource r = ThreadLocalUtility.getResource("2.0");
			System.out.println(r);
			r=ThreadLocalUtility.getResource("2.1");
			System.out.println(r);
		});
	}
}

class ThreadLocalUtility{
	private static ThreadLocal tLocal = new ThreadLocal();
	
	synchronized public static Resource getResource(String name) {
		Resource r = (Resource)tLocal.get();
		if(r==null) {
			r= new Resource(name);	
			tLocal.set(r);
		}
		r.name=name;
		return r;
	}
	
	public static void closeResource() {
		Resource r = (Resource)tLocal.get();
		if(r!=null) {
			tLocal.remove();
		}
	}
	
}

class Resource{
	String name;
	public Resource(String name) {
		System.out.println("resource obj created");
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}