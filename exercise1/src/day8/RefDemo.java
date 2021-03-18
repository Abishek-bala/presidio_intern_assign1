package day8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class RefDemo {
	public static void main(String[] args)throws Exception {
		PoliceStation p1=new PoliceStation();
		Politician ramu=new Politician();
//		Doctor prakash=new Doctor();
		p1.arrest(ramu);
	}
}
class PoliceStation{
	public void arrest(Object p)throws Exception {
		Class c = p.getClass();
		Field f = c.getField("name");
		System.out.println(f.get(p));
		
		Method m = c.getMethod("doWork");
		m.invoke(p);
		
		f=c.getDeclaredField("secretName");
		f.setAccessible(true);
		System.out.println(f.get(p));
		
		m=c.getDeclaredMethod("secretWork");
		m.setAccessible(true);
		m.invoke(p);
	}
}
class Politician{
	public String name="good man";
	private String secretName="thief";
	
	public void doWork() {
		System.out.println("I do social work...........");
	}
	private void secretWork() {
		System.out.println("I trouble people and steal there money....");
	}
}
//class Doctor{
//	
//}