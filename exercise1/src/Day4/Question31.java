package Day4;
import java.util.*;

public class Question31 {
	
	public static void main(String[] args) {
		Stack o = new Stack();
		System.out.println(o.is_empty());
		o.push(1);
		o.push(2);
		o.push(3);
		System.out.println(o.peep());
		int p = o.pop();
		System.out.println(p);
		System.out.println(o.peep());
	}
}

class Stack{
ArrayList<Integer> s;
	Stack(){
		s = new ArrayList<Integer>();
	}
	
	public void disp() {
		if(s!=null) {
			System.out.println("si");
		}
	}
	
	public void push(int i) {
		s.add(i);
	}
	
	public int peep() {
		return s.get(s.size()-1);
	}
	
	public int pop() {
		int p = s.get(s.size()-1);
		s.remove(s.size()-1);
		return p;
	}
	
	public boolean is_empty() {
        return s.isEmpty();
	}
	
}


