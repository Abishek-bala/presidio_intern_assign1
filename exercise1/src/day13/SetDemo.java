package day13;

import java.util.TreeSet;

public class SetDemo {
	
	public static void main(String[] args) {
		TreeSet<Students> t = new TreeSet<Students>((o1,o2)->{return o2.compareTo(o1);});	
		t.add(new Students(350));
		t.add(new Students(450));
		t.add(new Students(550));
		t.add(new Students(650));
		System.out.println(t);
	}
	
}

class Students implements Comparable<Students>{
	Integer marks;

	public Students(Integer marks) {
		
		this.marks = marks;
	}
	@Override
	public int compareTo(Students o) {
		// TODO Auto-generated method stub
		return marks.compareTo(o.marks);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.marks;
	}
	
}
