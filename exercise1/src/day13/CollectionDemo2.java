package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionDemo2 {
	public static void main(String[] args) {
		LinkedList<String> v=  new LinkedList<String>();
		v.add("aaa");
		v.add("bbb");
		v.add("ccc");
		
		Iterator<String> iter = v.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
//		Enumeration<String> e = v.elements();
//		while(e.hasMoreElements()){
//			System.out.println(e.nextElement());
//		}
	}
}
