package day13;
import java.util.*; 
public class Question9 {
	public static void main(String[] args) { 
		Object o = new Object(); 
		// insert code here 8.
//		Set s = new HashSet(); //compile and execute
//		TreeSet s = new TreeSet();// compile only
		LinkedHashSet s = new LinkedHashSet();//compile ans execute
		s.add("o"); 
		
		s.add(o); 
		
	}
}
