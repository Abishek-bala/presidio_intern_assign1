package day14;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class WeakHashDemo {
	public static void main(String[] args) {
		Map<Employee,String> m=new WeakHashMap<Employee, String>();
		m.put(new Employee(100), "aaa");
		m.put(new Employee(200), "bbb");
		m.put(new Employee(300), "ccc");
		
		System.out.println(m);
		System.gc();
		Set<Map.Entry<Employee,String>> s = m.entrySet();
		
		Iterator<Map.Entry<Employee,String>> i =s.iterator();
		
		while(i.hasNext()) {
			Map.Entry<Employee, String> me = i.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
		
	}
}

class Employee implements Comparable<Employee>{
	Integer eid;

	public Employee(Integer eid) {
//		super();
		this.eid = eid;
	}
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return eid.compareTo(o.eid);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.eid;
	}
}

