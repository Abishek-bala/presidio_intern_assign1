package Day4;
import java.util.*;
public class Question18 {
	public String numtoword(int n) {
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		hm.put(6, "six");
		hm.put(7, "seven");
		hm.put(8, "eight");
		hm.put(9, "nine");
		hm.put(0, "zero");
		String s="";
		ArrayList<String> w = new ArrayList<String>();
		while(n>0) {
			int a=n%10;
			w.add(hm.get(a));
			n/=10;
		}
		Collections.reverse(w);
		for(String i:w) {
			s+=i;
		}
		return s;
	} 
	public static void main(String[] args) {
		Question18 o = new Question18();
		System.out.println(o.numtoword(1234567890));
	}
}
